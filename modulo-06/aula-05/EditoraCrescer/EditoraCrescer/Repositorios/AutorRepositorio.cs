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
        public List<Autor> Obter(int id)
        {
            return contexto.Autor.Where(a => a.Id == id).ToList();
        }
        public List<Livro> ObterLivros(int id)
        {   
            return contexto.Livro.Where(l => l.IdAutor == id).ToList();
        }
        public void Incluir(Autor autor)
        {
            contexto.Autor.Add(autor);
            contexto.SaveChanges();
        }
        public Autor alterar(int isbn, Autor autor)
        {
            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return autor;
        }
        public void Excluir(int id)
        {
            var autor = new Autor { Id = id };
            contexto.Autor.Attach(autor);
            contexto.Autor.Remove(autor);
            contexto.SaveChanges();
        }
        public bool validar(int id, Autor autor, out List<string> mensagens)
        {
            mensagens = new List<string>();
            //verificar id com id do autor
            if (autor.Id != id)
                mensagens.Add("id invalido");
            //verificar se tem autor com esta id
            if (contexto.Autor.Count(l => l.Id == id) == 0)
                mensagens.Add("Não encontrado");
            var teste = mensagens.Count() != 0;
            return mensagens.Count() != 0;
        }
    }
}
