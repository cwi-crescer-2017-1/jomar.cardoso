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
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());
        }

        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult Get(int id)
        {
            return Ok(repositorio.Obter(id));
        }

        [HttpGet]
        [Route("livros/{id}")]
        public IHttpActionResult GetLivros(int id)
        {
            return Ok(repositorio.ObterLivros(id));
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult Put(int id, Autor autor)
        {
            var mensagens = new List<string>();
            if (repositorio.validar(id, autor, out mensagens))
            {
                return BadRequest(string.Join(".", mensagens.ToArray()));
            }
            repositorio.alterar(id, autor);
            return Ok(autor);
        }

        [HttpPost]
        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Incluir(autor);
            return Ok(autor);
        }

        [HttpDelete]
        [Route("{id}")]
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
