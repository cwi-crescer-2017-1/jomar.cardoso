biblioteca.factory('gerenteService', function($http, $location, authConfig){

    let urlpedidos = authConfig.urlpedidos
  
    function buscarNaoRevisados() {
        return $http.get(urlpedidos+"/naopublicados")
    }


    return {
        buscarNaoRevisados: buscarNaoRevisados
    }
})
