var biblioteca = angular.module('biblioteca', ['ngRoute', 'auth']);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('biblioteca').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:54896/api/acessos',
    //urlUsuario: 'http://localhost:54896/api/acesso',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/',

    // Url para livros
    urlLivros: 'http://localhost:54896/api/livros'
});


