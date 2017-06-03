biblioteca.factory('livrosService', function($http, $location){

    urlBase = 'http://localhost:54896/api/livros'

    function buscarLancamentos() {
        return $http.get(urlBase+"/lancamentos")
    }
    function buscarPublicados(parametros) {
        console.log(parametros)
         return $http({
          url: urlBase,
          method: 'GET',
          params: parametros
        })
    }
    function livroDetalhado (isbn) {
        $location.path('/detalhado'+'/'+isbn)
    }

    return {
        buscarLancamentos: buscarLancamentos,
        buscarPublicados: buscarPublicados,
        livroDetalhado: livroDetalhado
    }
})
