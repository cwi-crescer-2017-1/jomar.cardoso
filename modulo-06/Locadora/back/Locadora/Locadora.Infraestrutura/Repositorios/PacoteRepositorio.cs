using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Entidades;

namespace Locadora.Infraestrutura.Repositorios
{
    public class PacoteRepositorio : ItemRepositorio
    {
        public override Item Obter(int id)
        {
            return contexto.Pacote.Where(x => x.Id == id).FirstOrDefault();
        }

        public override List<dynamic> Obter()
        {
            return contexto.Pacote
                .Select(x => new {
                    Id = x.Id,
                    Nome = x.Nome,
                    Valor = x.Valor,
                    QuantidadeDisponivel = x.QuantidadeDisponivel,
                    Quantidade = x.Quantidade
                })
                .Where(x => x.QuantidadeDisponivel > 0)
                .Where(x => x.Quantidade > 0)
                .ToList<dynamic>();
        }
        public Pacote RemoverEstoque(Pacote item)
        {
            item.retirar();
            contexto.Entry(item).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return item;
        }
    }
}
