using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Mapping
{
    class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedido");
            HasKey(x => x.Id);
            HasRequired(x => x.Cliente)
                            .WithMany()
                            .HasForeignKey(x => x.Id_Cliente);
            HasRequired(x => x.Produto)
                            .WithMany()
                            .HasForeignKey(x => x.Id_Produto);
            HasOptional(x => x.Pacote)
                            .WithMany()
                            .HasForeignKey(x => x.Id_Pacote);
            //HasOptional(x => x.Opcional)
            //                .WithMany()
            //                .HasForeignKey(x => x.Id_Opcional);
        }
    }
}
