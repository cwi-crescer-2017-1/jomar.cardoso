using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            return contexto.Livro.ToList();
        }

        public void Incluir(Livro livro)
        {
            contexto.Livro.Add(livro);
            contexto.SaveChanges();
        }
        public void Excluir(int id)
        {
            var livro = new Livro { Isbn = id };
            contexto.Livro.Attach(livro);
            contexto.Livro.Remove(livro);
            contexto.SaveChanges();
        }
    }
}
