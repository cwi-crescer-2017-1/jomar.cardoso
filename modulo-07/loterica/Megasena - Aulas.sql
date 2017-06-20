        SELECT SUM(Valor)

        FROM Aposta
        WHERE IdConcurso = 1816;
               
        rollback;
        
        delete CONCURSO where idconcurso = 1825
        
        SELECT SYSDATE
        FROM DUAL
        
        
SELECT * FROM ACERTADORES
        
        
        
                SELECT *

        FROM NUMERO_APOSTA
        WHERE IdConcurso = 1816;
        
        
         
        SELECT * FROM CONCURSO
        
DECLARE
    v_Novo_Id  INTEGER;              
        
BEGIN
  PCK_MEGASENA.GERAPROXIMOCONCURSO();
        /*
        SELECT Idconcurso
        INTO v_Novo_Id
        FROM Concurso
        WHERE ROWNUM <= 1
        ORDER BY Idconcurso DESC; */  

  /*loterica.geraAposta(300000, v_Novo_Id);*/
--rollback; 
END;   


DECLARE
  PAPOSTAS NUMBER;
  PCONCURSO NUMBER;
BEGIN
  PAPOSTAS := 10;
  PCONCURSO := 1825;

  LOTERICA.GERAAPOSTA(
    PAPOSTAS => PAPOSTAS,
    PCONCURSO => PCONCURSO
  );
--rollback; 
END;

                SELECT *

        FROM Aposta
        WHERE IdConcurso = 1825;


select * from regra_rateio_premio

  select na.Numero
    from numero_aposta na
    inner join aposta a on a.idaposta = na.idaposta
    where a.idaposta = 300
    and na.numero = 6
    or na.numero = 9






























    DECLARE
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
        WHERE c.Idconcurso = 1824;
        
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
        SELECT Primeira_dezena INTO v_Primeira_dezena FROM Concurso WHERE Idconcurso = 1824;
        SELECT Segunda_dezena INTO v_Segunda_dezena FROM Concurso WHERE Idconcurso = 1824;
        SELECT Terceira_dezena INTO v_Terceira_dezena FROM Concurso WHERE Idconcurso = 1824;
        SELECT Quarta_dezena INTO v_Quarta_dezena FROM Concurso WHERE Idconcurso = 1824;
        SELECT Quinta_dezena INTO v_Quinta_dezena FROM Concurso WHERE Idconcurso = 1824;
        SELECT Sexta_dezena INTO v_Sexta_dezena FROM Concurso WHERE Idconcurso = 1824;
        
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
        
        
        SELECT Premio_quadra INTO v_premio_quadra FROM Concurso Where Idconcurso = 1824;
        SELECT Premio_quina INTO v_premio_quina FROM Concurso Where Idconcurso = 1824;
        SELECT Premio_sena INTO v_premio_sena FROM Concurso Where Idconcurso = 1824;
        
        SELECT count(1) 
        INTO v_vencedores_quadra 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = 1824
        AND Acertos = 4;
        
        SELECT count(1) 
        INTO v_vencedores_quina 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = 1824
        AND Acertos = 5;         
 
        SELECT count(1) 
        INTO v_vencedores_sena 
        FROM Aposta_premiada p
        INNER JOIN Aposta a ON a.Idaposta = p.Idaposta
        WHERE a.Idconcurso = 1824
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
   

   SELECT * FROM APOSTA_PREMIADA
   
   
   
rollback




DECLARE
  PCONCURSO NUMBER;
BEGIN
  PCONCURSO := 1824;

  PCK_MEGASENA.ATUALIZAACERTADORES(
    PCONCURSO => PCONCURSO
  );
--rollback; 
END;