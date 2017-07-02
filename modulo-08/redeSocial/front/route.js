angular.module('app').config(function ($routeProvider) {

  $routeProvider
    .when('/home', {
      controller: 'homeController',
      templateUrl: 'html/home.html',
      resolve: {
          autenticado: function (authService) {
            return authService.isAutenticadoPromise()
          }
      }
    })
    .when('/busca', {
      controller: 'buscaController',
      templateUrl: 'html/busca.html',
      resolve: {
          autenticado: function (authService) {
            return authService.isAutenticadoPromise()
          }
      }
    })
    .when('/login', {
      controller: 'loginController',
      templateUrl: 'html/login.html'
    })

    .when('/feed', {
      controller: 'feedController',
      templateUrl: 'html/feed.html'
    })
    .otherwise('/home');
});
