biblioteca.controller('clienteController', function($scope, $routeParams, authService, clienteService, $location){
    $scope.operacao = $routeParams.operacao;
    $scope.novoCliente = {}
    $scope.cadastrar = cadastrar
    $scope.cliente = {}
    $scope.sucesso = false;
    $scope.buscarCliente = buscarCliente

    function buscarCliente(cpf) {
        clienteService.buscarCliente(cpf)
        .then(response => {
            $scope.cliente = response.data.dados
            $scope.cliente.CpfCliente = cpf
            console.log(response.data.dados)
            $scope.cliente.DataNascimento = new Date(response.data.dados.DataNascimento)
            $scope.cliente.Genero = toString(response.data.dados.DataNascimento)
        })
    }

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