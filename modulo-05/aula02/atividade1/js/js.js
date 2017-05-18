var aula1 = angular.module('aula1', []);
console.log(aula1);

aula1.controller('imprime-datas', ['$scope', function($scope){
  // $scope.filtro;
  // $scope.pokemons = [
  //   pikachu = {nome: 'Pikachu', tipo: 'Raio'},
  //   charmander = {nome: 'Charmander', tipo: 'Fogo'},
  //   squartle = {nome: 'Squartle', tipo: 'Água'},
  //   bulbasauro = {nome: 'Bulbasauro', tipo: 'Folha'},
  //   machop = {nome: 'Machop', tipo: 'Físico'},
  //   arbok = {nome: 'Arbok', tipo: 'Tóxico'},
  //   miau = {nome: 'Miau', tipo: 'Físico'},
  //   articuno = {nome:'Articuno', tipo: 'Frio'},
  //   machamp = {nome: 'Machamp', tipo: 'Físico'},
  //   psyduck = {nome: 'Psy Duck', tipo: 'Mental'}
  // ]
  $scope.data;
  $scope.geraData = geraData
  function geraData() {
    toString($scope.data)
    var separado = $scope.data.split('/')
    console.log($scope.data)
    resultado = 0
    resultado = 
    resultado = (separado[0] * 43200000)*separado[1]*(separado[2]-1970)
    console.log(separado)
    console.log(resultado)
  }
}]);
