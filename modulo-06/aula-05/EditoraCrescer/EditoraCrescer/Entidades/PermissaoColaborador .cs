using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Entidades
{
    public class PermissaoColaborador
    {
        public int Id { get; set; }
        public string Nome { get; private set; }
        public ICollection<Colaborador> Colaboradores { get; set; }

        public PermissaoColaborador()
        {
            //this.Colaboradores = new HashSet<Colaborador>();
        }

        public PermissaoColaborador(string nome)
        {
            this.Nome = nome;
        }
    }
}
