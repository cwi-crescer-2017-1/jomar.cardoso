angular.module('app').controller('homeController', function (homeService, $scope, authService, $http, appConfig, $localStorage) {

    // Cuidado pra não executar a função '()'
    $scope.logout = authService.logout;

    $http.get(appConfig.urlHealth).then(function (response) {
      console.log(response.data);
    });

    function sessaoUsuario() {
      console.log($localStorage.usuarioLogado.username) 
      homeService.getUsuarioLogado('jomar.jomar@cwi')
      .then(response => {
        $scope.usuarioLogado = response.data;
        console.log(response.data)
      })
    }

    sessaoUsuario()
    
  });
