angular.module('biblioteca').controller('devolucaoController', function($scope, authService, devolucaoService){
    $scope.pedidos = {}
    $scope.buscarPedidos = buscarPedidos
    $scope.devolverPedido = devolverPedido

    buscarPedidos()

    function buscarPedidos() {
        devolucaoService.buscarPedidos()
        .then(response => {
            pedidos = response.data.dados
            console.log(pedidos)
            for(pedido of pedidos) {
                pedido.DataEntregaPrevista = new Date(pedido.DataEntregaPrevista)
                console.log(pedido.DataEntregaPrevista)
            }
            $scope.pedidos = pedidos
        })
    }

    function devolverPedido(id) {
        n = parseInt(id);
        devolucaoService.devolverPedido(n)
        .then(response => {
            console.log(response)
            if(response.status == 200) {
                $scope.sucesso = true;
                //toastr.success('Removido com sucesso');
                buscarPedidos()
            }
            else {
                //toastr.error('Eita algo deu errado');
            }
        }, response => {
            //toastr.error('Eita algo deu errado');
        })
    }
})
