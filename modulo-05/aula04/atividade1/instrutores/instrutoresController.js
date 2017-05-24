app.controller('controller-instrutores', function($scope, instrutoresServices, servicesAulas){
  $scope.instrutores = {}
  $scope.aulas = {}
  $scope.nomeAula = nomeAula
  $scope.incluir = incluir()
  listar()
  $scope.buscarNomeAulaPorId = buscarNomeAulaPorId

  // function listar() {
  //   let promise = instrutoresServices.listar()
  //   promise.then( response => {
  //     $scope.instrutores = response.data
  //     return response.data})
  //     .then( object => {
  //       console.log(object)
  //       for(instrutor of object) {
  //         for(aula of instrutor.aula) {
  //           let promise2 = servicesAulas.buscarPorId(aula)
  //           promise2.then(response2 => response2.data.nome)
  //           .then(nome => console.log(nome))
  //         }
  //       }
  //     })
  
  //     console.log(response)
      
  //     console.log($scope.instrutores)
  //   }

  function listar() {
    let promise = instrutoresServices.listar()
    promise.then( response => $scope.instrutores = response.data)
      let promise2 = servicesAulas.list()
      promise2.then(response => $scope.aulas = response.data)    
  }

  function nomeAula(id) {
    return ($scope.aulas.filter(a => a.id === id)[0].nome)
    console.log($scope.aulas)
  }

  // function listar() {
  //   instrutoresServices.listar()
  //   .then( response => {
  //     $scope.instrutores = response.data
  //     console.log(response.data)
  //   })
  //   servicesAulas.list()
  //   .then( response => {
  //     $scope.aulas = response.data
  //     // console.log(response.data)
  //   })
   


    // .then(() =>{
    //   for(instrutor of instrutor) {
    //     for(aual of instrutor.aula){
    //       instrutor.aulas
    //     }
      // }
    // })
  // }
  // //  function nomeAulas(id) {
  //   //  console.log($scope.aulas)
  //     // return $scope.aulas.filter(id => aulas.id === id)
  //   }

  function buscarNomeAulaPorId(id) {
    let promise = servicesAulas.buscarPorId(id)
    promise.then(function(response){
      console.log(response.data.nome)
      // return response.data.nome
    })
  }

  function incluir(instrutor) {

  }




  //
  //
  //
  //
  // $scope.instrutores = instrutores;
  // $scope.aulas = aulas
  // $scope.campoRequerido = false
  //
  // $scope.verificaSubmitNovoInstrutor = function(){
  //   $scope.tamanhoMininoInvalido = false;
  //   $scope.campoRequerido = false;
  //   $scope.tamanhoMaximoInvalido = false;
  //   $scope.emailInvalido = false;
  //   console.log($scope.formNovoInstrutor)
  //   //verificar se tem erro no campo requerido
  //   if($scope.formNovoInstrutor.$error.required) {
  //     $scope.campoRequerido = true;
  //   }
  //   //verificar se tem erro no tamanho mínimo
  //   if($scope.formNovoInstrutor.$error.minlength) {
  //     $scope.tamanhoMinimoInvalido = true;
  //   }
  //   //verificar se tem erro no tamanho máximo
  //   if($scope.formNovoInstrutor.$error.maxlength) {
  //     $scope.tamanhoMaximoInvalido = true;
  //   }
  //   if($scope.formNovoInstrutor.$error.email) {
  //     console.log('email invalido')
  //     $scope.emailInvalido = true;
  //     console.log($scope.emailInvalido)
  //   }
  // }
  //
  // $scope.verificarCamposRequeridos = function() {
  //   console.log('verificando campo requeridos')
  //   let retorno = ''
  //   if($scope.formNovoInstrutor.$error.required) {
  //     for(r of $scope.formNovoInstrutor.$error.required){
  //       retorno = retorno.concat(' ',r.$name)
  //     }
  //   }
  //   return retorno
  // }
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
