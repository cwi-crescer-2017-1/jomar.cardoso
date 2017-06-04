using EditoraCrescer.Entidades;
using EditoraCrescer.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        {

        }

        public DbSet<Autor> Autor { get; set; }
        public DbSet<Livro> Livro { get; set; }
        public DbSet<Revisor> Revisor { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<Usuario> Usuario { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new RevisorMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
        }
    }
}
