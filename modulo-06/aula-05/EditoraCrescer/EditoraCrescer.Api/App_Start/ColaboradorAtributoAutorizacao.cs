using EditoraCrescer.Entidades;
using EditoraCrescer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Principal;
using System.Text;
using System.Threading;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace EditoraCrescer.Api.App_Start
{
    public class ColaboradorAtributoAutorizacao : AuthorizeAttribute
    {
        readonly ColaboradorRepositorio _colaboradorRepositorio;

        public ColaboradorAtributoAutorizacao()
        {
            _colaboradorRepositorio = new ColaboradorRepositorio();
        }

        public override void OnAuthorization(HttpActionContext actionContext)
        {
            // validar se foi informado no cabeçalho da mensagem o parâmetro de autenticação.
            if (actionContext.Request.Headers.Authorization == null)
            {
                // responde para o cliente como não autorizado
                var dnsHost = actionContext.Request.RequestUri.DnsSafeHost;
                actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized);
                actionContext.Response.Headers.Add("WWW-Authenticate", string.Format("Basic realm=\"{0}\"", dnsHost));
                return;
            }
            else
            {
                //obtém o parâmetro (token de autenticação)
                string tokenAutenticacao =
                    actionContext.Request.Headers.Authorization.Parameter;

                // decodifica o parâmetro, pois ele deve vir codificado em base 64
                string decodedTokenAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));

                // obtém o login e senha (colaborador:senha)
                string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

                // validar as credenciais obtidas com as cadastradas no sistema              
                Colaborador colaborador = null;
                // aqui o colaborador tem retorna um boolean e tem uma saída colaborador que será usado aqui
                if (ValidarColaborador(userNameAndPassword[0], userNameAndPassword[1], out colaborador))
                {
                    string[] papeis = colaborador.PermissoesColaborador.Select(papel => papel.Nome).ToArray();
                    var identidade = new GenericIdentity(colaborador.Email);
                    var genericUser = new GenericPrincipal(identidade, papeis);

                    //######################################################### INICIO - parte que não entendi direito
                    // confere o perfil da action com os do usuário
                    if (string.IsNullOrEmpty(Roles))
                    {
                        // atribui o usuário informado no contexto da requisição atual
                        Thread.CurrentPrincipal = genericUser;
                        if (HttpContext.Current != null)
                            HttpContext.Current.User = genericUser;

                        return;
                    }
                    else
                    {
                        var currentRoles = Roles.Split(',');
                        foreach (var currentRole in currentRoles)
                        {
                            if (genericUser.IsInRole(currentRole))
                            {
                                // atribui o usuário informado no contexto da requisição atual
                                Thread.CurrentPrincipal = genericUser;
                                if (HttpContext.Current != null)
                                    HttpContext.Current.User = genericUser;

                                return;
                            }
                        }
                    }
                    //######################################################### FIM
                }
            }
            actionContext.Response =
                actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized, new { mensagens = new string[] { "Colaborador ou senha inválidos." } });
        }

        private bool ValidarColaborador(string login, string senha, out Colaborador colaboradorRetorno)
        {
            colaboradorRetorno = null;
            //buscar colaborador através do login recebido por parâmetro
            var colaborador = _colaboradorRepositorio.Obter(login);

            if (colaborador != null && colaborador.ValidarSenha(senha))
                colaboradorRetorno = colaborador;
            else
                colaborador = null;

            return colaborador != null;
        }
    }
}