chat.factory("chatService", function ($http) {

    urlBaseMensagens = 'http://localhost:59385/api/mensagens'
    urlBaseUsuarios = 'http://localhost:59385/api/usuarios'
    
    return ({
        obterUsuario: obterUsuario,
        obterTodasMensagens: obterTodasMensagens,
        obterMensagem: obterMensagem,
        enviarMensagem: enviarMensagem
    });

    function obterUsuario(id) {
        return $http.get(urlBaseUsuarios+'/?id='+id);
    }

    function obterTodasMensagens() {
        return $http.get(urlBaseMensagens);
    }

    function obterMensagem(id) {
        return $http.get(urlBaseMensagens);
    }

    function enviarMensagem(mensagem) {
        return $http({
            method: "post",
            url: urlBaseMensagens,
            data: {
                "IdRemetente": mensagem.remetente,
                "Conteudo": mensagem.conteudo
                }
            
        })
    }
});
