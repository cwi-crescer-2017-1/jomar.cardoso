using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        //public PedidoOpcional PedidoOpcionais { get; set; }
        public List<Opcional> Opcionais { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public decimal Valor { get; set; }
        public decimal ValorTotal { get; set; }
    }

    //public decimal CalcularTotal()
    //{

    //    return 10.1;
    //}
}
