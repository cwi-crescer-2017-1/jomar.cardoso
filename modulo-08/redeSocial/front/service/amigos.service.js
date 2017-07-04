angular.module('app').factory('amigosService', function (appConfig, $http, $location) {

  let urlUsuario = appConfig.urlUsuario;

  function buscaSolicitacoes() {
    return $http({
        url: urlUsuario + '/solicitacoes',
        method: 'GET'
    })
  }

  rejeitarAmigo(id) {
    return $http({
        url: urlUsuario + '/cancelaramizade/' + id,
        method: 'POST'
    })
  }


  function aceitarAmigo(id) {
    return $http({
        url: urlUsuario + '/aceitaramizade/' + id,
        method: 'POST'
    })
  }

  return {
    buscaSolicitacoes : buscaSolicitacoes,
    aceitarAmigo: aceitarAmigo,
    rejeitarAmigo: rejeitarAmigo
  }
})
