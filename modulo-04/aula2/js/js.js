var series = JSON.parse('[{"titulo":"Stranger Things","anoEstreia":2016,"diretor":["Matt Duffer","Ross Duffer"],"genero":["Suspense","Ficcao Cientifica","Drama"],"elenco":["Winona Ryder","David Harbour","Finn Wolfhard","Millie Bobby Brown","Gaten Matarazzo","Caleb McLaughlin","Natalia Dyer","Charlie Heaton","Cara Buono","Matthew Modine","Noah Schnapp"],"temporadas":1,"numeroEpisodios":8,"distribuidora":"Netflix"},{"titulo":"Game Of Thrones","anoEstreia":2011,"diretor":["David Benioff","D. B. Weiss","Carolyn Strauss","Frank Doelger","Bernadette Caulfield","George R. R. Martin"],"genero":["Fantasia","Drama"],"elenco":["Peter Dinklage","Nikolaj Coster-Waldau","Lena Headey","Emilia Clarke","Kit Harington","Aidan Gillen","Iain Glen  ","Sophie Turner","Maisie Williams","Alfie Allen","Isaac Hempstead Wright"],"temporadas":6,"numeroEpisodios":60,"distribuidora":"HBO"},{"titulo":"The Walking Dead","anoEstreia":2010,"diretor":["Jolly Dale","Caleb Womble","Paul Gadd","Heather Bellson"],"genero":["Terror","Suspense","Apocalipse Zumbi"],"elenco":["Andrew Lincoln","Jon Bernthal","Sarah Wayne Callies","Laurie Holden","Jeffrey DeMunn","Steven Yeun","Chandler Riggs ","Norman Reedus","Lauren Cohan","Danai Gurira","Michael Rooker ","David Morrissey"],"temporadas":7,"numeroEpisodios":99,"distribuidora":"AMC"},{"titulo":"Band of Brothers","anoEstreia":20001,"diretor":["Steven Spielberg","Tom Hanks","Preston Smith","Erik Jendresen","Stephen E. Ambrose"],"genero":["Guerra"],"elenco":["Damian Lewis","Donnie Wahlberg","Ron Livingston","Matthew Settle","Neal McDonough"],"temporadas":1,"numeroEpisodios":10,"distribuidora":"HBO"},{"titulo":"Bernardo The Master of the Wizards","anoEstreia":2017,"diretor":["James Bajczuk","Marcio Tesser","Andre Nunes"],"genero":["Terror","Caos","JavaScript"],"elenco":["Alana Weiss","Alexia Pereira","Bruno Aguiar","Camila Batista","Christopher Michel","Claudia Moura","Deordines Tomazi","Diandra Rocha","Jabel Fontoura","João Silva","Jomar Cardoso","Leonardo Alves","Leonardo Morais","Lucas Damaceno","Lucas Gaspar","Lucas Muller","Luis Robinson","Maico Kley","Mateus Silva","Mathias Ody","Mirela Adam","Rafael Barizon","Rafael Barreto","Tais Silva","William Goncalves"],"temporadas":1,"numeroEpisodios":40,"distribuidora":"CWI"},{"titulo":"10 Days Why","anoEstreia":2010,"diretor":["Brendan Eich"],"genero":["Caos","JavaScript"],"elenco":["Brendan Eich","Bernardo Bosak"],"temporadas":10,"numeroEpisodios":10,"distribuidora":"JS"},{"titulo":"Mr. Robot","anoEstreia":2018,"diretor":["Sam Esmail"],"genero":["Drama","Techno Thriller","Psychological Thriller"],"elenco":["Rami Malek","Carly Chaikin","Portia Doubleday","Martin Wallström","Christian Slater"],"temporadas":2,"numeroEpisodios":22,"distribuidora":"USA Network"},{"titulo":"Narcos","anoEstreia":2015,"diretor":["Paul Eckstein","Mariano Carranco","Tim King","Lorenzo O Brien"],"genero":["Documentario","Crime","Drama"],"elenco":["Wagner Moura","Boyd   Holbrook","Pedro Pascal","Joann Christie","Mauricie Compte","André Mattos","Roberto Urbina","Diego Cataño","Jorge A. Jiménez","Paulina Gaitán","Paulina Garcia"],"temporadas":2,"numeroEpisodios":20,"distribuidora": null},{"titulo":"Westworld","anoEstreia":2016,"diretor":["Athena Wickham"],"genero":["Ficcao Cientifica","Drama","Thriller","Acao","Aventura","Faroeste"],"elenco":["Evan N. Rachel Wood","Thandie U. Newton","Jeffrey N. Wright","James E. Marsden","Ben S. Barnes","Ingrid I. Bolso Berdal","Clifton L. Collins Jr.","Luke L. Hemsworth","Sidse U. Babett Knudsen","Simon M. Quarterman","Rodrigo I. Santoro","Tessa N. Thompson","Shannon A. Woodward","Ed T. Harris","Anthony I. Hopkins"],"temporadas":1,"numeroEpisodios":10,"distribuidora":"HBO"},{"titulo":"Breaking Bad","anoEstreia":2008,"diretor":["Vince Gilligan","Michelle MacLaren","Adam Bernstein","Colin Bucksey","Michael Slovis","Peter Gould"],"genero":["Acao","Suspense","Drama","Crime","Humor Negro"],"elenco":["Bryan Cranston","Anna Gunn","Aaron Paul","Dean Norris","Betsy Brandt","RJ Mitte"],"temporadas":5,"numeroEpisodios":62,"distribuidora":"AMC"}]');
console.log(series);

