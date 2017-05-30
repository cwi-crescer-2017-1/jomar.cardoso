using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {
        public PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();
        // GET api/<controller>
        public IHttpActionResult Get()
        {
            return Ok(_pedidoRepositorio.Listar());
        }

        // GET api/<controller>/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<controller>
        public IHttpActionResult Post(Pedido pedido)
        {
            var mensagens = new List<string>();

            if (!pedido.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
        }
    }
}