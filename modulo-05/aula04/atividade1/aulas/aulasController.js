app.controller('controller-aulas', function($scope, servicesAulas){
  $scope.excluirAula = excluirAula
  $scope.definirId = definirId
  $scope.alterarAula = alterarAula
  listarAulas();
  $scope.aulaAlterada = {id: null, nome: ""}
  $scope.armazenaid = id => $scope.aulaAlterada.id = servicesAulas.armazenaId(id)
  //listar todas as aulas
  function listarAulas(){
    servicesAulas.list().then(function (response){
      $scope.aulas = response.data
      console.log(response)
    })
  }
  //incluir/alterar Aula
  function alterarAula(aulaAlterada) {
    if(formAlterarAula.$invalid){
      return
    }
    let promise = {}
    if(aulaAlterada.id !== null){
      promise = servicesAulas.alterarAula(aulaAlterada)
    } else {
      promise = servicesAulas.incluirAula(aulaAlterada)
    }
    promise.then(function () {
      listarAulas()
      $scope.aulaAlterada = {id: null, nome: ""}
    })
  }
  //verificar erros em submit
  $scope.verificaSubmitAlterarAula = function(){
    $scope.errosForm = servicesAulas.verificaForms($scope.formAlterarAula)
  }
  //atribuir id para editar aulas
  function definirId(n){
    let promise = servicesAulas.buscarPorId(n)
    promise.then(function(response){
      $scope.aulas = [response.data]
    })
    console.log('uuuuu')
    $scope.aulaAlterada.id = n;
  }
  //exluir aula
  function excluirAula(aulaExcluida) {
    let promise = servicesAulas.excluirAula(aulaExcluida)
    promise.then(function(){
      listarAulas()
      $scope.aulaAlterada = {id: null, nome: ""}
    })
  }
})
