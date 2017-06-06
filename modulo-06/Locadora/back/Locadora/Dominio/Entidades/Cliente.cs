using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public string Endereco { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }

        protected Cliente()
        {

        }

        public Cliente(string nome, string cpf, string endereco, DateTime dataNascimento)
        {
            this.Nome = nome;
            this.Endereco = endereco;
            this.Cpf = cpf;
            this.DataNascimento = dataNascimento;
        }

        public int MyProperty { get; set; }
    }
}
