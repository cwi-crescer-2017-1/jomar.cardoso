var app = angular.module('app', ['ngRoute']);


app.config(function ($routeProvider) {
  $routeProvider
    .when('/aulas', {
      controller: 'controller-aulas',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores', {
      controller: 'controller-instrutores',
      templateUrl: 'instrutores.html'
    })
    .otherwise({
      redirectTo: '/aulas'
    });
});


app.filter('trueFalse', () => nome => !!nome ? 'sim' : 'não')
app.filter('lpad2', () => numero => numero.toString().padStart(2, '0'))


app.controller('controller-aulas', function($scope, servicesAulas){
  $scope.aulas = servicesAulas.list();
  $scope.aulaAlterada = {id: null, nome: ""}
  $scope.armazenaid = id => $scope.aulaAlterada.id = servicesAulas.armazenaId(id)







  $scope.verificaSubmitAlterarAula = function(){
    $scope.tamanhoMininoInvalido = false;
    $scope.campoRequerido = false;
    $scope.tamanhoMaximoInvalido
    console.log($scope.formAlterarAula)
    //verificar se tem erro no campo requerido
    if($scope.formAlterarAula.$error.required) {
      $scope.campoRequerido = true;
    }
    //verificar se tem erro no tamanho mínimo
    if($scope.formAlterarAula.$error.minlength) {
      $scope.tamanhoMinimoInvalido = true;
    }
    //verificar se tem erro no tamanho máximo
    if($scope.formAlterarAula.$error.maxlength) {
      $scope.tamanhoMaximoInvalido = true;
    }
  }


  $scope.alterarAula = function (aulaAlterada) {
    if($scope.formAlterarAula.$invalid){
      console.log('form invalido')
      return
    }
    if(aulaAlterada.id === null) {
      aulaAlterada.id = $scope.aulas.length
      $scope.aulas.push(angular.copy(aulaAlterada))
      $scope.aulaAlterada = {
        id: null,
        nome: "",
      }
      return
    }
    for(aula of $scope.aulas) {
      if(aula.id === aulaAlterada.id){
        aula.nome = aulaAlterada.nome
      }
    }
    $scope.aulaAlterada = {
      id: null,
      nome: "",
    }
    // console.log($scope.aulas.filter( a => a.id === aulaAlterada.id))
    // objeto = $scope.aulas.filter( a => a.id === aulaAlterada.id)


  }
  $scope.excluirAula = function (aulaExcluida) {
    $scope.aulaVinculada = false;
    if($scope.formExcluirAula.$invalid){
      console.log('form invalido')
      return
    }
    for(i=0; i<$scope.aulas.length; i++) {
      if($scope.aulas[i].id === aulaExcluida.id) {
        for(instrutor of instrutores) {
          for(j=0; j<instrutor.aula.length; j++){
            if(instrutor.aula[j].id === aulaExcluida.id){
              console.log('instrutor vinculado')
              $scope.aulaExcluida = {}
              $scope.aulaVinculada = true;
              return
            }
          }
        }
        $scope.aulas.splice(i, 1)
      }
      if($scope.aulas.length === aulaExcluida.id) {
        console.log('ultimo item excluido')
        $scope.aulaExcluida = {}
        return
      }
      $scope.aulas[i].id = i;
    }
  }
});

app.controller('controller-instrutores', function($scope){
  $scope.controller = 'controller-instrutores'
  $scope.instrutores = instrutores;
  $scope.aulas = aulas
  $scope.campoRequerido = false

  $scope.verificaSubmitNovoInstrutor = function(){
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

  $scope.incluirInstrutor = function (novoInstrutor) {
    if($scope.formNovoInstrutor.$invalid){
      $('.owl-carousel').trigger('replace.owl.carousel', $('.owl-carousel'));
      return
    }
    novoInstrutor.id = $scope.instrutores.length
    $scope.instrutores.push(angular.copy(novoInstrutor))
    $scope.novoInstrutor = {}

  }
  $scope.alterarAula = function (aulaAlterada) {
    if($scope.formAlterarAula.$invalid){
      $('.owl-carousel').trigger('replace.owl.carousel', $('.owl-carousel'));
      return
    }
    // console.log($scope.aulas.filter( a => a.id === aulaAlterada.id))
    // objeto = $scope.aulas.filter( a => a.id === aulaAlterada.id)
    for(aula of $scope.aulas) {
      if(aula.id === aulaAlterada.id){
        aula.nome = aulaAlterada.nome
      }
    }
  }
  $('.owl-carousel').trigger('replace.owl.carousel', $('.owl-carousel'));
})
