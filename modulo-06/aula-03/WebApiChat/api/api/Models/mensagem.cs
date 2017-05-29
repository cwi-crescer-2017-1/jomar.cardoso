using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace api.Models
{
    public class Mensagem
    {
        public Mensagem()
        {

        }
        public Mensagem(DateTime horaEnvio, string conteudo)
        {
            HoraEnvio = horaEnvio;
            Conteudo = conteudo;
        }
        public int Id { get; set; }
        public int IdRemetente { get; set; }
        public DateTime HoraEnvio { get; set; }
        public string Conteudo { get; set; }
    }
}