angular.module('app').controller('homeController', function (homeService, $scope, authService, $http, appConfig, $localStorage) {

    $scope.fotinho = '';

    $scope.logout = authService.logout;

    $http.get(appConfig.urlHealth).then(function (response) {
      console.log(response.data);
    });

    function sessaoUsuario() {
      let    fotinho
      console.log($localStorage.usuarioLogado.username) 
      homeService.getUsuarioLogado($localStorage.usuarioLogado.username)
      .then(response => {
        $scope.usuarioLogado = response.data;
        fotinho = `https://github.com/${response.data.nome}.png`;
        $scope.fotinho = fotinho;
    
    $scope.elementoUsuario = {"background-image" : `url(${fotinho})`}
        console.log(response.data)
      })
    }

    sessaoUsuario()

    //  var style = "<style>"+
    //       ".item:#nome-usuario{background-color: red}</style>"
    //   angular.element("head").append(style);

    
    $scope.elementoUsuario = {"background-image" : `url(${$scope.fotinho})`}
    
  });
