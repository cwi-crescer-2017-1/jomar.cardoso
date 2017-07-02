angular.module('app').factory('buscaService', function (appConfig, $http, $location) {

    let urlUsuario = appConfig.urlUsuario;

    function buscaUsuarios() {
        return $http({
            url: urlUsuario,
            method: 'GET'
        })
    }

    return {
        buscaUsuarios: buscaUsuarios
    }
})