using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JomarCardoso
{
    public class CalculoFolhaPagamento : IFolhaPagamento
    {
   
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double hx, double hd)
        {
            double valorHora = salarioBase / horasCategoria;
            HorasCalculadas horasExtras = new HorasCalculadas(hx, valorHora * hx);
            HorasCalculadas horasDescontadas = new HorasCalculadas(hd, valorHora * hd);
            double totalProventos = salarioBase - horasDescontadas.ValorTotalHoras + horasExtras.ValorTotalHoras;
            Desconto inss = CalcularInss(totalProventos);
            Desconto irrf = CalcularIrrf(totalProventos - inss.Valor);
            double totalDescontos = (inss.Valor + irrf.Valor);
            double totalLiquido = (totalProventos - totalDescontos);
            Desconto fgts = new Desconto(0.11, totalProventos * 0.11);
            Demonstrativo retorno = new Demonstrativo
                (
                    salarioBase,
                    horasCategoria,
                    horasExtras,
                    horasDescontadas,
                    totalProventos,
                    inss,
                    irrf,
                    totalDescontos,
                    totalLiquido,
                    fgts
                );
            return retorno;
        }

        public Desconto CalcularInss(double totalProventos)
        {
           double aliquota = 0.8;
           if(totalProventos > 1000)
            {
                aliquota = 0.9;
            }
            if (totalProventos > 1500)
            {
                aliquota = 0.1;
            }
            return new Desconto(aliquota, totalProventos * aliquota);
        }

        public Desconto CalcularIrrf(double totalProventos)
        {
            double aliquota = 0;
            if (totalProventos > 1710.78)
            {
                aliquota = 0.75;
            }
            if (totalProventos > 2563.91)
            {
                aliquota = 0.15;
            }
            if (totalProventos > 3418.59)
            {
                aliquota = 0.225;
            }
            if (totalProventos > 4271.59)
            {
                aliquota = 0.275;
            }

            return new Desconto(aliquota, totalProventos * aliquota);
        }


    }

}
