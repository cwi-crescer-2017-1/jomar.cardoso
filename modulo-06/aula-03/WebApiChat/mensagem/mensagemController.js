chat.controller('mensagemController', function($scope, $routeParams, mensagemService){
     $scope.obterHorario = obterHorario
    $scope.usaurioLogado
    $scope.usuarios = [{}]
    $scope.mensagens = []
    $scope.novaMensagem = {}
    $scope.enviarMensagem = enviarMensagem
    $scope.obterUsuario = obterUsuario
    window.setInterval(function() {obterTodasMensagens()}, 1000);

    


    function obterUsuario(id) {
        var i;
        for (i = 0; i<$scope.usuarios.length; i++) {
            if($scope.usuarios[i].Id === id) {
                return $scope.usuarios[i]
            }
        }
        mensagemService
        .obterUsuario(id)
        .then(response =>  {
            console.log(response.data)
           $scope.usuarios.push(response.data[0])
           return response.data[0]
        })
    }

    function obterTodasMensagens() {
        mensagemService
        .obterTodasMensagens()
        .then(response => {
            $scope.mensagens = response.data;
        })
    }

    function enviarMensagem(novaMensagem) {
        novaMensagem.remetente = 2;
        mensagemService
        .enviarMensagem(novaMensagem)
        .then(response => {
            obterTodasMensagens()
            $scope.novaMensagem = {}
        })
    }
    function obterHorario(horario) {
        return horario.slice(11, 19)        
        // let dataFormatada = horario.replace(/T(\d{2})\:(\d{2})\:(\d{2})/), 
        //  let dataFormatada = $scope.dataDigitada.replace(/(\d{2})\/(\d{2})\/(\d{4})/, '$2.$1.$3');
    }
})