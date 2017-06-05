biblioteca.factory('livrosService', function($http, $location, authConfig){

    let urlLivros = authConfig.urlLivros
  
    function buscarLancamentos() {
        return $http.get(urlLivros+"/lancamentos")
    }
    function buscarPublicados(parametros) {
        console.log(parametros)
         return $http({
          url: urlLivros,
          method: 'GET',
          params: parametros
        })
    }


    return {
        buscarLancamentos: buscarLancamentos,
        buscarPublicados: buscarPublicados
    }
})
