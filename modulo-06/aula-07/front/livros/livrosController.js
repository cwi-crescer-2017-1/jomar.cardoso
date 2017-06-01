biblioteca.controller('livrosController', function($scope, livrosService){
    $scope.livrosDestaque
    $scope.buscarLancamentos = buscarLancamentos
    buscarLancamentos()

    function buscarLancamentos() {
        livrosService.pegarLancamentos()
        .then(response => {
            console.log(response.data)
            $scope.livrosDestaque = response.data
        })
    }    

    
})