using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mapping
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");
            HasKey(x => x.Id);
            Property(x => x.Nome)
                .HasMaxLength(50)
                .IsRequired();
            Property(x => x.Login)
                .HasMaxLength(50)
                .IsRequired();
            Property(x => x.Senha)
                .HasMaxLength(50)
                .IsRequired();;
        }
    }
}
