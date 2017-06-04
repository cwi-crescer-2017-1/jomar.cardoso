biblioteca.controller('livrosDetalhadoController', function($scope, $routeParams, livrosDetalhadoService, $location){
    $scope.Isbn = $routeParams.Isbn;
    $scope.livroDetalhado = {};
    $scope.revisar = revisar
    buscarLivroDetalhado();
    function buscarLivroDetalhado() {
        Isbn = parseInt($routeParams.Isbn);
        console.log(Isbn)
        livrosDetalhadoService.buscarDetalhado(Isbn).then(function (response){
            $scope.livroDetalhado = response.data;
            console.log(response.data)
        });        
    }
    function revisar(Isbn) {
        Isbn = parseInt($routeParams.Isbn);
        livrosDetalhadoService.revisar(Isbn)
        .then(response => {
            $location.path('/')
        })
    }
});