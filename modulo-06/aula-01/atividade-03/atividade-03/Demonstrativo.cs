using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace atividade_03
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
    }
