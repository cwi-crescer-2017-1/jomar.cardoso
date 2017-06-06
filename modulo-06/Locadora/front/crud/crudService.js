biblioteca.factory('crudService', function (authConfig, $http, $location) {

    let urlLivros = authConfig.urlLivros

    function criar(livro) {
        return $http({
            url: urlLivros,
            method: 'POST',
            data: livro
        })
    }

    function buscar(Isbn) {
        return $http({
            url: urlLivros+'/'+ Isbn,
            method: 'GET'
        })
    }

    function editar(livro) {
        return $http({
            url: urlLivros+'/'+livro.Isbn,
            method: 'PUT',
            data: livro
        })
    }

    return {
        criar: criar,
        buscar: buscar,
        editar: editar
    }
})



