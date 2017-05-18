var aula1 = angular.module('aula1', []);
console.log(aula1);

aula1.controller('filtra-pokemon', ['$scope', function($scope){
  $scope.filtro;
  $scope.pokemons = [];
  for(let i=0; i<3; i++){
  let numero = (Math.floor((Math.random() * 191) + 1))
      url = `http://pokeapi.co/api/v2/pokemon-form/${numero}/`;
    fetch(url)
      .then(response => response.json())
      .then(p => {
         console.log(p)
         $scope.pokemons.push(p)
      })
  }
  console.log($scope.pokemons)
}]);
