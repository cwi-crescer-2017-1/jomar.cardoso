using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Entidades;

namespace Locadora.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio : ItemRepositorio
    {
        public override Item Obter(int id)
        {
            return contexto.Produto.Where(x => x.Id == id).FirstOrDefault();
        }
        public override List<dynamic> Obter()
        {
            return contexto.Produto
                .Select(x => new {
                    Id = x.Id,
                    Nome = x.Nome
                })
                .ToList<dynamic>();
        }
    }
}
