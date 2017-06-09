biblioteca.factory('crudService', function (authConfig, $http, $location, validarService) {

    let urlpedidos = authConfig.urlpedidos
    let urlprodutos = authConfig.urlprodutos
    let urlpacotes = authConfig.urlpacotes
    let urlopcionais = authConfig.urlopcionais
    let urlclientes = authConfig.urlclientes

    function criar(pedido) {
        return $http({
            url: urlpedidos+'/registrar',
            method: 'POST',
            data: pedido
        })
    }

    function calcular(pedido) {
        return $http({
            url: urlpedidos+'/calcular',
            method: 'POST',
            data: pedido
        })
    }


    function buscar(Isbn) {
        return $http({
            url: urlpedidos+'/'+ Isbn,
            method: 'GET'
        })
    }

    function editar(pedido) {
        return $http({
            url: urlpedidos+'/'+pedido.Isbn,
            method: 'PUT',
            data: pedido
        })
    }

    function buscarProdutos() {
        return $http({
            url: urlprodutos,
            method: 'GET'
        })
    }

    function buscarPacotes() {
        return $http({
            url: urlpacotes,
            method: 'GET'
        })
    }

    function buscarOpcionais() {
        return $http({
            url: urlopcionais,
            method: 'GET'
        })
    }

    function buscarCliente(cpf) {
        return $http({
            url: urlclientes+'/cpf/'+cpf,
            method: 'GET'
        })
    }    

    function validarFormularioPedido(form) {
        let valido = true
        let diasAlugadoInvalido = false
        let produtoInvalido = false
        let cpfInvalido = false
        if (!form.cliente.$valid) {
            valido = false
            cpfInvalido = true
        }
        if (!form.produto.$valid) {
            valido = false
            produtoInvalido = true
        }
        if (!form.diasAlugado.$valid) {
            valido = false
            diasAlugadoInvalido = true
        }
        let errosForm = {valido, cpfInvalido, produtoInvalido, diasAlugadoInvalido}
        console.log(errosForm)
        return errosForm
    
    }

    return {
        criar: criar,
        buscar: buscar,
        editar: editar,
        buscarProdutos: buscarProdutos,
        buscarPacotes: buscarPacotes,
        buscarOpcionais: buscarOpcionais,
        buscarCliente: buscarCliente,
        calcular: calcular,
        validarFormularioPedido: validarFormularioPedido
    }
})