/*
Exercício 1: Séries Inválidas
Nesse exercício deverá ser implementada uma função chamada
seriesInvalidas(series)  que recebe o array de séries, verifica quais são as
séries inválidas e retorna o título das séries inválidas em formato String.
Exemplo:
seriesInvalidas(series); // retorna "Séries Inválidas: Série 1 - Série 2 ..."
Condições para as séries serem inválidas:
Ano de estreia maior que o ano atual;
Possuir algum campo que seja undefined ou nullo.
*/
console.log("===EXERCICIO 1===")
function seriesInvalidas(series){
   console.log("SERIES INVÁLIDAS")
   series.forEach(function(serie, index){
     if (serie.anoEstreia > (new Date()).getFullYear() || verificaUndefined(serie)) {
       console.log("Série", index+1, serie.titulo)
     }
   })
 }
 function verificaUndefined(serie) {
     for (var i in serie){
         if(serie[i] === "" || typeof serie[i] === "undefined" || serie[i] === null){
           return true
         }
     }
 }
seriesInvalidas(series)

/*
Exercício 2: Séries a partir de um determinado ano
Nesse exercício deverá ser implementada uma função chamada filtrarSeriesPorAno(series, ano) que recebe o array de séries
 e devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.
Exemplo:
filtrarSeriesPorAno(series, 2017); // retorna um array com todas as séries com ano de estreia igual ou maior que 2017.
*/
console.log("===EXERCICIO 2===")
function filtrarSeriesPorAno(series, ano) {
  var retorno = []
  series.forEach(function(serie){
    if(serie.anoEstreia >= ano) {
      retorno.push(serie)
    }
  })
  return retorno
}
console.log(filtrarSeriesPorAno(series, 2017))

/*
Exercício 3: Média de Episódios
Crie uma função chamada mediaDeEpisodios(series) que recebe o array de séres e retorna a média dos episódios de todas as séries contidas no array.
Exemplo:
mediaDeEpisodios(series); // retorna o valor da média da soma dos episódios/quantidade de séries no array.
*/

console.log("===EXERCICIO 3===")
function mediaDeEpisodios(series) {
  var media = 0;
  series.forEach(function(serie){
    media += (serie.numeroEpisodios)
  })
  return media = media / series.length
}
console.log(mediaDeEpisodios(series))

