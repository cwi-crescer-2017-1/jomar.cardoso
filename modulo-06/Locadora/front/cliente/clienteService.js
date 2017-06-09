biblioteca.factory('clienteService', function (authConfig, $http, $location) {

    let urlclientes = authConfig.urlclientes

    function cadastrar(cliente){
        return $http({
            url: urlclientes+'/registrar',
            method: 'POST',
            data: cliente
        })
    }

    function buscarCliente(cpf) {
        return $http({
            url: urlclientes+'/cpf/'+cpf,
            method: 'GET'
        })
    }    


    return {
        cadastrar: cadastrar,
        buscarCliente: buscarCliente
    }
})
