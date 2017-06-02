biblioteca.factory('livrosService', function($http){

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
    function buscarDetalhado(Isbn) {
        return $http({
            url: urlBase+'/'+Isbn,
            method: 'GET',
            params: Isbn
        })
    }
    
    return {
        buscarLancamentos: buscarLancamentos,
        buscarPublicados: buscarPublicados,
        buscarDetalhado: buscarDetalhado
    }
})
