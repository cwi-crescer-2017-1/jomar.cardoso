biblioteca.factory('indexService', function($http, $location, authConfig){

    let urlpedidos = authConfig.urlpedidos
  

    function pedidoDetalhado (isbn) {
        $location.path('/detalhado'+'/'+isbn)
    }

    return {
        pedidoDetalhado: pedidoDetalhado
    }
})
