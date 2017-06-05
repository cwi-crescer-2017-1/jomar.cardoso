using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Mappings
{
    class PermissaoColaboradorMap : EntityTypeConfiguration<PermissaoColaborador>
    {
        public PermissaoColaboradorMap()
        {
            HasKey(x => x.Id);
            ToTable("PermissoesColaborador");
        }
    }
}
