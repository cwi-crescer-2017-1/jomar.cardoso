biblioteca.factory('crudService', function (authConfig, $http, $location) {

    let urlpedidos = authConfig.urlpedidos
    let urlprodutos = authConfig.urlprodutos
    let urlpacotes = authConfig.urlpacotes
    let urlopcionais = authConfig.urlopcionais
    let urlclientes = authConfig.urlclientes


    function criar(pedido) {
        return $http({
            url: urlpedidos,
            method: 'POST',
            data: pedido
        })
    }

    function buscar(Isbn) {
        return $http({
            url: urlpedidos+'/'+ Isbn,
            method: 'GET',
            headers: $localStorage.headerAuth
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

    return {
        criar: criar,
        buscar: buscar,
        editar: editar,
        buscarProdutos: buscarProdutos,
        buscarPacotes: buscarPacotes,
        buscarOpcionais: buscarOpcionais,
        buscarCliente: buscarCliente
    }
})



