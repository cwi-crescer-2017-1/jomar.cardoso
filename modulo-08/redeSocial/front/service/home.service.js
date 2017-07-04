angular.module('app').factory('homeService', function (appConfig, $http, $location) {

    let urlUsuario = appConfig.urlUsuario
    let urlPostagem = appConfig.urlPostagem
    let urlGostei = appConfig.urlGostei

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

    function buscarAmigos() {
        return $http({
            url: urlUsuario + '/amigos',
            method: 'GET'
        })
    }

    function apoiar(id) {
        return $http({
            url: urlGostei + '/' + id,
            method: 'POST'
        })
    }

    function desapoiar(id) {
        return $http({
            url: urlGostei + '/' + id + '/desgostar',
            method: 'DELETE'
        })
    }

    return {
        publicar: publicar,
        atualizarFeed: atualizarFeed,
        buscarAmigos: buscarAmigos,
        apoiar: apoiar,
        desapoiar: desapoiar
    }
})