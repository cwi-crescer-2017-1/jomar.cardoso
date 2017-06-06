using Dominio.Entidades;
using Locadora.Infraestrutura.Mapping;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        {

        }

        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Operador { get; set; }
        public DbSet<Pedido> Pedido { get; set; }
        public DbSet<Produto> Produto { get; set; }
        public DbSet<Opcional> Opcional { get; set; }
        public DbSet<Pacote> Pacote { get; set; }
        public DbSet<Pacote> PedidoOpcional { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
         {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PedidoMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new OpcionalMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new PedidoOpcionalMap());
        }
     }
}
