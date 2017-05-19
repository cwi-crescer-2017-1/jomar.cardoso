var aula = angular.module('aula', []);

aula.controller('novos-instrutores', function($scope){
  $scope.instrutores = instrutores;
  $scope.aulas = aulas;


  $scope.incluir = () => {
    console.log($scope.novoInstrutor)
    $scope.instrutores.push($scope.novoInstrutor)
  }
});

let instrutores = [
  {
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }
];

let aulas = [
    'OO',
    'HTML e CSS',
    'Javascript',
    'AngularJS',
    'Banco de Dados I'
  ];