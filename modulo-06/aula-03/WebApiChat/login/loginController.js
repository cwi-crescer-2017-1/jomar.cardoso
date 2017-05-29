chat.controller('loginController', function($scope, $routeParams, loginService, $localStorage){

    $scope.adicionarUsuario = adicionarUsuario

    
    function adicionarUsuario(usuario){
        loginService.adicionarUsuario(usuario).then(function (response){
            localStorage.setItem('nome', novoUsuario.Nome,toString());
            localStorage.setItem('foto', novoUsuario.UrlFoto,toString());
            location.href = '#!/mensagem';
        });
    }

})