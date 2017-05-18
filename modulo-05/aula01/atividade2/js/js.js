var aula1 = angular.module('aula1', []);
console.log(aula1);

aula1.controller('filtra-pokemon', ['$scope', function($scope){
  $scope.filtro;
  $scope.pokemons = [
    pikachu = {nome: 'Pikachu', tipo: 'Raio'},
    charmander = {nome: 'Charmander', tipo: 'Fogo'},
    squartle = {nome: 'Squartle', tipo: 'Água'},
  ]
}]);

// url = 'http://pokeapi.co/api/v2/ability/34/'
//
// function lista(url){
//   fetch(url)
//     .then(response => response.json())
//     .then(p => {
//       console.log(p)
//       return p
//     })
// }
// console.log(lista(url))
