angular.module('app').controller('buscaController', function (buscaService, $scope, authService, $http, appConfig, $localStorage) {

  $scope.botaoConvite = true
  $scope.botaoCancelaConvite = false

  $scope.usuariosBuscados = []
    //feed
    $scope.usuariosBuscados = []
    function buscaUsuarios() {
      buscaService.buscaUsuarios()
      .then(response => {
        $scope.usuariosBuscados = response.data
        console.log(response.data);
        })
      }

    buscaUsuarios()

    $scope.adicionarAmigo = adicionarAmigo
    function adicionarAmigo(id) {
     buscaService.adicionarAmigo(id)
       .then(response => {
        $scope.botaoConvite = false
        $scope.botaoCancelaConvite = true
       })
    }

    $scope.naoAdicionarAmigo = naoAdicionarAmigo
    function naoAdicionarAmigo(id) {
       buscaService.naoAdicionarAmigo(id)
       .then(response => {
        $scope.botaoConvite = true
        $scope.botaoCancelaConvite = false
       })
    }


})
