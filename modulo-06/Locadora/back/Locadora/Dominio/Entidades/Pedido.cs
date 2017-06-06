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
        public int Id { get; private set; }
        public Cliente Cliente { get; private set; }
        public Produto Produto { get; private set; }
        public Pacote Pacote { get; private set; }
        //public PedidoOpcional PedidoOpcionais { get; set; }
        public List<Opcional> Opcionais { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaRealizada { get; private set; }
        public decimal Valor { get; private set; }
        public decimal ValorTotal { get; private set; }
    }

    //public decimal CalcularTotal()
    //{

    //    return 10.1;
    //}
}
