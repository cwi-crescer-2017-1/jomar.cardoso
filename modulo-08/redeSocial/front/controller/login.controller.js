angular.module('app').controller('loginController', function ($scope, authService, loginService, $location) {

  $scope.login = function (usuario) {
    authService.login(usuario)
    .then(
      function (response) {
        console.log(response);
        alert('Login com sucesso!');
      },
      function (response) {
        console.log(response);
        alert('Erro no Login!');
      });
  };

  $scope.cadastrar = function (novoUsuario) {
    loginService.cadastrar(novoUsuario)
    .then( response => {
      console.log(response)
      $location.path('/home')
    })
  }
  

});