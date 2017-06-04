biblioteca.controller('revisorController', function($scope, authService, revisorService){
    $scope.livrosNaoRevisados
    $scope.buscarNaoRevisados = buscarNaoRevisados

    buscarNaoRevisados()
    function buscarNaoRevisados() {
        revisorService.buscarNaoRevisados()
        .then(response => {
            console.log(response.data)
            $scope.livrosNaoRevisados = response.data
        })
    }


})