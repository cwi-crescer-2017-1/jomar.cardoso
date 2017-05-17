

var aula1 = angular.module('aula1', []);

aula1.controller('dados-pokemon', ['$scope', function($scope){
    $scope.pokemon = {};
    $scope.pokemon.nome; 

    $scope.pokemons = [
        pokemon1 = {nome: 'pokemon 1'},
        {nome: 'pokemon 2'},
        {nome: 'pokemon 3'},
        {nome: 'pokemon 4'}
    ]

}]);

// aula1.controller('repetidor', function($scope){
//     $scope.pokemons [
//         pokemon1 = {nome: 'pokemon 1'},
//         pokemon2 = {nome: 'pokemon 2'},
//         pokemon3 = {nome: 'pokemon 3'}
//     ]
// });