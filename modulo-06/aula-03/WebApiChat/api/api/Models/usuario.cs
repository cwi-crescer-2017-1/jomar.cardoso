using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace api.Models
{
    public class Usuario
    {
        public Usuario()
        {

        }
        public Usuario(int id, string nome, string urlFoto)
        {
            Nome = nome;
            Id = id;
            UrlFoto = urlFoto;
        }
        public int Id { get; set; }
        public string Nome { get; set; }
        public string UrlFoto { get; set; }
    }
}