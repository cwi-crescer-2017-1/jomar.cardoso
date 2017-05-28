var chat = angular.module('chat', []);

chat.controller('chatController', function ($scope, chatService) {
    $scope.usuario = {}
    $scope.mensagens = []
    $scope.novaMensagem = {}
    $scope.enviarMensagem = enviarMensagem
    $scope.obterUsuario = obterUsuario
    obterTodasMensagens();   
    obterUsuario(1); 

    function obterUsuario(id) {
        chatService
        .obterUsuario(id)
        .then(response =>  {
            console.log(response.data)
           return $scope.usuario = response.data[0]
        })
    }

    function obterTodasMensagens() {
        chatService
        .obterTodasMensagens()
        .then(response => {
            $scope.mensagens = response.data;
        })
    }

    function enviarMensagem(novaMensagem) {
        novaMensagem.remetente = $scope.usuario;
        chatService
        .enviarMensagem(novaMensagem)
        .then(response => {
            obterTodasMensagens()
            $scope.novaMensagem = {}
        })
    }
});

