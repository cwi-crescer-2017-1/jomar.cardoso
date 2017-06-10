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
                .Include(x => x.Cliente)
                .ToList();
        }

        public List<Pedido> ObterAlugados()
        {
            return contexto.Pedido
                .Include(x => x.Pacote)
                .Include(x => x.Produto)
                .Include(x => x.Opcionais)
                .Include(x => x.Cliente)
                .Where(x => x.DataEntregaRealizada == null)
                .ToList();
        }

        public List<Pedido> ObterFinalizados()
        {
            return contexto.Pedido
                .Include(x => x.Cliente)
                .Include(x => x.Pacote)
                .Include(x => x.Produto)
                .Where(x => x.DataEntregaRealizada != null)
                .ToList();
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
            if(pedido.Pacote != null)
            {
                var pacote = new PacoteRepositorio();
                if (pacote.Obter(pedido.Pacote.Id) == null)
                {
                    pedido.Mensagens.Add("Pacote Inválido");
                }
            }
            if(pedido.Opcionais != null)
            {
                var opcional = new OpcionalRepositorio();
                foreach (var opc in pedido.Opcionais)
                {
                    if (opcional.Obter(opc.Id) == null)
                    {
                        pedido.Mensagens.Add("Opcionais Inválidos");
                    }
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
            contexto.Entry(pedido.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(pedido.Produto).State = System.Data.Entity.EntityState.Unchanged;
            var produtoRepositorio = new ProdutoRepositorio();
            Produto produto = (Produto)produtoRepositorio.Obter(pedido.Produto.Id);
            produto = produtoRepositorio.RemoverEstoque(produto);
            if (pedido.Pacote != null)
            {
                contexto.Entry(pedido.Pacote).State = System.Data.Entity.EntityState.Unchanged;
                var pacoteRepositorio = new PacoteRepositorio();
                Pacote pacote = (Pacote)pacoteRepositorio.Obter(pedido.Pacote.Id);
                pacote = pacoteRepositorio.RemoverEstoque(pacote);
            }
            if (pedido.Opcionais != null)
            {
                foreach (var produtoOpcional in pedido.Opcionais)
                {
                    contexto.Entry(produtoOpcional).State = System.Data.Entity.EntityState.Unchanged;
                    var opcionalRepositorio = new OpcionalRepositorio();
                    Opcional opcional = (Opcional)opcionalRepositorio.Obter(produtoOpcional.Id);
                    opcional = opcionalRepositorio.RemoverEstoque(opcional);
                }
            }
            contexto.Pedido.Add(pedido);
            contexto.SaveChanges();
            return pedido;
        }

        public List<object> BuscarItens(int idCliente, int idProduto, int idPacote, int[] idOpcional)
        {
            var itens = new List<object>();
            var clienteRepositorio = new ClienteRepositorio();
            var cliente = clienteRepositorio.Obter(idCliente);
            itens.Add(cliente);
            var produtoRepositorio = new ProdutoRepositorio();
            var produto = produtoRepositorio.Obter(idProduto);
            itens.Add(produto);
            if (idPacote != null && idPacote != 0)
            {
                var pacoteRepositorio = new PacoteRepositorio();
                var pacote = pacoteRepositorio.Obter(idPacote);
                itens.Add(pacote);
            }
            else
            {
                itens.Add(null);
            }
            if (idOpcional != null && idOpcional.Length != 0)
            {
                var listaOpcionais = new List<Opcional>();
                var opcionalRepositorio = new OpcionalRepositorio();
                for (var i = 0; i < idOpcional.Length; i++)
                {
                    var opcional = opcionalRepositorio.Obter(idOpcional[i]);
                    listaOpcionais.Add((Opcional)opcional);
                }
                itens.Add(listaOpcionais);
            }
            else
            {
                itens.Add(null);
            }
            return itens;
        } 
    }
}
