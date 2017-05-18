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





  var got = angular.module('got', []);

  aula1.controller('filtra-pokemon', ['$scope', function($scope){
    fetch('https://api.got.show/api/characters').
    then(response => response.json())
      .then(char => {
        console.log(char)
      })
  })
