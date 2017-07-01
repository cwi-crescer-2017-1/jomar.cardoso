angular.module('app').factory('loginService', function (appConfig, $http, $location) {

    let urlUsuario = appConfig.urlUsuario;

    function cadastrar(novoUsuario) {
        return $http({
            url: urlUsuario,
            method: 'POST',
            data: novoUsuario
        })
    }

    return {
        cadastrar: cadastrar
    }
})