﻿using EditoraCrescer.Entidades;
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
        public IHttpActionResult GetPublicados(int quantidadePular, int quantidadeTrazer)
        {
            var livros = repositorio.ObterPublicados(quantidadePular, quantidadeTrazer);
            return Ok(new { dados = livros });
        }

        [Route("{isbn:int}")]
        [HttpGet]
        
        public IHttpActionResult Get(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            return Ok(livro);
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            return Ok(repositorio.Obter(genero));
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult GetLancamentos()
        {
            return Ok(repositorio.ObterLancamentos());
        }

        [HttpGet]
        [Route("naopublicados")]
        public IHttpActionResult GetNaoPublicados()
        {
            return Ok(repositorio.ObterNaoPublicados());
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

        [HttpPut]
        [Route("revisar/{isbn}")]
        public IHttpActionResult Revisar(int isbn)
        {
            repositorio.Revisar(isbn);
            return Ok();
        }

        [HttpDelete]
        [Route("{isbn}")]
        public IHttpActionResult Delete(int isbn)
        {           
            return Ok(repositorio.Excluir(isbn));
        }        

        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
        }
    }
}
