

class Personagem {
  constructor(nome, casa) {
    this.nome = nome || '';
    this.casa = casa;

  }
  set setNome(nome) {
    this.nome = nome;
  }
}
