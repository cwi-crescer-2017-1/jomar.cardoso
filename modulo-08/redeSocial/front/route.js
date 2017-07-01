angular.module('app').config(function ($routeProvider) {

  $routeProvider

    // pública
    .when('/home', {
      controller: 'homeController',
      templateUrl: 'html/home.html'
    })

    // privada
    .when('/login', {
      controller: 'loginController',
      templateUrl: 'html/login.html'
    })

    // privada
    .when('/feed', {
      controller: 'feedController',
      templateUrl: 'html/feed.html'
    })

    // privado
    // .when('/privado', {
    //   controller: 'PrivadoController',
    //   templateUrl: 'privado/privado.html',
    //   resolve: {

    //     // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
    //     autenticado: function (authService) {
    //       return authService.isAutenticadoPromise();
    //     }
    //   }
    // })

    .otherwise('/home');
});
