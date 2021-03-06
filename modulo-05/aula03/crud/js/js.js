var aula = angular.module('aula', []);

aula.filter('trueFalse', () => nome => !!nome ? 'sim' : 'não')

aula.filter('lpad2', () => numero => numero.toString().padStart(2, '0'))

aula.controller('controller-aulas', function($scope){
  $scope.aulas = aulas
  $scope.instrutores = instrutores
  $scope.aulaAlterada = {
    id: null,
    nome: "",
  }

  // $scope.novaMensagem = function() {
  //   console.log()
  //   $scope.mensagem = angular.fromJson(formAlterarAula)
  // }
  //

  //
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

  $scope.armazenaid = function(id) {
    console.log(id)
    $scope.aulaAlterada.id = id
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

aula.controller('controller-instrutores', function($scope){
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

let aulas = [
  {id: 0, nome: 'Orientação a objetos'},
  {id: 1, nome: 'Banco de Dados'},
  {id: 2, nome: 'HTML/CSS'},
  {id: 3, nome: 'Javascript'},
  {id: 4, nome: 'AngularJS'}
];

let instrutores = [
  {
    id: 0,
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 29,
    email: 'bernardo@cwi.com.br',
    lecionando: true,
    aula: [aulas[0], aulas[3]],
    urlFoto: 'https://avatars0.githubusercontent.com/u/526075?v=3&s=460'
  },
  {
    id: 1,
    nome: 'André',
    sobrenome: 'Nunes',
    idade: 31,
    email: 'nunes@cwi.com.br',
    lecionando: false,
    aula: [aulas[1]],
    urlFoto: 'https://avatars2.githubusercontent.com/u/10319453?v=3&s=460'
  },
  {
    id: 2,
    nome: 'Pedro Henrique',
    sobrenome: 'Pires',
    idade: 23,
    email: 'php@cwi.com.br',
    lecionando: false,
    aula: [aulas[2]],
    urlFoto: 'https://avatars0.githubusercontent.com/u/6934800?v=3&s=460'
  },
  {
    id: 3,
    nome: 'Everton',
    sobrenome: 'Zanatta',
    idade: 25,
    email: 'zanatta@cwi.com.br',
    lecionando: true,
    aula: [aulas[4]],
    urlFoto: 'https://avatars2.githubusercontent.com/u/4175351?v=3&s=460'
  }
];
