using api.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace api.Controllers
{
    public class MensagensController : ApiController
    {
        public static List<Mensagem> ListaMensagens = new List<Mensagem>();

        public static int contador = 0;
        public static object @lock = 1;

        public int Id { get; set; }
        public int IdUsuario { get; set; }
        public DateTime HoraEnvio { get; set; }
        public string Conteudo { get; set; }

        public IEnumerable<Mensagem> Get()
        {
            return ListaMensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                //lock (@lock)
                {
                    ListaMensagens.Add(mensagem);
                    mensagem.Id = contador++;
                    mensagem.HoraEnvio = DateTime.Now;
                }
                return Ok(mensagem);
            }
        }
    }
}
