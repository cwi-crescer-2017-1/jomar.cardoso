app.controller('controller-instrutores', function($scope, instrutoresServices, servicesAulas){
  $scope.instrutores = {}
  $scope.aulas = {}
  $scope.nomeAula = nomeAula
  $scope.incluir = incluir
  $scope.verificaSubmitNovoInstrutor = verificaSubmitNovoInstrutor
  listar()
  // $scope.buscarNomeAulaPorId = buscarNomeAulaPorId
  //listar todos os instrutores
  function listar() {
    let promise = instrutoresServices.listar()
    promise.then( response => $scope.instrutores = response.data)
      let promise2 = servicesAulas.list()
      promise2.then(response => $scope.aulas = response.data)
  }
  //buscar o nome da aula para o id que o instrutor tiver
  function nomeAula(id) {
    return $scope.aulas.filter(id => aulas.id === id)
  }
  //incluir instrutor ------------------
  function incluir(instrutor) {
    return
    if($scope.formNovoInstrutor.$invalid){
      console.log('form invalido')
      return
    }
    let promise = {}
    if(instrutor.id !== null){
      promise = instrutoresServices.alterar(instrutor)
    } else {
      promise = instrutoresServices.incluir(instrutor)
    }
    promise.then(function () {
      listar()
      $scope.instrutores = {id: null, nome: ""}
    })
  }
  //verifica campos se estão válidos -------------
   function verificaSubmitNovoInstrutor(){
    $scope.tamanhoMininoInvalido = false;
    $scope.campoRequerido = false;
    $scope.tamanhoMaximoInvalido = false;
    $scope.emailInvalido = false;
    console.log($scope.formNovoInstrutor)
    //verificar se tem erro no campo requerido
    if($scope.formNovoInstrutor.$error.required) {
      $scope.campoRequerido = true;
    }
    //verificar se tem erro no tamanho mínimo
    if($scope.formNovoInstrutor.$error.minlength) {
      $scope.tamanhoMinimoInvalido = true;
    }
    //verificar se tem erro no tamanho máximo
    if($scope.formNovoInstrutor.$error.maxlength) {
      $scope.tamanhoMaximoInvalido = true;
    }
    if($scope.formNovoInstrutor.$error.email) {
      console.log('email invalido')
      $scope.emailInvalido = true;
      console.log($scope.emailInvalido)
    }
  }

  //verifica campos requeridos
  $scope.verificarCamposRequeridos = function() {
    console.log('verificando campo requeridos')
    let retorno = ''
    if($scope.formNovoInstrutor.$error.required) {
      for(r of $scope.formNovoInstrutor.$error.required){
        retorno = retorno.concat(' ',r.$name)
      }
    }
    return retorno
  }

  //
  // function buscarNomeAulaPorId(id) {
  //   let promise = servicesAulas.buscarPorId(id)
  //   promise.then(function(response){
  //     console.log(response.data.nome)
  //     // return response.data.nome
  //   })
  // }
  //
  // function incluir(instrutor) {
  //
  // }




  //
  //
  //
  //
  // $scope.instrutores = instrutores;
  // $scope.aulas = aulas
  // $scope.campoRequerido = false
  //

  //

  //
  // $scope.incluirInstrutor = function (novoInstrutor) {
  //   if($scope.formNovoInstrutor.$invalid){
  //     $('.owl-carousel').trigger('replace.owl.carousel', $('.owl-carousel'));
  //     return
  //   }
  //   novoInstrutor.id = $scope.instrutores.length
  //   $scope.instrutores.push(angular.copy(novoInstrutor))
  //   $scope.novoInstrutor = {}
  //
  // }
  // $scope.alterarAula = function (aulaAlterada) {
  //   if($scope.formAlterarAula.$invalid){
  //     $('.owl-carousel').trigger('replace.owl.carousel', $('.owl-carousel'));
  //     return
  //   }
  //   // console.log($scope.aulas.filter( a => a.id === aulaAlterada.id))
  //   // objeto = $scope.aulas.filter( a => a.id === aulaAlterada.id)
  //   for(aula of $scope.aulas) {
  //     if(aula.id === aulaAlterada.id){
  //       aula.nome = aulaAlterada.nome
  //     }
  //   }
  // }
  // $('.owl-carousel').trigger('replace.owl.carousel', $('.owl-carousel'));
})
