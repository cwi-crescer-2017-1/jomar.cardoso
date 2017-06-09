angular.module('validar', ['ngStorage'])

angular.module('validar').factory('validarService', function (authConfig, $http, $location) {

    function validarCpf(cpf) {
        let valido = true
        let caracteresInvalido = false
        if(cpf.length != 11) {
            valido = false     
            caracteresInvalido = true       
            return invalido
        }
    }

    function validarNomeCliente(nome) {
        let valido = true
        let naoPreenchido = false
        let tamanhoMinimoInvalido = false
        let tamanhoMaximoInvalido = false
        if (nome.length == 0) {
            valido = false
            naoPreenchido = true
        }
        if (tamanho.length < 2) {
            valido = false
            tamanhoMinimoInvalido = true
        }
        if (nome.length > 49) {
            valido = false
            tamanhoMaximoInvalido = true
        }
    }

    function validarFormulario(form) {
        //verificar se tem erro no campo requerido
        if(novoPedido.$error.required) {
        campoRequerido = true;
        }
        //verificar se tem erro no tamanho mínimo
        if(novoPedido.$error.minlength) {
        tamanhoMinimoInvalido = true;
        }
        //verificar se tem erro no tamanho máximo
        if(novoPedido.$error.maxlength) {
        tamanhoMaximoInvalido = true;
        }
        errosForm = {tamanhoMaximoInvalido, tamanhoMininoInvalido, campoRequerido}
    }

    return {
        validarCpf: validarCpf,
        validarNomeCliente: validarNomeCliente,
        validarFormulario: validarFormulario
    }
    
})



