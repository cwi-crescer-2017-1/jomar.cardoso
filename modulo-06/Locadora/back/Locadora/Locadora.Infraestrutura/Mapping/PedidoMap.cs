using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mapping
{
    class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedido");
            HasKey(x => x.Id);
            HasRequired(x => x.Cliente)
                .WithMany()
                 .Map(x => x.MapKey("IdCliente"));
            HasRequired(x => x.Produto)
                 .WithMany()
                 .Map(x => x.MapKey("IdProduto"));
            HasOptional(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));
            HasMany(x => x.Opcionais)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdPedido");
                    x.MapRightKey("IdOpcional");
                    x.ToTable("PedidoOpcional");
                }
            );
        }
    }
}
