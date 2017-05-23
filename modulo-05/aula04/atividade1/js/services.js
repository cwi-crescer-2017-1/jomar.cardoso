app.factory('servicesAulas', function($http){

  let urlBase = 'http://localhost:3000';

  // retornar todas as aulas
  function getTodasAulas() {
    return $http.get(urlBase + '/aula');
  };

  let aulas = [
    {id: 0, nome: 'Orientação a objetos'},
    {id: 1, nome: 'Banco de Dados'},
    {id: 2, nome: 'HTML/CSS'},
    {id: 3, nome: 'Javascript'},
    {id: 4, nome: 'AngularJS'}
  ];

  function getId(id) {
    id = id;
    return id
  }
  // function getTodasAulas(){
  //   return aulas;
  // }
  function verificaSubmit(formAlterarAula){
    let tamanhoMininoInvalido = false;
    let campoRequerido = false;
    let tamanhoMaximoInvalido = false;
    //verificar se tem erro no campo requerido
    if(formAlterarAula.$error.required) {
      campoRequerido = true;
    }
    //verificar se tem erro no tamanho mínimo
    if(formAlterarAula.$error.minlength) {
      tamanhoMinimoInvalido = true;
    }
    //verificar se tem erro no tamanho máximo
    if(formAlterarAula.$error.maxlength) {
      tamanhoMaximoInvalido = true;
    }
    errosForm = {tamanhoMaximoInvalido, tamanhoMininoInvalido, campoRequerido}
    console.log(errosForm)
    return errosForm
  }  
  //incluir
  function incluirAula(formAlterarAula, aulaAlterada){
     console.log(formAlterarAula)
    if(formAlterarAula.$invalid){
      console.log('form invalido')
      return
    }   
    if(aulaAlterada.id === null) {
      aulaAlterada.id = aulas.length
      aulas.push(angular.copy(aulaAlterada))
      aulaAlterada = {
        id: null,
        nome: "",
      }      
      return aulaAlterada
    }
    for(aula of aulas) {
      if(aula.id === aulaAlterada.id){
        aula.nome = aulaAlterada.nome
      }
    }
    aulaAlterada = {
      id: null,
      nome: "",
    }
    return aulaAlterada
  }
  // excluir aula
  function excluirAula(aulaExcluida) {
    // aulas = aulas.filter(aula => aula.id !== aulaExcluida.id);
  console.log('aula excluida',aulaExcluida)
  aulas.splice(aulaExcluida.id, 1)
  return aulaExcluida = {}  
  }

  return {
    list: getTodasAulas,
    armazenaId: getId,
    verificaForms: verificaSubmit,
    incluirAula: incluirAula,
    excluirAula: excluirAula
  };

});

//
// aula.factory('servicesInstrutores', function(){
//
//   let instrutores = [
//     {
//       id: 0,
//       nome: 'Bernardo',
//       sobrenome: 'Rezende',
//       idade: 29,
//       email: 'bernardo@cwi.com.br',
//       lecionando: true,
//       aula: [aulas[0], aulas[3]],
//       urlFoto: 'https://avatars0.githubusercontent.com/u/526075?v=3&s=460'
//     },
//     {
//       id: 1,
//       nome: 'André',
//       sobrenome: 'Nunes',
//       idade: 31,
//       email: 'nunes@cwi.com.br',
//       lecionando: false,
//       aula: [aulas[1]],
//       urlFoto: 'https://avatars2.githubusercontent.com/u/10319453?v=3&s=460'
//     },
//     {
//       id: 2,
//       nome: 'Pedro Henrique',
//       sobrenome: 'Pires',
//       idade: 23,
//       email: 'php@cwi.com.br',
//       lecionando: false,
//       aula: [aulas[2]],
//       urlFoto: 'https://avatars0.githubusercontent.com/u/6934800?v=3&s=460'
//     },
//     {
//       id: 3,
//       nome: 'Everton',
//       sobrenome: 'Zanatta',
//       idade: 25,
//       email: 'zanatta@cwi.com.br',
//       lecionando: true,
//       aula: [aulas[4]],
//       urlFoto: 'https://avatars2.githubusercontent.com/u/4175351?v=3&s=460'
//     }
//   ];
//
// })



//
// app.factory('aulaService', function () {
//
//   let idAtual = 1;
//
//   let aulas = [
//     { id: 0, nome: 'OO' },
//     { id: 1, nome: 'HTML e CSS' }
//   ];
//
//   function getTodasAsAulas(params) {
//     return aulas;
//   };
//
//   function getAulaPorId(id) {
//     return aulas.find((aula) => aula.id == id)
//   };
//
//   function atualizar(aula) {
//     aulas.splice(aula.id, 1, aula);
//   };
//
//   function criar(aula) {
//     aula.id = ++idAtual;
//     aulas.push(angular.copy(aula));
//   };
//
//   return {
//     list: getTodasAsAulas,
//     findById: getAulaPorId,
//     update: atualizar,
//     create: criar
//   };
// });
