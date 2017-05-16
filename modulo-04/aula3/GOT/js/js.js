function novoPersonagem(persona, nome, casa) {
  persona = new Personagem(nome, casa)
}

var arrayCasas = [
greyjoy = new Casa('Casa Greyjoy', 'Lula', 'Nós não semeamos!'),
stark = new Casa('Casa Stark', 'Lobo', 'O inverto está chegando!'),
baratheon = new Casa('Casa Baratheon', 'Veado', 'Nossa é a fúria!'),
lannister = new Casa('Casa Lannister', 'Leão', 'Ouça me rugir!'),
arryn = new Casa('Casa Arryn', 'falcão', 'Alto como a honra!'),
targaryen = new Casa('Casa Targaryen', 'Dragão', 'Fogo e sangue!'),
tyrell = new Casa('Casa Tyrell', 'Rosa', 'Crescendo Fortes!'),
bolton = new Casa('Casa Bolton', 'Homem esfolado', 'Nossas lâminas são afiacas!'),
dothraki = new Casa('Tribo Dothraki'),
selvagem = new Casa('Selvagem')
]

var arrayPersonagens = [
daenarysTargaryen = new Personagem('Daenarys Targaryen', targaryen),
jonSnow = new Personagem('Jon Snow', stark),
gregorClegane = new Personagem('Gregor Clegane', lannister),
cerseiBaratheon = new Personagem('Cersei Baratheon', lannister),
aryaStark = new Personagem('Arya Stark', stark),
sansaStark = new Personagem('Sansa Stark', stark),
tyrionLannister = new Personagem('Tyrion Lannister', targaryen),
khalDrogo = new Personagem('Khal Drogo', dothraki),
joffreyBaratheon = new Personagem('Joffrey Baratheon', lannister),
shae = new Personagem('Shae'),
melisandre = new Personagem('Melisandre', baratheon),
hodor = new Personagem('Hodor', stark),
margaeryTyrell = new Personagem('Margaery Tyrell', tyrell),
ygritte = new Personagem('Ygritte', selvagem),
ramsaySnow = new Personagem('Ramsay Snow', bolton),
sandorClegane = new Personagem('Sandor Clegane')
]

function adicionarNasCasas(arrayCasas, arrayPersonagens) {
  for(c of arrayCasas){
    c.membros = arrayPersonagens.filter(a =>  (a.casa === c))
  }
}
adicionarNasCasas(arrayCasas, arrayPersonagens)

jonSnow.setNome = 'João das Neves'

var jomar

novoPersonagem(jomar, 'Jomar', stark)

console.log(stark)
console.log(jonSnow)
console.log('UHUUUUUU',jomar)
console.log(arrayCasas)
console.log(arrayPersonagens)
console.log(stark.membros)
