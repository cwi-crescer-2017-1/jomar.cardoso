using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Opcional : Item
    {
        public List<Pedido> Pedidos { get; private set; }
    }
}
