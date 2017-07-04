angular.module('app').controller('indexController', function (homeService, $scope, authService, $http, appConfig, $localStorage) {
    $scope.usuario = $localStorage.usuarioLogado
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuario;

    $scope.usuarioLogado = authService.isAutenticado()
    $scope.nomeIndexLogado
    $scope.logout = logout

    authService.isAutenticado()

    // function sessaoUsuario() {
    //   let    fotinho
    //   console.log($localStorage.usuarioLogado.nome)
    //   fotinho = `https://github.com/${$localStorage.usuarioLogado.nome}.png`;
    //   $scope.fotinho = fotinho;
    //   $scope.elementoUsuario = {"background-image" : `url(${fotinho})`}
    // }
    // sessaoUsuario()

    function logout() {
        authService.logout()
        $scope.usuarioLogado = authService.isAutenticado()
        verificarLogin()
    }




// daqui para baixo é da home
  $scope.verificarLogin = verificarLogin

    $http.get(appConfig.urlHealth).then(function (response) {
      console.log('servidor online? ' + response.data);
    });

    function verificarLogin() {
        $scope.usuarioLogado = authService.isAutenticado()
        $scope.usuario = $localStorage.usuarioLogado;
        let usuarioLogado = $scope.usuarioLogado
        if (usuarioLogado) {
            $scope.nomeIndexLogado = authService.getUsuario().Nome
        }
    }
    verificarLogin()



    //$scope.elementoUsuario = {"background-image" : `url(${$scope.fotinho})`}


    //publicar
    

    function logout() {
        authService.logout()
        $scope.usuarioLogado = authService.isAutenticado()
        verificarLogin()
    }



})
