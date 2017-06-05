using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutDemo.Dominio.Entidades
{
    public class Cliente
    {
        
        public Cliente()
        {

        }
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public string cpf { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }

    }
}
