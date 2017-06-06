using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Cliente : EntidadeBasica
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Cpf { get; private set; }
        public string Endereco { get; private set; }
        public Genero Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }

        protected Cliente()
        {

        }

        public Cliente(string nome, string cpf, string endereco, DateTime dataNascimento, Genero genero)
        {
            this.Nome = nome;
            this.Endereco = endereco;
            this.Cpf = cpf;
            this.DataNascimento = dataNascimento;
            this.Genero = genero;
        }
        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Endereco))
                Mensagens.Add("Endereco é inválido.");

            if(Cpf.Length != 12)
                Mensagens.Add("Cpf é inválido, digite apenas 12 dígitos sem ponto ou traço");

            return Mensagens.Count == 0;
        }

    }
}
