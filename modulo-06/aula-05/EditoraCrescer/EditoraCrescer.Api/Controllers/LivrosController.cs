using EditoraCrescer.Entidades;
using EditoraCrescer.Repositorios;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());            
        }
        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Incluir(livro);
            return Ok(livro);
        }
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }
    }
}
