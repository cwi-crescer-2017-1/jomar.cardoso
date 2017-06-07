using Locadora.Api.App_Start;
using Locadora.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Locadora.Api.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/produtos")]
    public class ProdutosController : ControllerBasica
    {
        readonly ProdutoRepositorio produtoRepositorio;
        public ProdutosController()
        {
            produtoRepositorio = new ProdutoRepositorio();
        }
        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(produtoRepositorio.Obter());
        }
        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var produto = produtoRepositorio.Obter(id);
            if (produto == null)
                return ResponderErro("Cliente não encontrado.");

            return ResponderOK(new { produto });
        }
    }
}
