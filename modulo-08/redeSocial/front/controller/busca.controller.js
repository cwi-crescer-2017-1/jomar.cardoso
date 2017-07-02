angular.module('app').controller('buscaController', function (buscaService, $scope, authService, $http, appConfig, $localStorage) {

  $scope.usuariosBuscados = []
    //feed
    $scope.usuariosBuscados = []
    function buscaUsuarios() {
      buscaService.buscaUsuarios()
      .then(response =>{
        $scope.usuariosBuscados = response.data
        console.log(response.data)
      })
    }
    buscaUsuarios()
})