/*
Exercício 4: Eu sou um ator de séries?
Crie uma função chamada procurarPorNome(series, nome) que recebe um array de séries e um nome e
caso esse nome possua no elenco das séries, retorna true.
Exemplo:
Dica: No campo nome da função experimente passar seu próprio nome.
*/
console.log("===EXERCICIO 4===")

function procurarPorNome(series, nome) {
  var boolea = false
  series.forEach(function(serie){
    for(ator of serie.elenco) {
      // console.log(ator)
      if(ator === nome) {
        //  console.log(ator)
        //  console.log(typeof boolea)
         boolea = true
      }
    }
  })
  return boolea
}
if(procurarPorNome(series, 'Jomar Cardoso')) {
  console.log('Jomar Cardoso está em algum elenco')
}
if(procurarPorNome(series, 'Christopher Michel')) {
  console.log('Christopher Michel está em algum elenco')
}
if(!procurarPorNome(series, 'Pompom')) {
  console.log('Pompom não está em elenco algum')
}

/*
Exercicio 5: Mascada em Serie
Uma serie tem seu elenco e diretor(es), mas para ela acontecer, eles devem ser pagos.
Crie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada serie.
 Para isso, suponha que os Big-Bosses, os Diretores, ganhem R$ 100.000; Enquanto os operarios os peões o pessoal do elenco ganha R$ 40.000;
*/

console.log("===EXERCICIO 5===")
function mascadaEmSerie(series) {
  var mascada
  series.forEach(function(serie, index){
    console.log(serie.titulo, 'salario total:', ((serie.elenco.length*40000) + (serie.diretor.length*100000)))
  })
}
mascadaEmSerie(series)

/*
Exercicio 6: Buscas!
A - Não sei o que quero assitir, mas quero ver CAOS! Escreva uma função chamada queroGenero que
 retorne um array, com os títulos dos filmes que são correspondentes com o genero do parâmetro.
Exemplo:
queroGenero("Caos"); // Retorna ["Bernardo The Master of the Wizards", "10 Days Why"]
B - Sei exatamente o que quero assisitir! Escreva uma função chamada queroTitulo que
retorne um array, com os títulos dos filmes que tem título semelhante ao passado
Exemplo:
queroTitulo("The"); // Retorna ["The Walking Dead", "Bernardo The Master of the Wizards"]
E ai, tudo tranquilo até agora? Manjando dos paranauês? Tem os dom?
Vamos começar a dificultar um pouco mais.
*/

console.log("===EXERCICIO 6===")



/*
Exercicio 7

Creditos

Ao final de um episódio, temos os créditos do episódio. Para isso vamos implementar uma função, chamada de creditosIlluminatis Recebendo uma serie como parâmetro e imprima os créditos a partir dela. Deverá ser impresso, o Titulo da serie, os Diretores, avisando com um título que é o bloco deles; Em seguida vem o elenco, também com um título de Elenco;

Tranquilo né? Easy! MAS, tem o seguinte: Os créditos são sempre ordenados alfabéticamente, mas pelo ULTIMO NOME!! Faça os ajustes necessários para que isso seja possível

Consulte as interwebsss para ajudar

Exercicio 8

Serie Illuminati

Escondemos um pequeno easter egg neste exercicio!

Para que ele seja descoberto, será necessário algumas informações;

Quando abreviamos um nome colocamos a primeira letra do nome seguida de um ponto final Exemplo:

Bernardo Bosak Rezende -> Bernardo B. Rezende
Augusto Schiller Wartchow -> Augusto S. Wartchow
Essa é a informação básica; Construa uma função que identificará aquela série que tem TODOS do elenco com nomes abreviados.

Dica: Contrua uma função separada para identificar se aquela string tem a abreviação;

Show de bola, estamos quase lá!

Uma vez achada a serie, vamos modificar um pouquinho a implementação. Coloque todas as palavras abreviadas (de preferência sem os pontos finais) em uma string que será retornada ao final do método.

Forme uma hashtag com a palavra! #PALAVRA

Ao commitar, coloque no comentario do commit o que achou ;)

Um bom FDS!

NÃO SURTEM!!
*/
