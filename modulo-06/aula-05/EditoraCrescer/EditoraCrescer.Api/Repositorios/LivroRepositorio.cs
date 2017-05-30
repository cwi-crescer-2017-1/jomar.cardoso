using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        

        public List<Livro>  Obter()
        {
            return contexto.Livros.ToList();
        }
    }
}