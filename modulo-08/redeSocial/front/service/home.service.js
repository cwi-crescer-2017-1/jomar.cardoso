angular.module('app').factory('homeService', function (appConfig, $http, $location) {

    let urlUsuario = appConfig.urlUsuario;
    let urlPostagem = appConfig.urlPostagem;

    // function getUsuarioLogado(username) {
    //     return $http({
    //         url: urlUsuario + '/login',
    //         params: {email: username},
    //         method: 'GET'
    //     })
    // }

    function publicar(publicacao) {
        return $http({
            url: urlPostagem,
            method: 'POST',
            data: publicacao
        })
    }

    function atualizarFeed() {
        return $http({
            url: urlPostagem,
            method: 'GET',
        })
    }

    return {
        publicar: publicar,
        atualizarFeed: atualizarFeed
    }
})