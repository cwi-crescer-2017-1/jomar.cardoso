biblioteca.factory('crudService', function (authConfig, $http, $location) {

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


    function verificarSubmit(novoPedido){
        let valido = true
        let diasAlugadoInvalido = false
        let produtoInvalido = false
        let cpfInvalido = false
        if (!novoPedido.cliente.$valid) {
            valido = false
            cpfInvalido = true
        }
        if (!novoPedido.produto.$valid) {
            valido = false
            produtoInvalido = true
        }
        if (!novoPedido.diasAlugado.$valid) {
            valido = false
            diasAlugadoInvalido = true
        }


        // //verificar se tem erro no campo requerido
        // if(novoPedido.$error.required) {
        // campoRequerido = true;
        // }
        // //verificar se tem erro no tamanho mínimo
        // if(novoPedido.$error.minlength) {
        // tamanhoMinimoInvalido = true;
        // }
        // //verificar se tem erro no tamanho máximo
        // if(novoPedido.$error.maxlength) {
        // tamanhoMaximoInvalido = true;
        // }
        //errosForm = {tamanhoMaximoInvalido, tamanhoMininoInvalido, campoRequerido}

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
        verificarSubmit: verificarSubmit
    }
})



