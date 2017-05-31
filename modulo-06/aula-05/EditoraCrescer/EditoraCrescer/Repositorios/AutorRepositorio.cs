using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autor.ToList();
        }

        public void Incluir(Autor autor)
        {
            contexto.Autor.Add(autor);
            contexto.SaveChanges();
        }
        public void Excluir(int id)
        {
            var autor = new Autor { Id = id };
            contexto.Autor.Attach(autor);
            contexto.Autor.Remove(autor);
            contexto.SaveChanges();
        }
    }
}
