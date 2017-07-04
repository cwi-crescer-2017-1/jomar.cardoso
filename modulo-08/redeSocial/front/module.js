angular.module('app', ['ngRoute', 'auth']);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('app').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:9090/api/logged-user',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/home',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});


angular.module('app').constant('appConfig', {

    urlUsuario: 'http://localhost:9090/api/usuario',
    urlHealth: 'http://localhost:9090/api/health',
    urlPostagem: 'http://localhost:9090/api/postagem',
    urlGostei: 'http://localhost:9090/api/gostei'
})


angular.module('app')
  .directive('backgroundImage', function(){
	return function(scope, element, attrs){
		attrs.$observe('backgroundImage', function(value) {
      // If I remove ::before it will apply image background to .item correctly.
      var style = "<style>"+
          ".item:before{background-color: blue}</style>"
      angular.element("head").append(style);
		});
	};
});
