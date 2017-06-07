biblioteca.controller('gerenteController', function($scope, authService, gerenteService){
    $scope.livrosNaoRevisados
    $scope.buscarNaoRevisados = buscarNaoRevisados

    buscarNaoRevisados()
    function buscarNaoRevisados() {
        gerenteService.buscarNaoRevisados()
        .then(response => {
            console.log(response.data)
            $scope.livrosNaoRevisados = response.data
        })
    }


})