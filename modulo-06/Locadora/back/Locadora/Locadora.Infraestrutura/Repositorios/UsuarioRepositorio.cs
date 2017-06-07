using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio : IDisposable
    {
        static readonly Dictionary<string, Usuario> _usuarios = new Dictionary<string, Usuario>();
        private Contexto contexto = new Contexto();

        public UsuarioRepositorio()
        {

        }

        public Usuario Obter(string login)
        {
            return contexto.Usuario.Where(x => x.Login == login).FirstOrDefault();
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
