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
    [RoutePrefix("api/opcionais")]
    public class OpcionaisController : ControllerBasica
    {
        readonly OpcionalRepositorio opcionaisRepositorio;
        public OpcionaisController()
        {
            opcionaisRepositorio = new OpcionalRepositorio();
        }
        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(opcionaisRepositorio.Obter());
        }
        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var opcional = opcionaisRepositorio.Obter(id);
            if (opcional == null)
                return ResponderErro("Cliente não encontrado.");

            return ResponderOK(new { opcional });
        }
    }
}
