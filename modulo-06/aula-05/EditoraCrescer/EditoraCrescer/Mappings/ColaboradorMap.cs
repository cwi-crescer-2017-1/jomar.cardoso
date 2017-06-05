using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Mappings
{
    class ColaboradorMap : EntityTypeConfiguration<Colaborador>
    {
        public ColaboradorMap()
        {
            HasKey(x => x.Id);
            
            ToTable("Colaboradores");
            HasMany(x => x.PermissoesColaborador).WithMany().Map(x =>
            {
                x.MapLeftKey("IdUsuario");
                x.MapRightKey("IdPermissao");
                x.ToTable("ColaboradorPermissao");
            });
        }
    }
}
