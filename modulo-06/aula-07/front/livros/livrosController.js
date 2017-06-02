biblioteca.controller('livrosController', function($scope, livrosService){
    $scope.livrosDestaque
    $scope.livrosPublicados
    $scope.proximaPagina = proximaPagina
    $scope.paginaAnterior = paginaAnterior
    $scope.parametros =  {
        quantidadePular: 0,
        quantidadeTrazer: 16     
    }
    $scope.paginaAtual = 1;    
    buscarLancamentos()
    buscarPublicados()

    function proximaPagina(paginaAtual) {
        $scope.paginaAtual ++;
        $scope.parametros.quantidadePular = $scope.parametros.quantidadeTrazer
        $scope.parametros.quantidadeTrazer += 16        
        buscarPublicados()        
    }

    function paginaAnterior(paginaAtual) {
        $scope.paginaAtual --;
        $scope.parametros.quantidadeTrazer = $scope.parametros.quantidadePular
        $scope.parametros.quantidadePular -= 16        
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

    function buscarPublicados() {
        parametros = $scope.parametros
        livrosService.buscarPublicados(parametros)
        .then(response => {
            console.log(response.data.dados)
            $scope.livrosPublicados = response.data.dados
        })
    }    

    $scope.livroDetalhado
    $scope.buscarLivroDetalhado = buscarLivroDetalhado
    function buscarLivroDetalhado(Isbn) {
        Isbn = 3
        livrosService.buscar
    }
})



// http://localhost:54896/api/livros?quantidadePular=1&quantidadeTrazer=3