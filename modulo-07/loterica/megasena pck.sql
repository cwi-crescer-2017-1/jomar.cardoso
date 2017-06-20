create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */    
    FUNCTION totalArrecadado   (v_id in number) return number AS
    v_total_arrecadado NUMBER;    
    BEGIN
        SELECT SUM(Valor)
        INTO v_total_arrecadado
        FROM Aposta
        WHERE IdConcurso = v_id;
        DBMS_OUTPUT.PUT_LINE('Total arrecadado: ' || v_total_arrecadado);        
        RETURN v_total_arrecadado;
    END totalArrecadado;   
   
    PROCEDURE geraProximoConcurso AS   
        v_acumulado NUMBER;
        v_id NUMBER;        
        V_Acumulou NUMBER;
        CURSOR c_Ultimo_Concurso IS
        SELECT Idconcurso, Acumulado_proximo_05, Acumulou
        FROM Concurso
        WHERE ROWNUM <= 1
        ORDER BY Idconcurso DESC; 
   
        v_Novo_Id NUMBER;
        v_Total_Arrecadado NUMBER;
        v_premio_bruto NUMBER;

   BEGIN      
        FOR concurso IN c_Ultimo_Concurso LOOP
          v_id := concurso.Idconcurso;
          v_Acumulou := concurso.Acumulou;
          v_acumulado := concurso.Acumulado_proximo_05;
           /*FETCH c_Ultimo_Concurso INTO v_id, v_sena, v_quina, v_quadra, v_acumulado;   */  
        END LOOP;
        v_Total_Arrecadado := totalArrecadado(v_id);
        IF v_Acumulou <> 0 THEN
            v_Total_Arrecadado := v_Total_Arrecadado + v_acumulado;
        END IF;
        DBMS_OUTPUT.PUT_LINE('Total Arrecadado: ' || v_Total_Arrecadado);
        v_premio_bruto := v_Total_Arrecadado * 0.453;
        v_Novo_Id := v_id + 1;
        DBMS_OUTPUT.PUT_LINE('Novo Id: ' || v_Novo_Id);
        salvaConcurso(v_Novo_Id, SYSDATE, v_premio_bruto);        
   END geraProximoConcurso;   
   
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as      
        v_acertos INTEGER;
        v_Ultima_aposta_premiada INTEGER;
        v_premio_quadra NUMBER;
        v_vencedores_quadra INTEGER;
        v_premio_quina NUMBER;
        v_vencedores_quina INTEGER;
        v_premio_sena NUMBER;
        v_vencedores_sena INTEGER;        
        CURSOR c_Verifica_Apostas IS
            SELECT a.Idaposta
            FROM Concurso c
            INNER JOIN Aposta a ON a.Idconcurso = c.Idconcurso
            WHERE c.Idconcurso = pConcurso;        
        CURSOR c_Verifica_Acertos(v_Id INTEGER) IS
            select  n.Numero numero
            from numero_aposta n
            INNER JOIN aposta a on a.idaposta = n.idaposta
            INNER JOIN Concurso c on c.Idconcurso = a.Idconcurso
            WHERE a.Idaposta = v_Id;        
        v_Primeira_dezena INTEGER;    
        v_Segunda_dezena INTEGER;    
        v_Terceira_dezena INTEGER;    
        v_Quarta_dezena INTEGER;    
        v_Quinta_dezena INTEGER;    
        v_Sexta_dezena INTEGER;
   begin
        SELECT Primeira_dezena INTO v_Primeira_dezena FROM Concurso WHERE Idconcurso = pConcurso;
        SELECT Segunda_dezena INTO v_Segunda_dezena FROM Concurso WHERE Idconcurso = pConcurso;
        SELECT Terceira_dezena INTO v_Terceira_dezena FROM Concurso WHERE Idconcurso = pConcurso;
        SELECT Quarta_dezena INTO v_Quarta_dezena FROM Concurso WHERE Idconcurso = pConcurso;
        SELECT Quinta_dezena INTO v_Quinta_dezena FROM Concurso WHERE Idconcurso = pConcurso;
        SELECT Sexta_dezena INTO v_Sexta_dezena FROM Concurso WHERE Idconcurso = pConcurso;        
        FOR a IN c_Verifica_Apostas LOOP
            v_acertos := 0;
            FOR b IN c_Verifica_Acertos(a.Idaposta) LOOP
                IF b.numero = v_Primeira_dezena THEN
                     /*DBMS_OUTPUT.PUT_LINE('acertou: ' || b.numero || ' ' || v_Primeira_dezena);*/
                     v_acertos := v_acertos + 1;
               ELSIF b.numero = v_Segunda_dezena THEN
                     /*DBMS_OUTPUT.PUT_LINE('acertou: ' || b.numero);*/
                     v_acertos := v_acertos + 1;
               ELSIF b.numero = v_Terceira_dezena THEN
                     /*DBMS_OUTPUT.PUT_LINE('acertou: ' || b.numero);*/
                     v_acertos := v_acertos + 1;
               ELSIF b.numero = v_Quarta_dezena THEN
                     /*DBMS_OUTPUT.PUT_LINE('acertou: ' || b.numero);*/
                     v_acertos := v_acertos + 1;
               ELSIF b.numero = v_Quinta_dezena THEN
                     /*DBMS_OUTPUT.PUT_LINE('acertou: ' || b.numero);*/
                     v_acertos := v_acertos + 1;
               ELSIF b.numero = v_Sexta_dezena THEN
                     /*DBMS_OUTPUT.PUT_LINE('acertou: ' || b.numero);*/
                     v_acertos := v_acertos + 1;
                END IF;            
            END LOOP;            
            IF v_acertos > 3 THEN
                DBMS_OUTPUT.PUT_LINE('Total acertos: ' || v_acertos);
                SELECT MAX(idaposta_premiada) INTO v_Ultima_aposta_premiada FROM Aposta_Premiada;
                INSERT INTO Aposta_premiada (   Idaposta_premiada, Idaposta, Acertos, Valor) 
                VALUES ( v_Ultima_aposta_premiada+1, a.Idaposta, v_acertos, 0);                            
            END IF;
        END LOOP; 
        SELECT Premio_quadra INTO v_premio_quadra FROM Concurso Where Idconcurso = pConcurso;
        SELECT Premio_quina INTO v_premio_quina FROM Concurso Where Idconcurso = pConcurso;
        SELECT Premio_sena INTO v_premio_sena FROM Concurso Where Idconcurso = pConcurso;
        
        SELECT count(1) 
        INTO v_vencedores_quadra 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = pConcurso
        AND Acertos = 4;
        
        SELECT count(1) 
        INTO v_vencedores_quina 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = pConcurso
        AND Acertos = 5;         
 
        SELECT count(1) 
        INTO v_vencedores_sena 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = pConcurso
        AND Acertos = 6;        
        
        
                UPDATE Aposta_premiada
        SET Valor = (v_premio_quadra/v_vencedores_quadra)
        WHERE Acertos = 4;   
                UPDATE Aposta_premiada
        SET Valor = (v_premio_quina/v_vencedores_quina)
        WHERE Acertos = 5;
                UPDATE Aposta_premiada
        SET Valor = (v_premio_sena/v_vencedores_sena)
        WHERE Acertos = 6;    
   end;
   
end pck_megasena;