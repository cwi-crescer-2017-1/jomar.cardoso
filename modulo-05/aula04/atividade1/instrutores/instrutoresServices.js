app.factory('instrutoresServices', function($http, servicesAulas){

  let urlBase = 'http://localhost:3000/instrutor';

  //listar
  function listar() {
    return $http.get(urlBase)
  }

  //incluir
  function incluir() {

  }

  //alterar
  function alterar() {

  }

  //remover
  function remover() {

  }

  //verificar
  function verificar() {

  }

  return {
    listar: listar,
    incluir: incluir,
    alterar: alterar,
    remover: remover,
    verificar: verificar
  }
})
