biblioteca.controller('menuController', function($scope, authService){
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioPublicador = authService.possuiPermissao('Publicador')
    $scope.usuarioRevisor = authService.possuiPermissao('Revisor')
    console.log($scope.usuarioLogado)
})
