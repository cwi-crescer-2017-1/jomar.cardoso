using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JomarCardoso
{
    public class Demonstrativo
    {
        public Demonstrativo(
            double salarioBase,
            double hrsConvencao,
            HorasCalculadas horasExtras,
            HorasCalculadas horasDescontadas,
            double totalProventos,
            Desconto inss,
            Desconto irrf,
            double totalDescontos,
            double totalLiquido,
            Desconto fgts)
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }

        public double SalarioBase { get; set; }
        public double HrsConvencao { get; set; }
        public HorasCalculadas HorasExtras { get; set; }
        public HorasCalculadas HorasDescontadas { get; set; }
        public double TotalProventos{ get; set; }
        public Desconto Inss { get; set; }
        public Desconto Irrf { get; set; }
        public double TotalDescontos { get; set; }
        public double TotalLiquido { get; set; }
        public Desconto Fgts { get; set; }
    }
}