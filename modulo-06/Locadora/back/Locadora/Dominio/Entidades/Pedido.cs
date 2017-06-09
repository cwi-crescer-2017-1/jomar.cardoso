using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Pedido : EntidadeBasica
    {
        public int Id { get; private set; }
        public Cliente Cliente { get; private set; }
        public Produto Produto { get; private set; }
        public Pacote Pacote { get; private set; }
        public List<Opcional> Opcionais { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaRealizada { get; private set; }
        public decimal Valor { get; private set; }
        public decimal ValorTotal { get; private set; } 

        protected Pedido()
        {
        }

        public Pedido(Cliente cliente, Produto produto, Pacote pacote, List<Opcional> opcionais, int diasAlugado) 
        {
            decimal valorPacote = 0;
            List<decimal> valorOpcionais = new List<decimal>();
            valorOpcionais.Add(0);
            Cliente = cliente;
            Produto = produto;
            if (pacote != null)
            {
                Pacote = pacote;
                valorPacote = pacote.Valor;
            } 
            if (opcionais != null)
            {
                Opcionais = opcionais;
                valorOpcionais = opcionais.Select(x => x.Valor).ToList<decimal>();
            }
                
            DataPedido = DateTime.Now;
            DataEntregaPrevista = DataPedido.AddDays(diasAlugado);
            
            
            Valor = CalcularValor(produto, valorPacote, valorOpcionais, diasAlugado);
        }

        public decimal CalcularValor(Produto produto, decimal pacote, List<decimal> opcionais, int diasAlugado)
        {
            return (
                produto.Valor + 
                pacote + 
                opcionais.Sum(x => x)
                ) * diasAlugado;
        }

        public decimal CalcularValor(int diasAlugado)
        {
            return CalcularValor(Produto, Pacote.Valor, Opcionais.Select(x => x.Valor).ToList<decimal>(), diasAlugado);
        }

        public override bool Validar()
        {
            Mensagens.Clear();
            if (Cliente == null)
                Mensagens.Add("Cliente não informado.");
            if (Produto == null)
                Mensagens.Add("Produto não informado.");            
            if (DataEntregaPrevista <= DateTime.Now)
                Mensagens.Add("Data de devolução menor que a data atual.");
            return Mensagens.Count == 0;
        }
        public void devolver()
        {
            DataEntregaRealizada = DateTime.Now;
            if(DataEntregaPrevista < DataEntregaRealizada)
            {
                var diasExcedidos = Convert.ToInt32(DataEntregaRealizada.Value.Subtract(DataEntregaPrevista).TotalDays);
                ValorTotal = Valor + CalcularValor(diasExcedidos);
            }
        }
    }
}
