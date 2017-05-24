using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace atividade_03
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Teste_Industria_Salario_1000()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 1000, 50, 10);

            Assert.IsNotNull(result);

        }
    }
}
