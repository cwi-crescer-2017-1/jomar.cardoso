app.factory('servicesAulas', function($http){

  let urlBase = 'http://localhost:3000/aula';

  // retornar todas as aulas
  function getTodasAulas() {
    return $http.get(urlBase)
  }

  // incluir aula
  function incluirAula(aulaAlterada){
    return $http.post(urlBase, aulaAlterada)
  }
  //alterar aula
  function alterarAula(aulaAlterada) {
    return $http.put(urlBase+'/'+aulaAlterada.id, aulaAlterada)
  }
  //verifica erros do form aula
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
  // excluir aula
  function excluirAula(aulaExcluida) {
  return $http.delete(urlBase+'/'+aulaExcluida.id)
  }
  //buscarPorId
  function buscarPorId(id) {
    return $http.get(urlBase+'/'+id)
  }
  return {
    list: getTodasAulas,
    verificaForms: verificaSubmit,
    incluirAula: incluirAula,
    excluirAula: excluirAula,
    alterarAula: alterarAula,
    buscarPorId: buscarPorId,
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
