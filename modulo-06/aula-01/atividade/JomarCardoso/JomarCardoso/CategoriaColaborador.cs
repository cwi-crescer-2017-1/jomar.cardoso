using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JomarCardoso
{
    class CategoriaColaborador
    {
        public CategoriaColaborador(String tipo, double horas)
        {
            Tipo = tipo;
            Horas = horas;
        }
        public string Tipo { get; set; }
        public double Horas { get; set; }
    }
}
