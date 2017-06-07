using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace Locadora.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }

        public List<Pedido> Obter()
        {
            return contexto.Pedido
                .Include(x => x.Pacote)
                .Include(x => x.Produto)
                .Include(x => x.Opcionais)
                .Include(x => x.Cliente).ToList();
        }

        public Pedido Obter(int id)
        {
            return contexto.Pedido
                .Where(x => x.Id == id)
                .Include(x => x.Pacote)
                .Include(x => x.Produto)
                .Include(x => x.Opcionais)
                .Include(x => x.Cliente)
                .FirstOrDefault();
        }

        public Pedido Validar(Pedido pedido)
        {
            pedido.Mensagens.Clear();
            var cliente = new ClienteRepositorio();
            if (cliente.Obter(pedido.Cliente.Id) == null)
            {
                pedido.Mensagens.Add("Cliente Inválido");
            }
            var produto = new ProdutoRepositorio();
            if (produto.Obter(pedido.Produto.Id) == null)
            {
                pedido.Mensagens.Add("Produto Inválido");
            }
            var pacote = new PacoteRepositorio();
            if (pacote.Obter(pedido.Pacote.Id) == null)
            {
                pedido.Mensagens.Add("Pacote Inválido");
            }
            var opcional = new OpcionalRepositorio();
            foreach (var opc in pedido.Opcionais)
            {
                if (opcional.Obter(opc.Id) == null)
                {
                    pedido.Mensagens.Add("Opcionais Inválidos");
                }
            }
            return pedido;
        }

        public Pedido Atualizar(Pedido pedido)
        {
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return pedido;
        }

        public Pedido Registrar(Pedido pedido)
        {
            contexto.Pedido.Add(pedido);
            contexto.SaveChanges();
            return pedido;
        }
    }
}
