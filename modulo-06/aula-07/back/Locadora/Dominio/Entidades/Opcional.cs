using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Opcional : Item
    {
        public ICollection<Pedido> Pedidos { get; set; }
    }
}
