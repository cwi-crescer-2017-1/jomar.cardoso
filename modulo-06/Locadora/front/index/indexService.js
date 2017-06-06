biblioteca.factory('indexService', function($http, $location, authConfig){

    let urlLivros = authConfig.urlLivros
  

    function livroDetalhado (isbn) {
        $location.path('/detalhado'+'/'+isbn)
    }

    return {
        livroDetalhado: livroDetalhado
    }
})
