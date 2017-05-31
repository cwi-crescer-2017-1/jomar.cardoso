using EditoraCrescer.Entidades;
using EditoraCrescer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());
        }
        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Incluir(autor);
            return Ok(autor);
        }
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
        }
    }
}
