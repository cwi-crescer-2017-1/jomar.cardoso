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
        public static List<Usuario> ListaUsuarios = new List<Usuario>() {
            new Usuario("Rocky", "http://www.buscadaexcelencia.com.br/wp-content/uploads/2013/01/rocky-5.jpg"),
            new Usuario("Mr. T", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ5Nzg2MTgwMl5BMl5BanBnXkFtZTcwNTA0NjcxMw@@._V1_UY317_CR0,0,214,317_AL_.jpg")};

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
