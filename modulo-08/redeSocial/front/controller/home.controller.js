angular.module('app').controller('homeController', function (homeService, $scope, authService, $http, appConfig, $localStorage) {




    function buscarAmigos() {
      homeService.buscarAmigos()
      .then(response => {
        $scope.listaAmigos = response.data
        console.log($scope.listaAmigos)
      })
    }
    buscarAmigos()

    $scope.apoiar = apoiar
    function apoiar(postagem) {
      if(postagem.liked) {
        homeService.desapoiar(postagem.id)
        .then(reponse => {
          postagem.gostei.pop();
          postagem.liked = false;
        })
      } else {
        homeService.apoiar(postagem.id)
        .then(reponse => {
          postagem.liked = true;
          postagem.gostei.push({});
        })
      }
    }

    //feed
    $scope.postagens = []
    function atualizarFeed() {
      homeService.atualizarFeed()
      .then(response =>{
        response.data.forEach(postagem => {
          postagem.gostei.forEach(gostei => {
            if(!postagem.liked) {
              postagem.liked = gostei.usuario.id === $localStorage.usuarioLogado.id;
            }
          });
        })

        $scope.postagens = response.data
        console.log(response.data)
      })
    }
    atualizarFeed()

  });
