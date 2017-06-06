using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mapping
{
    class OpcionalMap : EntityTypeConfiguration<Opcional>
    {
        public OpcionalMap()
        {
            ToTable("Opcional");
            HasKey(x => x.Id);
            Property(x => x.Nome).HasMaxLength(50);
            Property(x => x.Descricao).HasMaxLength(50);
        }
    }
}
