using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace JomarCardoso
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Teste_Industria_Salario_5000()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(5000, result.SalarioBase, 0.1);
            Assert.AreEqual(1250, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(250.0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(6000.0, result.TotalProventos, 0.1);
            Assert.AreEqual(600.0, result.Inss.Valor, 0.1);
            Assert.AreEqual(1485.0, result.Irrf.Valor, 0.1);
            Assert.AreEqual(2085.0, result.TotalDescontos, 0.1);
            Assert.AreEqual(3915.0, result.TotalLiquido, 0.1);
            Assert.AreEqual(660.0, result.Fgts.Valor, 0.1);
        }
    }
}
