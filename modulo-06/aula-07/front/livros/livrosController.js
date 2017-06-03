biblioteca.controller('livrosController', function($scope, livrosService, authService){
    $scope.logout = authService.logout;
    $scope.livrosDestaque
    $scope.livrosPublicados
    $scope.proximaPagina = proximaPagina
    $scope.paginaAnterior = paginaAnterior
    $scope.parametros =  {
        quantidadePular: 0,
        quantidadeTrazer: 8     
    }
    $scope.paginaAtual = 1;   
    $scope.livroDetalhado = livroDetalhado
    buscarLancamentos()
    buscarPublicados()

    function proximaPagina(paginaAtual) {
        $scope.paginaAtual ++;
        $scope.parametros.quantidadePular += 8       
        buscarPublicados()        
    }

    function paginaAnterior(paginaAtual) {
        $scope.paginaAtual --;
        $scope.parametros.quantidadePular -= 8     
        buscarPublicados()        
    }    

    function buscarLancamentos() {
        livrosService.buscarLancamentos()
        .then(response => {
            console.log(response.data)
            $scope.livrosDestaque = response.data
        })
    }

    function buscarPublicados() {
        parametros = $scope.parametros
        livrosService.buscarPublicados(parametros)
        .then(response => {
            console.log(response.data.dados)
            $scope.livrosPublicados = response.data.dados
        })
    }     

    

    function livroDetalhado(isbn) {
        livrosService.livroDetalhado(isbn)
    }
})



// http://localhost:54896/api/livros?quantidadePular=1&quantidadeTrazer=3