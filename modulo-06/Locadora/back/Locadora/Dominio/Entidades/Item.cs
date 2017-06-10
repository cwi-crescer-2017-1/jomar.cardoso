using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Item
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public decimal Valor { get; private set; }
        public string Descricao { get; private set; }
        public int Quantidade { get; private set; }
        public int QuantidadeDisponivel { get; private set; }

        public void retirar()
        {
            QuantidadeDisponivel -= 1;
        }
        public void adicionar()
        {
            QuantidadeDisponivel += 1;
        }
    }
}
