biblioteca.controller('gerenteController', function($scope, authService, gerenteService){
    $scope.pedidosNaoRevisados
    $scope.buscarNaoRevisados = buscarNaoRevisados

    buscarNaoRevisados()
    function buscarNaoRevisados() {
        gerenteService.buscarNaoRevisados()
        .then(response => {
            console.log(response.data)
            $scope.pedidosNaoRevisados = response.data
        })
    }


})