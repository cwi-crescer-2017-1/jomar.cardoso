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
        public static List<Mensagem> ListaMensagens = new List<Mensagem>() {new Mensagem(new Usuario(), new DateTime(2017-04-05), "sadasdf") };

        public static int contador = 0;
        public static object @lock = 1;


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
                }
                return Ok(mensagem);
            }
        }
    }
}
