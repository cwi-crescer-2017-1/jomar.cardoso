biblioteca.factory('livrosDetalhadoService', function($http){
    var urlBase = 'http://localhost:54896/api/livros';

    function buscarDetalhado(Isbn) {
        return $http({
            url: urlBase+'/'+ Isbn,
            method: 'GET'
        })
    }
    return {
        buscarDetalhado: buscarDetalhado
    }
})