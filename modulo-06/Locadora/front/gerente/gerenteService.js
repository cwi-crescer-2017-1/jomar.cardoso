biblioteca.factory('gerenteService', function($http, $location, authConfig){

    let urlPedidos = authConfig.urlpedidos

    function buscarPedidos() {
        return $http({
            url: urlPedidos+'/finalizados',
            method: 'GET'
        })
    }
    return {
        buscarPedidos: buscarPedidos
    }
})