using Locadora.Api.App_Start;
using Locadora.Api.Models;
using Locadora.Dominio.Entidades;
using Locadora.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Locadora.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/clientes")]
    public class ClienteController : ControllerBasica
    {
        readonly ClienteRepositorio _clienteRepositorio;

        public ClienteController()
        {
            _clienteRepositorio = new ClienteRepositorio();
        }

        [UsuarioAtributoAutorizacao]
        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarClienteModel model)
        {
            if (_clienteRepositorio.Obter(model.Cpf) == null)
            {
                var cliente = new Cliente(model.Nome, model.Endereco, model.Cpf, model.DataNascimento, model.Genero);

                if (cliente.Validar())
                {
                    _clienteRepositorio.Criar(cliente);
                }
                else
                {
                    return ResponderErro(cliente.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Usuário já existe.");
            }
            return ResponderOK();
        }

        // Exige que o usuário se autentique
        [UsuarioAtributoAutorizacao]
        [HttpGet, Route("usuario")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = _clienteRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return ResponderErro("Usuário não encontrado.");

            return ResponderOK(new { usuario.Nome, usuario.Gerente, usuario.Login });
        }
    }
}
