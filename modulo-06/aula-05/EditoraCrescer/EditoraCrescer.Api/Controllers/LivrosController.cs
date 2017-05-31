using EditoraCrescer.Entidades;
using EditoraCrescer.Repositorios;
using System.Collections.Generic;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());            
        }
    
        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult Get(int isbn)
        {
            return Ok(repositorio.Obter(isbn));
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            return Ok(repositorio.Obter(genero));
        }
        [HttpPost]
        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Incluir(livro);
            return Ok(livro);
        }
        [HttpPut]
        [Route("{isbn}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            var mensagens = new List<string>();
            if (repositorio.validar(isbn, livro, out mensagens)) {
                return BadRequest(string.Join(".", mensagens.ToArray()));
            }
            repositorio.alterar(isbn, livro);            
            return Ok(livro);
        }
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }
    }
}
