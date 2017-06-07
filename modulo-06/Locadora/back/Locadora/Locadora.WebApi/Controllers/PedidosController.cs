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
            return ResponderOK(pedidoRepositorio.Obter());
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
            var pedido = new Pedido(model.Cliente, model.Produto, model.Pacote, model.Opcionais, model.DiasAlugado);
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