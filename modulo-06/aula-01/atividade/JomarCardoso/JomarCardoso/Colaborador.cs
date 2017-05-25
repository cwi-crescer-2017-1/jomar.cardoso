using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JomarCardoso
{
    class Colaborador
    {
        public Colaborador(
            string nome,
            CategoriaColaborador categoria,
            double salarioBase,
            double horasExtras,
            double horasDescontadas)
        {
            Nome = nome;
            Categoria = categoria;
            SalarioBase = salarioBase;
            HorasExtras = horasExtras;
            double HorasDescontadas = horasDescontadas;
        }
        public String Nome { get; set; }
        public CategoriaColaborador Categoria { get; set; }
        public Double SalarioBase { get; set; }
        public int MyProperty { get; set; }
        public double HorasExtras { get; set; }
        public double HorasDescontadas { get; set; }
    }
}
