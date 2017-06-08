biblioteca.factory('clienteService', function (authConfig, $http, $location) {

    let urlclientes = authConfig.urlclientes

    function cadastrar(cliente){
        return $http({
            url: urlclientes+'/registrar',
            method: 'POST',
            data: cliente
        })
    }

    return {
        cadastrar: cadastrar
    }
})
