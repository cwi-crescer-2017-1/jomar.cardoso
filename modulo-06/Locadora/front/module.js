var biblioteca = angular.module('biblioteca', ['ngRoute', 'auth']);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('biblioteca').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:63124/api/usuarios',
    //urlUsuario: 'http://localhost:54896/api/acesso',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/menu',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login',

    //Url para pedidos
    urlpedidos: 'http://localhost:63124/api/pedidos',

    //Url para produtos
    urlprodutos: 'http://localhost:63124/api/produtos',

    //Url para produtos
    urlpacotes: 'http://localhost:63124/api/pacotes',

    //Url para produtos
    urlopcionais: 'http://localhost:63124/api/opcionais',

    //Url para clientes
    urlclientes: 'http://localhost:63124/api/clientes'

});


