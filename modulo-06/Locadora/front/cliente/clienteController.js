biblioteca.controller('clienteController', function($scope, authService, clienteService, $location){
    $scope.cadastrar = cadastrar
    $scope.cliente = {}

    function cadastrar(cliente) {
        clienteService.cadastrar(cliente)
        .then(response => {
            console.log(response)
        })
    }
})