biblioteca.controller('menuController', function($scope, authService){
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioColaborador = authService.possuiPermissao('Colaborador')
    $scope.usuarioAdministrador = authService.possuiPermissao('Administrador')
    console.log($scope.usuarioLogado)
})
