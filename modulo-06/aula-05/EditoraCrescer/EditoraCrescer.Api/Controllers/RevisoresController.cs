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
    [RoutePrefix("api/revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

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

        [HttpPost]
        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Incluir(revisor);
            return Ok(revisor);
        }
        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult Put(int id, Revisor revisor)
        {
            var mensagens = new List<string>();
            if (repositorio.validar(id, revisor, out mensagens))
            {
                return BadRequest(string.Join(".", mensagens.ToArray()));
            }
            repositorio.alterar(id, revisor);
            return Ok(revisor);
        }
        [HttpGet]
        [Route("{id}")]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }
    }
}
