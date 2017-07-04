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
        $scope.usuariosBuscados.forEach(p => p.botaoConvite = true )
        console.log(response.data);
        })
      }

    buscaUsuarios()

    $scope.adicionarAmigo = adicionarAmigo
    function adicionarAmigo(usuario) {
     buscaService.adicionarAmigo(usuario.id)
       .then(response => {
        usuario.botaoConvite = false
        usuario.botaoCancelaConvite = true
       })
    }

    $scope.naoAdicionarAmigo = naoAdicionarAmigo
    function naoAdicionarAmigo(usuario) {
       buscaService.naoAdicionarAmigo(usuario.id)
       .then(response => {
         usuario.botaoConvite = true
         usuario.botaoCancelaConvite = false
       })
    }


})
