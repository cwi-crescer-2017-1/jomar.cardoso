using Locadora.Api.App_Start;
using Locadora.Api.Models;
using Locadora.Dominio.Entidades;
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
    [RoutePrefix("api/clientes")]
    public class ClientesController : ControllerBasica
    {
        readonly ClienteRepositorio clienteRepositorio;

        public ClientesController()
        {
            clienteRepositorio = new ClienteRepositorio();
        }

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(clienteRepositorio.Obter());
        }

        [HttpGet, Route("{id:int}")]
        public HttpResponseMessage Obter(int id)
        {
            var cliente = clienteRepositorio.Obter(id);
            if (cliente == null)
                return ResponderErro("Cliente não encontrado.");

            return ResponderOK(new { cliente.Nome, cliente.Cpf, cliente.DataNascimento, cliente.Endereco, cliente.Genero });
        }

        [HttpGet, Route("cpf/{cpf}")]
        public HttpResponseMessage ObterCpf(string cpf)
        {
            var cliente = clienteRepositorio.ObterCpf(cpf);
            if (cliente == null)
                return ResponderErro("Cliente não encontrado.");

            return ResponderOK(new { cliente.Nome, cliente.Cpf, cliente.DataNascimento, cliente.Endereco, cliente.Genero });
        }

        [HttpGet, Route("{id:int}/locacoes")]
        public IHttpActionResult ObterLocacoes(int id)
        {
            return Ok(clienteRepositorio.ObterLocacoes(id));
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarClienteModel model)
        {
            if (clienteRepositorio.ObterCpf(model.Cpf) == null)
            {
                var cliente = new Cliente(model.Nome, model.Cpf, model.Endereco, model.DataNascimento, model.Genero);
                if (cliente.Validar())
                {
                    clienteRepositorio.Criar(cliente);
                    return ResponderOK(new { cliente.Nome, cliente.Cpf, cliente.DataNascimento, cliente.Endereco, cliente.Genero });
                }
                else
                {
                    return ResponderErro(cliente.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Cliente já cadastrado.");
            }
        }
    }
}


