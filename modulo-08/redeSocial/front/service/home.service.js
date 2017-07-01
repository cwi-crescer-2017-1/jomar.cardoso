angular.module('app').factory('homeService', function (appConfig, $http, $location) {

    let urlUsuario = appConfig.urlUsuario;

    function getUsuarioLogado(username) {
        return $http({
            url: urlUsuario + '/login',
            // headers: {'username': `Basic ${username}`},
            params: {email: username},
            method: 'GET'
        })
    }

    return {
        getUsuarioLogado: getUsuarioLogado
    }
})