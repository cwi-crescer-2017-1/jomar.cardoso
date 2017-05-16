class Casa {
  constructor(nome, mascote, frase) {
    this.nome = nome || '';
    this.mascote = mascote || '';
    this.frase = frase || '';
    this.membros = [];
  }

  membros() {
    console.log(this.membros);
  }
  adicionaMembro(personagem) {
    this.membros.push(personagem)
  }
}
