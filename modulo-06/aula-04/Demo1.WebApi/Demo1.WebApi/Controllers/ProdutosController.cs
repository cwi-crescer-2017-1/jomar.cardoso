using Demo1.Dominio.Models;
using Demo1.InfraEstrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;


namespace Demo1.WebApi.Controllers
{
    public class ProdutosController : ApiController
    {

        private ProdutoRepositorio produtosRepositorio = new ProdutoRepositorio();


        public IHttpActionResult Post(Produto produto)
        {
            var mensagens = new List<string>();
            if (!produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            produtosRepositorio.Criar(produto);
            return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            var produtos = produtosRepositorio.Listar();
            return Ok(produtos);
        }
    }
}
