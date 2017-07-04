angular.module('app').controller('amigosController', function ($scope, amigosService, authService, $http, appConfig, $location, $localStorage) {
  $scope.solicitacoesAmizade

  $scope.buscaSolicitacoes = buscaSolicitacoes
  function buscaSolicitacoes() {
    amigosService.buscaSolicitacoes()
    .then( response => {
        $scope.solicitacoesAmizade = response.data
      }
    )
  }
  buscaSolicitacoes()

$scope.rejeitarAmigo = rejeitarAmigo
  function rejeitarAmigo(id) {
      amigosService.rejeitarAmigo()
      .then( response => {
          console.log(response.data)
        }
      )
  }


  $scope.aceitarAmigo = aceitarAmigo
  function aceitarAmigo(id) {
    amigosService.aceitarAmigo(id)
      .then( response => {
          console.log(response.data)
          $location.path('/home')
        }
      )
  }


})
