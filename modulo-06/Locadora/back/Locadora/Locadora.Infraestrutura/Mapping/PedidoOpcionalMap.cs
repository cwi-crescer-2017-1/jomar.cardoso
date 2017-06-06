using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mapping
{
    public class PedidoOpcionalMap : EntityTypeConfiguration<PedidoOpcional>
    {
        //public PedidoOpcionalMap()
        //{
        //    ToTable("PedidoOpcional");
        //    HasKey(x => x.Id);
        //    HasRequired(x => x.Pedido)
        //        .WithMany()
        //        .Map(x => x.MapKey("IdPedido"));
        //    HasRequired(x => x.Opcional)
        //        .WithMany()
        //        .Map(x => x.MapKey("IdOpcional"));
        //}
    }
}
