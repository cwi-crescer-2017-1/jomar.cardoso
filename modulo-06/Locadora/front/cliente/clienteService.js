biblioteca.factory('crudService', function (authConfig, $http, $location) {

    let urlclientes = authConfig.urlclientes

    function cadastrar(cliente){
        return $http({
            url: urlclientes,
            method: 'POST',
            data: cliente
        })
    }
    
    return {
        cadastrar: cadastrar
    }
})
