using EditoraCrescer.Api.App_Start;
using EditoraCrescer.Api.Models;
using EditoraCrescer.Entidades;
using EditoraCrescer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/acesso")]
    public class ColaboradorController : ControllerBasica //aqui foi armazenado as mensagens de sucesso e erro
    {        
        readonly ColaboradorRepositorio _colaboradorRepositorio;

        public ColaboradorController()
        {
            _colaboradorRepositorio = new ColaboradorRepositorio();
        }

        // Exige que o usuário se autentique
        [ColaboradorAtributoAutorizacao]
        [HttpGet, Route("colaborador")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var colaborador = _colaboradorRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);
            
            if (colaborador == null)
                return ResponderErro("Colaborador não encontrado.");

            return ResponderOK(new { colaborador.Nome, colaborador.PermissoesColaborador, colaborador.Email });
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarColaboradorModel model)
        {
            if (_colaboradorRepositorio.Obter(model.Email) == null)
            {
                var colaborador = new Colaborador(model.Nome, model.Email, model.Senha);
                if (colaborador.Validar())
                {
                   // _colaboradorRepositorio.Criar(colaborador);
                }
                else
                {
                    return ResponderErro(colaborador.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Colaborador já existe.");
            }

            return ResponderOK();
        }
    }
}
