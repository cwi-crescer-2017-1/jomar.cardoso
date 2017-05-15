/*
Exercício 1: Daisy Game!
Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne
'Love me' ou 'Love me not' (Lembre do jogo "Bem me quer, mal me quer").
Exemplo: daisyGame(4); // retorna 'Love me not'
*/

// function daisyGame(n) {
// 	if(n % 2 === 0){
// 		return 'Love me'
// 	}
// 	return 'Love me not'
// }

var daisyGame = (n) => {if(n%2 === 0){return 'Love me'}else{return 'Love me not'}}

console.log(daisyGame(8))
console.log(daisyGame(11))

/*
Exercício 2: Maior texto
Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres.
*/

var arrayStrings = ["oi", "ai", "ui", "maiorstringdomundo", "ei"]
var arrayStrings2 = ["maiorstringdomundo", "ei", "oi", "ai", "ui"]

var maiorTexto2 = function(a) {
	var i = 0
	var maior = a[i]
	for(i=0; i<a.length; i++) {
		if(maior.length < a[i].length) {
			maior = a[i]
		}
	}
	return maior
}

console.log(maiorTexto2(arrayStrings))
console.log(maiorTexto2(arrayStrings2))

/*
Exercício 3: Instrutor querido
Faça uma função chamada imprime que receba dois parâmetros:
Um array de strings; e
Uma função.
Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array. Exemplo:
imprime(
  // primeiro parâmetro: array
  [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
  // segundo parâmetro: função
  function(instrutor) {
   console.log('olá querido instrutor:', instrutor)
  }
);
Deve resultar em:
"olá querido instrutor: bernardo"
"olá querido instrutor: nunes"
"olá querido instrutor: fabrício"
"olá querido instrutor: ben-hur"
"olá querido instrutor: carlos"
Atenção! Faça um tratamento para evitar que a função imprime seja chamada com um segundo parâmetro que não seja uma função, por exemplo:
imprime([ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], 3.14);
// Jabulani:
// 'TypeError: number is not a function'
*/

var instrutores = [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ]
function olaQuerido (a) {
	console.log('olá querido instrutor: ', a)
}

function imprime(a, f) {
	if(typeof f === 'function'){
		var i;
		for(i=0; i<a.length; i++) {
			f(a[i])
		}
	}else {
			console.log("jabulani")
	}
}

imprime(instrutores, olaQuerido)
imprime(instrutores, "a")

/*
Exercício 4: Soma diferentona
Escreva uma função somar que permite somar dois números através de duas chamadas
diferentes (não necessariamente pra mesma função). Pirou? Ex:
adicionar(3)(4); // 7
adicionar(5642)(8749); // 14391
*/

// function adicionar(a){
// 	function adicionar2(b){
// 		return a+b
// 	}
// 	return adicionar2
// }

var adicionar = (a) => (b) => a + b

console.log(adicionar(3)(4))
console.log(adicionar(5642)(8749));

/*
Exercício 5: Fibona
Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados. Exemplo de chamada:
fiboSum(7);
// 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13)
Dica: aproveite toda "beleza" dos algoritmos recursivos! #sqn
*/

function fiboSum(n) {
	var a=0
	while (n > 0){
		a = a + fibo(n)
		n = n-1
	}
	return a
}

function fibo(n) {
    var x = 0
		var y = 1
		for(var i=0; i<n; i++){
			x = x+y
			y = x-y
		}
		return x;
}
console.log(fiboSum(100))
console.log(fiboSum(7))

/*
Exercício 6: Quero café
Escreva uma função queroCafe que recebe dois parâmetros:
mascada: Valor numérico
precos: Lista de preços de café
A sua implementação deve retornar uma string com todos os preços que estão abaixo ou
igual ao valor mascada ordenados de forma ascendente e separados por ,. Ex:
queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
// '1.15,2.12,3.11'
*/

function queroCafe(m,p) {
	var retorno = ""
	ordenar(p)
	for(var i=0; i<p.length; i++){
		if(p[i] < m){
			retorno = (retorno +p[i] + "," )
		}
	}
	return retorno
}
function ordenar(p){
	var aux = p[0]
	for(var i=0; i<p.length; i++){
		for(var j=i; j<p.length; j++){
			if(p[i] > p[j]) {
				aux = p[j]
				p[j] = p[i]
				p[i] = aux
			}
		}
	}
	return p
}

console.log(queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]))









//
