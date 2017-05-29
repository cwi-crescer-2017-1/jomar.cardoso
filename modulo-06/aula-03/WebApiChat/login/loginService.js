chat.factory('loginService', function($http){


urlBaseUsuarios = 'http://localhost:59385/api/usuarios'
    let urlBase = 'http://localhost:61239/Api/Usuario';

  function obterUsuario() {
    return $http.get(urlBase);
  };

  function adicionarUsuario(usuario) {
    return $http.post(urlBase, usuario);
  };

  return {
    obterUsuario: obterUsuario,
    adicionarUsuario: adicionarUsuario,
  };


})