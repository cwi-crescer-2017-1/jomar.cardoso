var aula = angular.module('aula', []);

// app.filter('firstType',function(){
//   return function(input, type){
//     var results = [];
//     for(var i in input){
//       var name = input[i];
//         if(name[0]==type)
//             results.push(name);
//     }
//     return results;
//   };
// });

aula.filter('mascada', function(){
  return  function(nome){
    if(nome === 'Nunes'){
      // return '$Nunes$'
      return nome.replace('Nunes', '$Nunes$')

    }
    return nome
  }
})

aula.controller('mostra-mascada', function($scope){
  $scope.instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];

});

