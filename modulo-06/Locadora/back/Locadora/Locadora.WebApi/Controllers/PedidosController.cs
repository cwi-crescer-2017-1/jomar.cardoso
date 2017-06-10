using Locadora.Api.App_Start;
using Locadora.Api.Models;
using Locadora.Dominio.Entidades;
using Locadora.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Http;


namespace Locadora.Api.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/pedidos")]
    public class PedidosController : ControllerBasica
    {
        private PedidoRepositorio pedidoRepositorio = new PedidoRepositorio();

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            var pedidos = pedidoRepositorio.Obter();
            return ResponderOK(pedidos);
        }
        [HttpGet, Route("alugados")]
        public HttpResponseMessage ObterAlugados()
        {
            var pedidos = pedidoRepositorio.ObterAlugados();
            foreach (var pedido in pedidos)
            {
                pedido.calculaDevolucao();
            }
            return ResponderOK(pedidos);
        }

        [HttpGet, Route("finalizados"), BasicAuthorization(Roles = "Gerente")]
        public HttpResponseMessage ObterFinalizados()
        {
            return ResponderOK(pedidoRepositorio.ObterFinalizados());
        }

        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var pedido = pedidoRepositorio.Obter(id);
            if (pedido == null)
                ResponderErro("Pedido não encontrado");
            return ResponderOK(pedido);
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarPedidoModel model)
        {
            var itens = pedidoRepositorio.BuscarItens(model.IdCliente, model.IdProduto, model.IdPacote, model.IdOpcional);
            var pedido = new Pedido((Cliente)itens[0], (Produto)itens[1], (Pacote)itens[2], (List<Opcional>)itens[3], (int)model.DiasAlugado);
            if (pedido.Validar())
            {
                List<string> mensagens = null;
                if (pedidoRepositorio.Validar(pedido).Mensagens.Count != 0)
                    return ResponderErro(mensagens);
            }
            else
            {
                return ResponderErro(pedido.Mensagens);
            }
            return ResponderOK(pedidoRepositorio.Registrar(pedido));
        }

        [HttpPost, Route("calcular")]
        public HttpResponseMessage Calcular([FromBody]RegistrarPedidoModel model)
        {
            var itens = pedidoRepositorio.BuscarItens(model.IdCliente, model.IdProduto, model.IdPacote, model.IdOpcional);
            var pedido = new Pedido((Cliente)itens[0], (Produto)itens[1], (Pacote)itens[2], (List<Opcional>)itens[3], (int)model.DiasAlugado);
            if (pedido.Validar())
            {
                List<string> mensagens = null;
                if (pedidoRepositorio.Validar(pedido).Mensagens.Count != 0)
                    return ResponderErro(mensagens);
            }
            else
            {
                return ResponderErro(pedido.Mensagens);
            }
            return ResponderOK(new {pedido.Valor});
        }

        [HttpGet, Route("devolver/{id:int}")]
        public HttpResponseMessage Devolver(int id)
        {
            var pedido = pedidoRepositorio.Obter(id);
            if (pedido == null)
                ResponderErro("Pedido não encontrado");
            pedido.devolver();
            pedidoRepositorio.Atualizar(pedido);
            return ResponderOK(pedido);
        }
    }
}