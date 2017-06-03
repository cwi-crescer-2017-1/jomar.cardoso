var biblioteca = angular.module('biblioteca', ['ngRoute', 'auth']);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('biblioteca').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:3000/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/menu',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/'
});

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
        redirectTo: '/'
    })
})
