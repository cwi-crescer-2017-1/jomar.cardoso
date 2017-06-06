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
    [RoutePrefix("api/usuarios")]
    public class UsuarioController : ControllerBasica
    {
        readonly UsuarioRepositorio _usuarioRepositorio;

        public UsuarioController()
        {
            _usuarioRepositorio = new UsuarioRepositorio();
        }

        //[HttpPost, Route("registrar")]
        //public HttpResponseMessage Registrar([FromBody]RegistrarUsuarioModel model)
        //{
        //    if (_usuarioRepositorio.Obter(model.Login) == null)
        //    {
        //        var usuario = new Usuario(model.Nome, model.Login, model.Senha, model.Gerente);

        //        if (usuario.Validar())
        //        {
        //            _usuarioRepositorio.Criar(usuario);
        //        }
        //        else
        //        {
        //            return ResponderErro(usuario.Mensagens);
        //        }
        //    }
        //    else
        //    {
        //        return ResponderErro("Usuário já existe.");
        //    }
        //    return ResponderOK();
        //}



        // Exige que o usuário se autentique
        [UsuarioAtributoAutorizacao]
        [HttpGet, Route("usuario")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return ResponderErro("Usuário não encontrado.");

            return ResponderOK(new { usuario.Nome, usuario.Gerente, usuario.Login });
        }
    }
}