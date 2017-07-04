angular.module('app').controller('indexController', function (homeService, $scope, authService, $http, appConfig, $localStorage) {
    $scope.usuario = $localStorage.usuarioLogado
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuario;

    $scope.usuarioLogado = authService.isAutenticado()
    $scope.nomeIndexLogado
    $scope.logout = logout 

    authService.isAutenticado()

    

    function logout() {
        authService.logout()
        $scope.usuarioLogado = authService.isAutenticado()
        verificarLogin()
    }
    



// daqui para baixo é da home
$scope.verificarLogin = verificarLogin
    $scope.fotinho = ''
    $scope.publicar = publicar

    $scope.logout = authService.logout;

    $http.get(appConfig.urlHealth).then(function (response) {
      console.log(response.data);
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

    
    
    $scope.elementoUsuario = {"background-image" : `url(${$scope.fotinho})`}


    //publicar
    function publicar (publicacao) {
      //publicacao.usuario = {id: $localStorage.usuarioLogado.id}
      homeService.publicar(publicacao)
      .then(response => {
        console.log(response.data)
      })
    }

    function logout() {
        authService.logout()
        $scope.usuarioLogado = authService.isAutenticado()
        verificarLogin()
    }

    
    
})