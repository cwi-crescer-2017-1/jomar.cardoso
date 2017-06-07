using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Api.Models
{
    public class RegistrarPedidoModel
    {
        public Cliente Cliente { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public List<Opcional> Opcionais { get; set; }
        public int DiasAlugado { get; set; }
    }
}