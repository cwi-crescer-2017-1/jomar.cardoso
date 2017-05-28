using api.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace api.Controllers
{
    public class UsuariosController : ApiController
    {
        public static List<Usuario> ListaUsuarios = new List<Usuario>() {new Usuario(1, "Rocky"), new Usuario(2, "Mr. T")};

        public IEnumerable<Usuario> get(int? id = null)
        {
            if(id == null)
            {
                return ListaUsuarios;
            }
            return ListaUsuarios
                .Where(u => u.Id.Equals(id));
        }
    }   
}
