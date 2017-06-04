angular.module('biblioteca').controller('indexController', function ($scope, authService, indexService) {
    $scope.usuarioIndexLogado = authService.isAutenticado()
    $scope.nomeIndexLogado
    $scope.logout = logout 
    $scope.verificarLogin = verificarLogin
    $scope.livroDetalhado = livroDetalhado
    authService.isAutenticado()

    verificarLogin()
    function verificarLogin() {
        $scope.usuarioIndexLogado = authService.isAutenticado()
        let usuarioIndexLogado = $scope.usuarioIndexLogado
        if (usuarioIndexLogado) {
            $scope.nomeIndexLogado = authService.getUsuario().Nome
        }
    }
    function logout() {
        authService.logout()
        $scope.usuarioIndexLogado = authService.isAutenticado()
    }
    
    function livroDetalhado(isbn) {
        indexService.livroDetalhado(isbn)
    }
});