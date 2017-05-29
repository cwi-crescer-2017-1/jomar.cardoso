chat.factory('loginService', function($http){


urlBaseUsuarios = 'http://localhost:59385/api/usuarios'

  function obterUsuario() {
    return $http.get(urlBase);
  };

  function adicionarUsuario(mensagem) {
        return $http({
            method: "post",
            url: urlBaseUsuarios,
            data: {
                "Nome": usuario.remetente,
                "UrlFoto": mensagusuario.UrlFoto
              }
            
        })
    }

  return {
    obterUsuario: obterUsuario,
    adicionarUsuario: adicionarUsuario,
  };


})