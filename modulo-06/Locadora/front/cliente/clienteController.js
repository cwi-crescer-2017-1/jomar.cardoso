biblioteca.controller('clienteController', function($scope, authService, clienteService, $location){
    $scope.novoCliente = {}
    $scope.cadastrar = cadastrar
    $scope.cliente = {}
    $scope.sucesso = false;

    function cadastrar(cliente) {
        $scope.sucesso = false;
        clienteService.cadastrar(cliente)
        .then(response => {
            console.log(response)
            if(response.status == 200) {
                $scope.sucesso = true;
                $scope.novoCliente = {}
                $scope.cliente = {}
            }
        })
    }
})