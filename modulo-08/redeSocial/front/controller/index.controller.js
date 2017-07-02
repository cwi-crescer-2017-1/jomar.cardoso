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

    function sessaoUsuario() {
      let    fotinho
      console.log($localStorage.usuarioLogado.nome) 
      fotinho = `https://github.com/${$localStorage.usuarioLogado.nome}.png`;
      $scope.fotinho = fotinho;    
      $scope.elementoUsuario = {"background-image" : `url(${fotinho})`}
    }
    sessaoUsuario()
    
    $scope.elementoUsuario = {"background-image" : `url(${$scope.fotinho})`}

    function publicar (publicacao) {
      publicacao.usuario = {id: $localStorage.usuarioLogado.id}
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

    //feed
    $scope.postagens = []
    function atualizarFeed() {
      homeService.atualizarFeed()
      .then(response =>{
        $scope.postagens = response.data
        console.log(response.data)
      })
    }
    atualizarFeed()
    
})