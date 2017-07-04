angular.module('app').controller('amigosController', function ($scope, amigosService, authService, $http, appConfig, $localStorage) {
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

  rejeitarAmigo(id) {
      amigosService.rejeitarAmigo()
      .then( response => {
          console.log(response.data)
        }
      )
  }


  function aceitarAmigo(id) {
    amigosService.aceitarAmigo()
      .then( response => {
          console.log(response.data)
        }
      )
  }


})
