biblioteca.config(function($routeProvider){
    $routeProvider
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
    .when('/cliente', {
        controller: 'clienteController',
        templateUrl: 'cliente/cliente.html',
        resolve: {
            autenticado: function (authService) {
                return authService.isAutenticadoPromise()
            }
        }
    })
    // .when('/gerente', {
    //     controller: 'gerenteController',
    //     templateUrl: 'gerente/gerente.html',
    //     resolve: {
    //         autenticado: function (authService) {
    //             return authService.possuiPermissaoPromise('Gerente')
    //         }
    //     }
    // })
    .otherwise({
        redirectTo: '/menu'
    })
})