using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Entity;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Cliente> Obter()
        {
            return contexto.Cliente.ToList();
        }

        public Cliente Obter(int id)
        {
            return contexto.Cliente.Where(x => x.Id == id).FirstOrDefault();
        }

        public Cliente ObterCpf(string cpf)
        {
            return contexto.Cliente.Where(x => x.Cpf == cpf).FirstOrDefault();
        }

        public List<Pedido> ObterLocacoes(int id)
        {
            var cliente = Obter(id);
            return contexto.Pedido
                .Include(x => x.Cliente)
                .Include(x => x.Produto)
                .Include(x => x.Pacote)                
                .Include(x => x.Opcionais)                
                .Where(x => x.Cliente == cliente).ToList();
        }

        public Cliente Criar(Cliente cliente)
        {
            contexto.Cliente.Add(cliente);
            contexto.SaveChanges();
            return cliente;
        }

        private bool VerificaExistencia(int id)
        {
            return contexto.Cliente.Count(x => x.Id == id) == 1;
        }

        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
