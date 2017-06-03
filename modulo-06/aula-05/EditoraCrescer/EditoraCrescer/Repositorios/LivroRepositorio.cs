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

        public List<dynamic> Obter()
        {
            return contexto.Livro
                .Select(l => new {
                    Isbn = l.Isbn,
                    Titulo = l.Titulo,
                    Capa = l.Capa,
                    NomeAutor = l.Autor.Nome,
                    Genero = l.Genero})
                .ToList<dynamic>();
        }

        public dynamic Obter(int isbn)
        {
            var livro = contexto.Livro.Where(l => l.Isbn == isbn)
                .Select(l => new {
                    Isbn = l.Isbn,
                    Capa = l.Capa,
                    Titulo = l.Titulo,
                    Autor = l.Autor,
                    Genero = l.Genero,
                    Descricao = l.Descricao
                })
                .ToList<dynamic>();

            return livro[0];
        }

        public List<dynamic> ObterPublicados(int quantidadePular, int quantidadeTrazer)
        {
            return contexto.Livro
                .OrderByDescending(l => l.DataPublicacao)
                .Skip(quantidadePular)
                .Take(quantidadeTrazer)
                .Select(l => new {
                    Isbn = l.Isbn,
                    Capa = l.Capa,
                    Titulo = l.Titulo,
                    Autor = l.Autor,
                    Genero = l.Genero })
                .ToList<dynamic>();
        }

        public List<dynamic> Obter(string genero)
        {            
            return 
                contexto.Livro.Where(l => l.Genero.Contains(genero))
                .Select(l => new {
                    Isbn = l.Isbn,
                    Titulo = l.Titulo,
                    Capa = l.Capa,
                    NomeAutor = l.Autor.Nome,
                    Genero = l.Genero})
                .ToList<dynamic>();
        }

        public List<dynamic> ObterLancamentos()
        {
            return contexto.Livro.OrderByDescending(l => l.DataPublicacao).Take(7)
                .Select(l => new {
                    Isbn = l.Isbn,
                    Capa = l.Capa,
                    Titulo = l.Titulo,
                    Autor = l.Autor,
                    Genero = l.Genero})
                .ToList<dynamic>();
        }

        public void Incluir(Livro livro)
        {
            contexto.Livro.Add(livro); 
            contexto.SaveChanges();
        }

       

        public Livro alterar(int isbn, Livro livroAlterado)
        {
            contexto.Entry(livroAlterado).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return livroAlterado;
        }

        public Livro Excluir(int isbn)
        {
            var livro = new Livro { Isbn = isbn };
            contexto.Livro.Attach(livro);
            contexto.Livro.Remove(livro);
            contexto.SaveChanges();
            return livro;
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
