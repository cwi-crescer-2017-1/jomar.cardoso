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
    .when('/crud/:operacao', {
        controller: 'crudController',
        templateUrl: 'crud/crud.html',
        resolve: {
            autenticado: function (authService) {
                return authService.isAutenticadoPromise()
            }
        }
    })
    .when('/revisor', {
        controller: 'revisorController',
        templateUrl: 'revisor/revisor.html',
        resolve: {
            autenticado: function (authService) {
                return authService.possuiPermissaoPromise('Revisor')
            }
        }
    })
    .otherwise({
        redirectTo: '/'
    })
})