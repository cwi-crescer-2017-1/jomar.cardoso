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
    [RoutePrefix("api/pacotes")]
    public class PacotesController : ControllerBasica
    {
        readonly PacoteRepositorio pacoteRepositorio;
        public PacotesController()
        {
            pacoteRepositorio = new PacoteRepositorio();
        }
        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(pacoteRepositorio.Obter());
        }
        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var pacote = pacoteRepositorio.Obter(id);
            if (pacote == null)
                return ResponderErro("Cliente não encontrado.");

            return ResponderOK(new { pacote });
        }
    }
}
