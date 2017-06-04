angular.module('biblioteca').controller('loginController', function ($scope, authService) {

  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          $scope.verificarLogin()    
        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });
  };

});