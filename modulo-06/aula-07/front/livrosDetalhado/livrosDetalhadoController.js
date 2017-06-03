biblioteca.controller('livrosDetalhadoController', function($scope, $routeParams, livrosDetalhadoService){
    $scope.Isbn = $routeParams.Isbn;
    $scope.livroDetalhado = {};
    buscarLivroDetalhado();
    function buscarLivroDetalhado() {
            Isbn = parseInt($routeParams.Isbn);
            console.log(Isbn)
            livrosDetalhadoService.buscarDetalhado(Isbn).then(function (response){
                $scope.livroDetalhado = response.data;
                console.log(response.data)
            });
        };
});