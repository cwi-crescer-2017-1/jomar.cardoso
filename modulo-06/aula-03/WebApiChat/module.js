var chat = angular.module('chat', ['ngRoute','ngAnimate', 'toastr', 'ngStorage']);

chat.config(function ($routeProvider){
    $routeProvider
    .when('/mensagem', {
            controller: 'mensagemController',
            templateUrl: 'mensagem.html'
        })
    .when('/login', {
        controller: 'loginController',
        templateUrl: 'login.html'
    })
    .otherwise({
        redirectTo: '/mensagem'
    })
})


