using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public int Id_Cliente { get; set; }
        public Cliente Cliente { get; set; }
        public int Id_Produto { get; set; }
        public Produto Produto { get; set; }
        public int? Id_Pacote { get; set; }
        public Pacote Pacote { get; set; }
        //public int? Id_Opcional { get; set; }
        public ICollection<Opcional> Opcionais { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public decimal Valor { get; set; }
        public decimal ValorTotal { get; set; }
    }
}
