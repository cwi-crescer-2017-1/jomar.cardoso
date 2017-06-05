biblioteca.controller('crudController', function($scope, $routeParams, authService, crudService, $location){
    $scope.operacao = $routeParams.operacao;
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioPublicador = authService.possuiPermissao('Publicador')
    $scope.usuarioRevisor = authService.possuiPermissao('Revisor')
    
    
    
    $scope.criar = criar
    $scope.buscar = buscar

    livro = {
        //Titulo: 'A Tormenta de Espadas - As Crônicas de Gelo e Fogo - Vol. 3,',
        //IdAutor: 13,
        //Genero: 'Ficção',
        //Capa: 'https://images.livrariasaraiva.com.br/imagemnet/imagem.aspx/?pro_id=4887923&qld=90&l=550&a=-1&PIM_Id=',
        //DataPublicacao: new Date(2014,6,7),
        //Descricao: 'TERCEIRO VOLUME DA SAGA MAIS IMPORTANTE DOS ÚLTIMOS TEMPOS Enquanto os Sete Reinos estremecem com a chegada dos temíveis selvagens pela Muralha, numa maré interminável de homens, gigantes e terríveis bestas, Jon Snow, o Bastardo de Winterfell, que se encontra entre eles, divide- se entre sua consciência e o papel que é forçado a desempenhar. Robb Stark, o Jovem Lobo, vence todas as suas batalhas, mas será que ele conseguirá vencer os desafios que não se resolvem apenas com a espada? Arya continua a caminho de Correrrio, mas mesmo alguém tão destemida como ela terá grande dificuldade em ultrapassar os obstáculos que se aproximam. Na corte de Joffrey, em Porto Real, Tyrion luta pela vida, depois de ter sido gravemente ferido na Batalha da Água Negra; e Sansa, livre do compromisso com o homem que agora ocupa o Trono de Ferro, precisa lidar com as consequências de ser a segunda na linha de sucessão de Winterfell, uma vez que Bran e Rickon estariam mortos. No Leste, Daenerys Targaryen navega em direção às terras da sua infância, mas antes ela precisará apor¬tar às desprezíveis cidades dos escravagistas. Mas a menina indefesa agora é uma mulher poderosa. Quem sabe quanto tempo falta para se transformar em uma conquistadora impiedosa?'    
    }

    $scope.livro = livro

    function criar(livro) {
        operacao = $scope.operacao
       if (operacao == 1) {
            crudService.criar(livro)
            .then(response => {
                console.log(response)
                $location.path('/detalhado'+'/'+response.data.Isbn)
            })
       }
       //console.log($scope.livro)
       else if(operacao ==2) {
           crudService.editar(livro)
            .then(response => {
                console.log(response)
                $location.path('/detalhado'+'/'+response.data.Isbn)
            })
       }
    }

    function buscar(Isbn) {
        n = parseInt(Isbn);
       crudService.buscar(n)
       .then(response => {
            console.log(response)
            livro = response.data
            $scope.livro.Isbn = livro.Isbn
            $scope.livro.Titulo = livro.Titulo
            $scope.livro.IdAutor = livro.IdAutor
            $scope.livro.Genero = livro.Genero
            $scope.livro.Capa = livro.Capa
            $scope.livro.Descricao = livro.Descricao
            $scope.livro.DataPublicacao = new Date(response.data.DataPublicacao)
       })
    }
})
