using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Mapping
{
    class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacote");
            HasKey(x => x.Id);
            Property(x => x.Nome).HasMaxLength(50);
            Property(x => x.Descricao).HasMaxLength(50);
        }
    }
}
