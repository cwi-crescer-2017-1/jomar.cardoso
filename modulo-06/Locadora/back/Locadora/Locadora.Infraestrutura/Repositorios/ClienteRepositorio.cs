using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class ClienteRepositorio
    {
        static readonly Dictionary<string, Cliente> _clientes = new Dictionary<string, Cliente>();


        public ClienteRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {

        }

        public void Alterar(Usuario usuario)
        {

        }
        public void Excluir(Usuario usuario)
        {

        }

        public IEnumerable<Usuario> Listar()
        {
            return null;
        }

        public Usuario Obter(string email)
        {
            return null;
        }

        public void Criar(Cliente cliente)
        {
            throw new NotImplementedException();
        }
    }
}
