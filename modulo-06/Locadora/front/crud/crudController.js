biblioteca.controller('crudController', function($scope, $routeParams, authService, crudService, $location){
    $scope.operacao = $routeParams.operacao;
    $scope.usuarioLogado = authService.isAutenticado()
    $scope.usuarioGerente = authService.possuiPermissao('Gerente')
    $scope.buscarCliente = buscarCliente
    $scope.zerarPacote = zerarPacote
    $scope.zerarProduto = zerarProduto
    $scope.zerarOpcional = zerarOpcional
    $scope.pedido = {}
    $scope.cliente
    $scope.produtos = []
    $scope.pacotes = []
    $scope.Opcionais = []
    $scope.sucesso = false
    $scope.valor = false
    $scope.calcular = calcular
    $scope.cpfInvalido = false
    $scope.produtoInvalido = false
    $scope.diasAlugadoInvalido = false

    $scope.criar = criar
    $scope.buscar = buscar
    buscarProdutos()
    buscarPacotes()
    buscarOpcionais()

    pedido = { }



    function zerarPacote() {
        $scope.pacote = {};
    }
    function zerarProduto() {
        $scope.produto = {};
    }
    function zerarOpcional() {
        $scope.opcional = {};
    }

    function zerarCliente() {
        $scope.cliente = {}
    }
        
    function buscarCliente(cpf) {
        crudService.buscarCliente(cpf)
        .then(response => {
            $scope.cliente = response.data.dados
            $scope.cliente.CpfCliente = cpf
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
        $scope.valor = false;
        pedido.IdProduto = $scope.produto.Id
        pedido.IdPacote = $scope.pacote.Id
        console.log($scope.listaOpcionais.map(x => x.Id))
        pedido.IdOpcional = $scope.listaOpcionais.map(x => x.Id)
        operacao = $scope.operacao
        crudService.criar(pedido)
        .then(response => {
            console.log(response)
            if(response.status == 200) {
                $scope.sucesso = true;
                $scope.novoPedido = {}
                $scope.pedido = {}
                zerarCliente()
                zerarPacote()
                zerarProduto()
                zerarOpcional()
            }
        }     )
    }

    function calcular(pedido) {
        novoPedido = $scope.novoPedido
        if (!validar(novoPedido)) {
            return
        }
        $scope.sucesso = false;
        pedido.IdProduto = $scope.produto.Id
        if($scope.pacote !== undefined && $scope.pacote !== null) {
            pedido.IdPacote = $scope.pacote.Id
        }        
        if($scope.listaOpcionais !== undefined && $scope.listaOpcionais !== null) {
            console.log($scope.listaOpcionais.map(x => x.Id))
            pedido.IdOpcional = $scope.listaOpcionais.map(x => x.Id)
        }
        operacao = $scope.operacao
        crudService.calcular(pedido)
        .then(response => {
            console.log(response)
            if(response.status == 200) {                
                $scope.pedido.valor = response.data.dados.Valor
                $scope.valor = true;
            }
        })       
    }

    function validar(novoPedido) {
        console.log(novoPedido)
        let validacoes = crudService.verificarSubmit(novoPedido)
        $scope.cpfInvalido = validacoes.cpfInvalido
        $scope.produtoInvalido = validacoes.produtoInvalido
        $scope.diasAlugadoInvalido = validacoes.diasAlugadoInvalido
        return validacoes.valido
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
