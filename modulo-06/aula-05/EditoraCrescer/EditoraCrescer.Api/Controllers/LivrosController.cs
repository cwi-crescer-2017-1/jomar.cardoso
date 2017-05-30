using EditoraCrescer.Api.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class LivrosController : ApiController
    {
        Contexto contexto = new Contexto();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();
            return Ok();
        }
    }
}
