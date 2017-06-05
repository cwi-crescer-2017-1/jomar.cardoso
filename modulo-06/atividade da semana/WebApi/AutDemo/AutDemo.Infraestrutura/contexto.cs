using AutDemo.Dominio.Entidades;
using AutDemo.Infraestrutura.Mapping;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutDemo.Infraestrutura
{
    class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        {

        }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<Usuario> Usuario { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
        }
    }
}
