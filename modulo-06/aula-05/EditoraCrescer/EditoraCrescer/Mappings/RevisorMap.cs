using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Mappings
{
    public class RevisorMap : EntityTypeConfiguration<Revisor>
    {
           public RevisorMap()
        {
            HasKey(x => x.Id);
            ToTable("Revisores");
            Property(p => p.Nome).HasMaxLength(300);            
        }
    }
}
