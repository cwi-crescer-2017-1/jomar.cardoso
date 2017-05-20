var aula = angular.module('aula', []);

aula.filter('trueFalse', () => nome => !!nome ? 'sim' : 'não')

aula.filter('lpad2', () => numero => numero.toString().padStart(2, '0'))

aula.controller('controller-aulas', function($scope){
  $scope.aulas = aulas
  $scope.incluirAula = function (novaAula) {
    if($scope.formNovaAula.$invalid){
      return
    }
    novaAula.id = $scope.aulas.length
    $scope.aulas.push(angular.copy(novaAula))
    $scope.novaAula = {}
  }
  $scope.alterarAula = function (aulaAlterada) {
    if($scope.formAlterarAula.$invalid){
      return
    }
    // console.log($scope.aulas.filter( a => a.id === aulaAlterada.id))
    // objeto = $scope.aulas.filter( a => a.id === aulaAlterada.id)
    for(aula of $scope.aulas) {
      if(aula.id === aulaAlterada.id){
        aula.nome = aulaAlterada.nome
      }
    }
  }
  $scope.excluirAula = function (aulaExcluida) {
    if($scope.formExcluirAula.$invalid){
      return
    }
    for(i=0; i<$scope.aulas.length; i++) {
      if($scope.aulas[i].id === aulaExcluida.id) {
        $scope.aulas.splice(i, 1)
      }
      $scope.aulas[i].id = i;
    }
  }
});

aula.controller('controller-funcionarios', function($scope){
  $scope.instrutores = instrutores;
})

let aulas = [
  {id: 0, nome: 'Orientação a objetos'},
  {id: 1, nome: 'Banco de Dados'},
  {id: 2, nome: 'HTML/CSS'}
];

let instrutores = [
  {
    id: 0,
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 29,
    email: 'bernardo@cwi.com.br',
    dandoAula: true,
    aula: [aulas[0], aulas[1]],
    urlFoto: 'https://avatars0.githubusercontent.com/u/526075?v=3&s=460'
  }
];
