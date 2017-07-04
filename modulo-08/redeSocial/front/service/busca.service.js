angular.module('app').factory('buscaService', function (appConfig, $http, $location) {

    let urlUsuario = appConfig.urlUsuario;

    function buscaUsuarios() {
        return $http({
            url: urlUsuario + '/inimigos',
            method: 'GET'
        })
    }

    function adicionarAmigo(id) {
      return $http({
          url: urlUsuario + '/solicitaramizade/' + id,
          method: 'POST'
      })
    }

    function naoAdicionarAmigo(id) {
      return $http({
          url: urlUsuario + '/cancelarsolicitaramizade/' + id,
          method: 'POST'
      })
    }

    return {
        buscaUsuarios: buscaUsuarios,
        naoAdicionarAmigo: naoAdicionarAmigo,
        adicionarAmigo: adicionarAmigo
    }
})
