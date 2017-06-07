biblioteca.factory('livrosDetalhadoService', function($http, authConfig){

    let urlLivros = authConfig.urlLivros

    function buscarDetalhado(Isbn) {
        return $http({
            url: urlLivros+'/'+ Isbn,
            method: 'GET'
        })
    }
    function revisar(Isbn) {
        return $http({
            url: urlLivros+'/revisar/'+Isbn,
            method: 'PUT'
        })
    }
    return {
        buscarDetalhado: buscarDetalhado,
        revisar: revisar
    }
})