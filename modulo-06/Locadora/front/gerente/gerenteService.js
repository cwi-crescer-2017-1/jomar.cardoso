biblioteca.factory('gerenteService', function($http, $location, authConfig){

    let urlLivros = authConfig.urlLivros
  
    function buscarNaoRevisados() {
        return $http.get(urlLivros+"/naopublicados")
    }


    return {
        buscarNaoRevisados: buscarNaoRevisados
    }
})
