biblioteca.controller('menuController', function($scope, authService){
    $scope.usuarioLogado = authService.possuiPermissao('Administrador')
    console.log($scope.usuarioLogado)
})
