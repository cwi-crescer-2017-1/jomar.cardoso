using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Entidades;

namespace Locadora.Testes
{
    [TestClass]
    public class TesteEntidades
    {        
        [TestMethod]
        public void BuscarUsuarioValido()
        {
            Usuario usuario = new Usuario("Jomar", "jomar","123456", true);
            Usuario usuario2 = new Usuario("Jomar", "jomar", "123456", false);
            Assert.IsTrue(usuario.Validar());
            Assert.IsTrue(usuario2.Validar());
        }
        [TestMethod]
        public void BuscarUsuarioNomeVazio()
        {
            Usuario usuario = new Usuario("", "jomar", "123456", true);
            Assert.IsFalse(usuario.Validar());
            Assert.AreEqual(usuario.Mensagens[0], "Nome é inválido.");         
        }
        [TestMethod]
        public void BuscarUsuarioLoginComEspacos()
        {
            Usuario usuario = new Usuario("Jomar", "jo mar", "123456", true);
            Assert.IsFalse(usuario.Validar());
            Assert.AreEqual(usuario.Mensagens[0], "Login é inválido.");
        }
        [TestMethod]
        public void BuscarUsuarioSenhaComEspacos()
        {
            Usuario usuario = new Usuario("Jomar", "jomar", "12 3456", true);
            Assert.IsFalse(usuario.Validar());
            Assert.AreEqual(usuario.Mensagens[0], "Senha é inválido.");
        }     
    }
}
