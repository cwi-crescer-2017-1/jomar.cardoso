var aula = angular.module('aula', []);

aula.filter('trueFalse', () => nome => nome ? 'Sim' : 'Nao')

aula.controller('novos-instrutores', function($scope){
  $scope.instrutores = instrutores;
  $scope.aulas = aulas;
  $scope.incluir = (novoInstrutor) => {
    if($scope.formInstrutores.$invalid){
      return
    }
    $scope.instrutores.push(angular.copy(novoInstrutor))
    $scope.novoInstrutor = {}
  }
});

let instrutores = [
  {
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: false,
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
