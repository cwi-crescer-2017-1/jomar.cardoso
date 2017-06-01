biblioteca.factory('livrosService', function($http){

    urlBase = 'http://localhost:54896/api/livros'

    function pegarLancamentos() {
        return $http.get(urlBase+"/lancamentos");
    }
    return {
        pegarLancamentos: pegarLancamentos
    }
})
