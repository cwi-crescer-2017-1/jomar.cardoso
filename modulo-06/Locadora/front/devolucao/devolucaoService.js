biblioteca.factory('devolucaoService', function (authConfig, $http) {

    let urlPedidos = authConfig.urlpedidos

    function buscarPedidos() {
        return $http({
            url: urlPedidos+'/alugados',
            method: 'GET'
        })
    }

    function devolverPedido(id) {
        return $http({
            url: urlPedidos+'/devolver/'+id,
            method: 'GET'
        })
    }

    return {
        buscarPedidos: buscarPedidos,
        devolverPedido: devolverPedido
    }
})