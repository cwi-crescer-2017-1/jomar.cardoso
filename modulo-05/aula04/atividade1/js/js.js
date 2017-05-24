var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/aulas', {
      controller: 'controller-aulas',
      templateUrl: 'aulas/aulas.html'
    })
    .when('/instrutores', {
      controller: 'controller-instrutores',
      templateUrl: 'instrutores/instrutores.html'
    })
    .otherwise({
      redirectTo: '/aulas'
    });
});


app.filter('trueFalse', () => nome => !!nome ? 'sim' : 'não')
app.filter('lpad2', () => numero => numero.toString().padStart(2, '0'))
