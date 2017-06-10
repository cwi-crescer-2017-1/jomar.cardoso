biblioteca.controller('gerenteController', function($scope, authService, gerenteService){
    $scope.pedidos = {}
    $scope.buscarPedidos = buscarPedidos
    buscarPedidos()

    function buscarPedidos() {
        gerenteService.buscarPedidos()
        .then(response => {
            pedidos = response.data.dados
            console.log(pedidos)
            for(pedido of pedidos) {
                pedido.DataEntregaRealizada = new Date(pedido.DataEntregaRealizada)
                console.log(pedido.DataEntregaRealizada)
            }
            $scope.pedidos = pedidos
        })
    }
})