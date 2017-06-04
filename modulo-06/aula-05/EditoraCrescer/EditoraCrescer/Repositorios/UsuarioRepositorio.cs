using EditoraCrescer.Entidades;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Repositorios
{
    public class UsuarioRepositorio
    {
        static readonly Dictionary<string, Usuario> _usuarios = new Dictionary<string, Usuario>();

        static UsuarioRepositorio()
        {
            // YWRtaW5AY3dpLmNvbS5icjoxMjM0NTY=
            var usrJomar = new Usuario("Jomar", "jomar@cwi.com.br", "123456");

            _usuarios.Add(usrJomar.Email, usrJomar);

            // Z2lvdmFuaUBjd2kuY29tLmJyOjEyMzQ1Ng==
            var usrRevisor = new Usuario("Jomar Revisor", "jomarrevisor@cwi.com.br", "123456");
            usrRevisor.AtribuirPermissoes("Revisor");
            _usuarios.Add(usrRevisor.Email, usrRevisor);

            // Z2lvdmFuaUBjd2kuY29tLmJyOjEyMzQ1Ng==
            var usrPublicador = new Usuario("Jomar Publicador", "jomarpublicador@cwi.com.br", "123456");
            usrPublicador.AtribuirPermissoes("Publicador");
            _usuarios.Add(usrPublicador.Email, usrPublicador);
        }

        public UsuarioRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {
            _usuarios.Add(usuario.Email, usuario);
        }

        public void Alterar(Usuario usuario)
        {
            _usuarios[usuario.Email] = usuario;
        }
        public void Excluir(Usuario usuario)
        {
            _usuarios[usuario.Email] = usuario;
        }

        public IEnumerable<Usuario> Listar()
        {
            return _usuarios.Select(u => u.Value);
        }

        public Usuario Obter(string email)
        {
            return _usuarios.Where(u => u.Key == email).Select(u => u.Value).FirstOrDefault();
        }
    }
}
