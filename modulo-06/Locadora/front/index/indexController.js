angular.module('biblioteca').controller('indexController', function ($scope, authService, indexService) {
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioPublicador = authService.possuiPermissao('Publicador')
    $scope.usuarioGerente = authService.possuiPermissao('Gerente')

    $scope.usuarioLogado = authService.isAutenticado()
    $scope.nomeIndexLogado
    $scope.logout = logout 
    $scope.verificarLogin = verificarLogin
    $scope.pedidoDetalhado = pedidoDetalhado
    authService.isAutenticado()

    verificarLogin()
    function verificarLogin() {
        $scope.usuarioLogado = authService.isAutenticado()
        let usuarioLogado = $scope.usuarioLogado
        if (usuarioLogado) {
            $scope.nomeIndexLogado = authService.getUsuario().Nome
        }
        $scope.usuarioGerente = authService.possuiPermissao('Gerente')

    }
    function logout() {
        authService.logout()
        $scope.usuarioLogado = authService.isAutenticado()
        verificarLogin()
    }
    
    function pedidoDetalhado(isbn) {
        indexService.pedidoDetalhado(isbn)
    }
});