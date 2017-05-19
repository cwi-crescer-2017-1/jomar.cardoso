var aula = angular.module('aula', []);

aula.filter('mascada', () => nome => nome.replace(/(nunes)/i, '$ $1 $'))

aula.filter('lpad3', () => numero => numero.toString().padStart(3, '0'))

aula.filter('upper', () => nome => nome.toString().toUpperCase())

aula.controller('mostra-mascada', function($scope){
  $scope.instrutores = instrutores;
  $scope.aulas = aulas();
});


var instrutores = [{
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

function aulas() {
  let retorno = []
    instrutores.forEach(function(instrutor){
      for(aula of instrutor.aula) {
        retorno.push({aula: aula, instrutor: instrutor })
      }
    }
  )
  return retorno
}
