angular.module('app').factory('loginService', function (redesocialConfig, $http, $location, $localStorage) {

    return {
        cadastrar: cadastrar
    }
})