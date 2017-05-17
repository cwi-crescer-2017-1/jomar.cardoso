document.addEventListener('DOMContentLoaded', function() {
  let url = 'https://anapioficeandfire.com/api/characters/'
  // let url = 'https://www.anapioficeandfire.com/api/characters?name='
  let formPesquisar = document.getElementById('form-pesquisar')
  let idPersonagem = document.getElementById('id-personagem')
  let detalhesNome = document.getElementById('detalhes-nome')
  let detalhesCodinome = document.getElementById('detalhes-codinome')
  let detalhesTitulo= document.getElementById('detalhes-titulo')
  let detalhesCasa= document.getElementById('detalhes-casa')


/*
Exercício 1: Busca por número
Crie um arquivo pokesearch.html (com javascript incluído) e implemente o evento
de click do botão para pesquisar pelo pokémon a partir do número digitado no
input. No retorno da requisição, renderize dentro de uma div as seguintes
informações do pokémon:
* Nome
* Número
* Sprite principal do pokémon (front_default)
* Lista de descrições dos tipos (pode ser um elemento <ul>)
Fique à vontade para estilizar a página como desejar. Compartilhe no slack com
seus colegas!
*/

  let botaoPesquisar = document.getElementById('botao-pesquisar');
  botaoPesquisar.onclick = function() {
    fetch(url+idPersonagem.value+'/').
    // fetch(url+idPersonagem.value).
    then(response => response.json())
    .then(json => {
      console.log(json)
      colocaCasa(json)
      colocaNome(json)
      colocaCodinome(json)
      colocaTitulo(json)
      document.getElementById("detalhes").style.display = "block";
    })
  }

  function colocaNome (json) {
    let nome = document.createElement('h2')
    nome.innerText = json.name;
    console.log(nome)
    detalhesNome.append(nome)
  }

  function colocaCasa (json) {
  fetch(json.allegiances[0]).
  then(response => response.json())
    .then(casa => {
      console.log(casa)
      let nomeCasa = document.createElement('p')
      nomeCasa.innerText = casa.name
      detalhesCasa.append(nomeCasa)
    })

  }

  function colocaCodinome (json) {
    let codinome = document.createElement('li')
    json.aliases.forEach(function(n){
      codinome = document.createElement('li')
      codinome.innerText = n
      detalhesCodinome.append(codinome)
      console.log(codinome)
    })
  }

  function colocaTitulo (json) {
    let titulo = document.createElement('li')
    json.titles.forEach(function(n){
      titulo = document.createElement('li')
      titulo.innerText = n
      detalhesTitulo.append(titulo)
      console.log(titulo)
    })
  }


/*
Exercício 2: Estatísticas
No mesmo arquivo pokesearch.html e seu respectivo javascript, altere a
exibição do pokémon para também conter uma lista com todas estatísticas
percentuais do pokémon (ex: 60% de speed).
Dica: utilize o elemento progress
*/

})


//
// fetch("https://anapioficeandfire.com/api/characters/582/")
//   .then(response => response.json())
//   .then(json => {console.log(json)})



// let abaStark = document.getElementById('aba-stark');
// abaStark.onclick = function() {
//   console.log("clicou...");
// }

// fetch("http://pokeapi.co/api/v2/pokemon/5/").then(response => response.json())
//   .then(json => {console.log("JSON 1", json)}
// )




























// function novoPersonagem(persona, nome, casa) {
//   persona = new Personagem(nome, casa)
// }
//
// var arrayCasas = [
// greyjoy = new Casa('Casa Greyjoy', 'Lula', 'Nós não semeamos!'),
// stark = new Casa('Casa Stark', 'Lobo', 'O inverto está chegando!'),
// baratheon = new Casa('Casa Baratheon', 'Veado', 'Nossa é a fúria!'),
// lannister = new Casa('Casa Lannister', 'Leão', 'Ouça me rugir!'),
// arryn = new Casa('Casa Arryn', 'falcão', 'Alto como a honra!'),
// targaryen = new Casa('Casa Targaryen', 'Dragão', 'Fogo e sangue!'),
// tyrell = new Casa('Casa Tyrell', 'Rosa', 'Crescendo Fortes!'),
// bolton = new Casa('Casa Bolton', 'Homem esfolado', 'Nossas lâminas são afiacas!'),
// dothraki = new Casa('Tribo Dothraki'),
// selvagem = new Casa('Selvagem')
// ]
//
// var arrayPersonagens = [
// daenarysTargaryen = new Personagem('Daenarys Targaryen', targaryen),
// jonSnow = new Personagem('Jon Snow', stark),
// gregorClegane = new Personagem('Gregor Clegane', lannister),
// cerseiBaratheon = new Personagem('Cersei Baratheon', lannister),
// aryaStark = new Personagem('Arya Stark', stark),
// sansaStark = new Personagem('Sansa Stark', stark),
// tyrionLannister = new Personagem('Tyrion Lannister', targaryen),
// khalDrogo = new Personagem('Khal Drogo', dothraki),
// joffreyBaratheon = new Personagem('Joffrey Baratheon', lannister),
// shae = new Personagem('Shae'),
// melisandre = new Personagem('Melisandre', baratheon),
// hodor = new Personagem('Hodor', stark),
// margaeryTyrell = new Personagem('Margaery Tyrell', tyrell),
// ygritte = new Personagem('Ygritte', selvagem),
// ramsaySnow = new Personagem('Ramsay Snow', bolton),
// sandorClegane = new Personagem('Sandor Clegane')
// ]
//
// function adicionarNasCasas(arrayCasas, arrayPersonagens) {
//   for(c of arrayCasas){
//     c.membros = arrayPersonagens.filter(a =>  (a.casa === c))
//   }
// }
// adicionarNasCasas(arrayCasas, arrayPersonagens)
//
// jonSnow.setNome = 'João das Neves'
//
// var jomar
//
// novoPersonagem(jomar, 'Jomar', stark)
//
// console.log(stark)
// console.log(jonSnow)
// console.log('UHUUUUUU',jomar)
// console.log(arrayCasas)
// console.log(arrayPersonagens)
// console.log(stark.membros)


fetch('https://api.got.show/api/characters').
then(response => response.json())
  .then(char => {
    console.log(char)
  })
