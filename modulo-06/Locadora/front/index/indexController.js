angular.module('biblioteca').controller('indexController', function ($scope, authService, indexService) {
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioPublicador = authService.possuiPermissao('Publicador')
    $scope.usuarioRevisor = authService.possuiPermissao('Revisor')

    $scope.usuarioLogado = authService.isAutenticado()
    $scope.nomeIndexLogado
    $scope.logout = logout 
    $scope.verificarLogin = verificarLogin
    $scope.livroDetalhado = livroDetalhado
    authService.isAutenticado()

    verificarLogin()
    function verificarLogin() {
        $scope.usuarioLogado = authService.isAutenticado()
        let usuarioLogado = $scope.usuarioLogado
        if (usuarioLogado) {
            $scope.nomeIndexLogado = authService.getUsuario().Nome
        }
        $scope.usuarioPublicador = authService.possuiPermissao('Publicador')
        $scope.usuarioRevisor = authService.possuiPermissao('Revisor')

    }
    function logout() {
        authService.logout()
        $scope.usuarioLogado = authService.isAutenticado()
        verificarLogin()
    }
    
    function livroDetalhado(isbn) {
        indexService.livroDetalhado(isbn)
    }
});