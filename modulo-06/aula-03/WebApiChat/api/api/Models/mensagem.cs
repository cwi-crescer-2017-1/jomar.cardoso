using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace api.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public Usuario Remente { get; set; }
        public DateTime HoraEnvio { get; set; }
        public string Conteudo { get; set; }
    }
}