using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Mappings
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
         public UsuarioMap()
        {
            ToTable("Usuarios");
            HasKey(x => x.Id);
        }
    }
}
