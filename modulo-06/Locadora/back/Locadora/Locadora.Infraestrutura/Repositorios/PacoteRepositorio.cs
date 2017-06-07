using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Entidades;

namespace Locadora.Infraestrutura.Repositorios
{
    class PacoteRepositorio : ItemRepositorio
    {
        public override Item Obter(int id)
        {
            return contexto.Pacote.Where(x => x.Id == id).FirstOrDefault();
        }

        public override List<Item> Obter()
        {
            return contexto.Pacote.ToList<Item>();
        }
    }
}
