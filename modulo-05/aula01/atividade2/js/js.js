var aula1 = angular.module('aula1', []);
console.log(aula1);

aula1.controller('filtra-pokemon', ['$scope', function($scope){
  $scope.filtro;
  $scope.pokemons = [
    pikachu = {nome: 'Pikachu', tipo: 'Raio'},
    charmander = {nome: 'Charmander', tipo: 'Fogo'},
    squartle = {nome: 'Squartle', tipo: 'Água'},
    bulbasauro = {nome: 'Bulbasauro', tipo: 'Folha'},
    machop = {nome: 'Machop', tipo: 'Físico'},
    arbok = {nome: 'Arbok', tipo: 'Tóxico'},
    miau = {nome: 'Miau', tipo: 'Físico'},
    articuno = {nome:'Articuno', tipo: 'Frio'},
    machamp = {nome: 'Machamp', tipo: 'Físico'},
    psyduck = {nome: 'Psy Duck', tipo: 'Mental'}
  ]
}]);
