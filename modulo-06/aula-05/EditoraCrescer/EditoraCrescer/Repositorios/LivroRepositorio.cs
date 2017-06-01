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
            return contexto.Livro.
                ToList();
        }

        public object Obter(int isbn)
        {
            var livro = contexto.Livro.FirstOrDefault(l => l.Isbn == isbn);
            return livro;
        }

        public List<Livro> Obter(string genero)
        {
            List<Livro> livros = new List<Livro>();
            livros = contexto.Livro.Where(l => l.Genero.Contains(genero)).ToList();
            return livros;
        }

        public void Incluir(Livro livro)
        {
            if (livro.IdAutor == 0)
            {
                var repositorioAutor = new AutorRepositorio();
                repositorioAutor.Incluir(livro.Autor);
            }   
            contexto.Livro.Add(livro);
            contexto.SaveChanges();
        }

       

        public Livro alterar(int isbn, Livro livroAlterado)
        {

           // var livro = contexto.Livro.FirstOrDefault(l => l.Isbn == isbn);
            contexto.Entry(livroAlterado).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return livroAlterado;
        }

        public void Excluir(int id)
        {
            var livro = new Livro { Isbn = id };
            contexto.Livro.Attach(livro);
            contexto.Livro.Remove(livro);
            contexto.SaveChanges();
        }

        public bool validar(int isbn, Livro livro, out List<string> mensagens)
        {
            mensagens = new List<string>();
            //verificar isbn com isbn do livro
            if (livro.Isbn != isbn)
             mensagens.Add("isbn invalido");
            //verificar se tem livro com esta isbn
            if (contexto.Livro.Count(l => l.Isbn == isbn) == 0)
                mensagens.Add("Não encontrado");
            var teste = mensagens.Count() != 0;
            return mensagens.Count() != 0;
        }
    }
}
