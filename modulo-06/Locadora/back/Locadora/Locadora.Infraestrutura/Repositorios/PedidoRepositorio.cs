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
            contexto.Entry(pedido.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(pedido.Produto).State = System.Data.Entity.EntityState.Unchanged;
            if (pedido.Pacote != null)
            {
                contexto.Entry(pedido.Pacote).State = System.Data.Entity.EntityState.Modified;
            }
            if (pedido.Opcionais != null)
            {
                foreach (var produtoOpcional in pedido.Opcionais)
                {
                    contexto.Entry(produtoOpcional).State = System.Data.Entity.EntityState.Unchanged;
                }
            }
            contexto.SaveChanges();
            return pedido;
        }

        public List<object> BuscarItens(int idCliente, int idProduto, int idPacote, int idOpcional)
        {
            var itens = new List<object>();
            var clienteRepositorio = new ClienteRepositorio();
            var cliente = clienteRepositorio.Obter(idCliente);
            itens.Add(cliente);
            var produtoRepositorio = new ProdutoRepositorio();
            var produto = produtoRepositorio.Obter(idProduto);
            itens.Add(produto);
            var pacoteRepositorio = new PacoteRepositorio();
            var pacote = pacoteRepositorio.Obter(idPacote);
            itens.Add(pacote);
            var opcionalRepositorio = new OpcionalRepositorio();
            var opcional = opcionalRepositorio.Obter(idOpcional);
            itens.Add(opcional);
            return itens;
        } 
    }
}
