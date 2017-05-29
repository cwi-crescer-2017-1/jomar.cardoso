using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace api.Models
{
    public class Usuario
    {
        public static int ContId = 0;
        public Usuario()
        {

        }
        public Usuario(string nome, string urlFoto)
        {
            Nome = nome;
            Id = ++Usuario.ContId;
            UrlFoto = urlFoto;
        }
        public int Id { get; set; }
        public string Nome { get; set; }
        public string UrlFoto { get; set; }
    }
}