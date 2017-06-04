biblioteca.config(function($routeProvider){
    $routeProvider
    .when('/', {
        controller: 'livrosController',
        templateUrl: 'livros/livros.html'
    })
    .when('/detalhado/:Isbn', {
        controller: 'livrosDetalhadoController',
        templateUrl: 'livrosDetalhado/livrosDetalhado.html'
    })
    .when('/login', {
        controller: 'loginController',
        templateUrl: 'login/login.html'
    })
    .when('/menu', {
        controller: 'menuController',
        templateUrl: 'menu/menu.html',
        resolve: {
            autenticado: function (authService) {
                return authService.isAutenticadoPromise()
            }
        }
    })
    .otherwise({
        redirectTo: '/livros'
    })
})