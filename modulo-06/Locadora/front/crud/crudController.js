biblioteca.controller('crudController', function($scope, $routeParams, authService, crudService, $location){
    $scope.operacao = $routeParams.operacao;
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioGerente = authService.possuiPermissao('Gerente')
    $scope.buscarCliente = buscarCliente
    $scope.pedido = {}
    $scope.cliente = {}
    $scope.produtos = []
    $scope.pacotes = []
    $scope.Opcionais = []

    $scope.criar = criar
    $scope.buscar = buscar
    buscarProdutos()
    buscarPacotes()
    buscarOpcionais()

    pedido = {
        //CpfCliente: 'A Tormenta de Espadas - As Crônicas de Gelo e Fogo - Vol. 3,',
        //IdProduto: 13,
        //IdPacote: 'Ficção',
        //IdOpcional: 'https://images.livrariasaraiva.com.br/imagemnet/imagem.aspx/?pro_id=4887923&qld=90&l=550&a=-1&PIM_Id=',
        //DiasAlugado: new Date(2014,6,7),
        //Valor: 'TERCEIRO VOLUME DA SAGA MAIS IMPORTANTE DOS ÚLTIMOS TEMPOS Enquanto os Sete Reinos estremecem com a chegada dos temíveis selvagens pela Muralha, numa maré interminável de homens, gigantes e terríveis bestas, Jon Snow, o Bastardo de Winterfell, que se encontra entre eles, divide- se entre sua consciência e o papel que é forçado a desempenhar. Robb Stark, o Jovem Lobo, vence todas as suas batalhas, mas será que ele conseguirá vencer os desafios que não se resolvem apenas com a espada? Arya continua a caminho de Correrrio, mas mesmo alguém tão destemida como ela terá grande dificuldade em ultrapassar os obstáculos que se aproximam. Na corte de Joffrey, em Porto Real, Tyrion luta pela vida, depois de ter sido gravemente ferido na Batalha da Água Negra; e Sansa, livre do compromisso com o homem que agora ocupa o Trono de Ferro, precisa lidar com as consequências de ser a segunda na linha de sucessão de Winterfell, uma vez que Bran e Rickon estariam mortos. No Leste, Daenerys Targaryen navega em direção às terras da sua infância, mas antes ela precisará apor¬tar às desprezíveis cidades dos escravagistas. Mas a menina indefesa agora é uma mulher poderosa. Quem sabe quanto tempo falta para se transformar em uma conquistadora impiedosa?'    
    }



    function buscarCliente(cpf) {
        crudService.buscarCliente(cpf)
        .then(response => {
            $scope.cliente = response.data.dados
            console.log(response.data.dados)
            $scope.pedido.IdCliente = response.data.dados.Id
        })
    }

    function buscarProdutos() {
        crudService.buscarProdutos()
        .then(response => {
            $scope.produtos = response.data.dados
            console.log(response)
        })
    }

    function buscarPacotes() {
        crudService.buscarPacotes()
        .then(response => {
            $scope.pacotes = response.data.dados
            console.log(response)
        })
    }

    function buscarOpcionais() {
        crudService.buscarOpcionais()
        .then(response => {
            $scope.opcionais = response.data.dados
            console.log(response)
        })
    }

    function criar(pedido) {
        operacao = $scope.operacao
       if (operacao == 1) {
            crudService.criar(pedido)
            .then(response => {
                console.log(response)
                // $location.path('/detalhado'+'/'+response.data.Isbn)
            })
       }
       //console.log($scope.pedido)
       else if(operacao ==2) {
           crudService.editar(pedido)
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
            pedido = response.data
            $scope.pedido.Isbn = pedido.Isbn
            $scope.pedido.CpfCliente = pedido.CpfCliente
            $scope.pedido.IdProduto = pedido.IdProduto
            $scope.pedido.IdPacote = pedido.IdPacote
            $scope.pedido.IdOpcional = pedido.IdOpcional
            $scope.pedido.Valor = pedido.Valor
            $scope.pedido.DiasAlugado = new Date(response.data.DiasAlugado)
       })
    }
})
