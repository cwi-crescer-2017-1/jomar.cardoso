using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
                        @"Server=13.65.101.67;
                        User Id=jomar.cardoso;
                        Password=123456;
                        Database=aluno02db";
        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }      
        // INSERIR NO BANCO
        public void Criar(Pedido pedido)
        {            
            using (var conexao = new SqlConnection(stringConexao))
            {
                // realizar o insert do Pedido
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO Pedido (NomeCliente)
                        VALUES(@nomeCliente)";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }
                // obter o ultimo id do pedido (SELECT @@IDENTITY)
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }
            }            
            // para cada item do pedido, realizar o insert do ItemPedido
            using (var conexao = new SqlConnection(stringConexao))
            {
                foreach (var item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            @"INSERT INTO ItemPedido (IdPedido, IdProduto, Quantidade)" +
                            " VALUES(@idPedido, @idProduto, @quantidade";

                        comando.Parameters.AddWithValue("@idPedido", pedido.Id);
                        comando.Parameters.AddWithValue("@idProduto", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = "SELECT @@IDENTITY";

                        var result = (decimal)comando.ExecuteScalar();
                        item.Id = (int)result;
                    }
                }
            }
            using (var conexao = new SqlConnection(stringConexao))
            {
                foreach (var item in pedido.Itens)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            @"UPDATE Produto
                            SET Estoque = Estoque - @remover
                            WHERE Id = @idproduto";

                        comando.Parameters.AddWithValue("@idproduto", item.ProdutoId);
                        comando.Parameters.AddWithValue("@remover", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = "SELECT @@IDENTITY";

                        var result = (decimal)comando.ExecuteScalar();
                        item.Id = (int)result;
                    }
                }
            }
        }

        

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }
        // BUSCAR DO BANCO
        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, NomeCliente " +
                        "FROM Pedido";

                    using (var dataReader = comando.ExecuteReader())
                    {
                        while (dataReader.Read())
                        {
                            var pedido = new Pedido();

                            pedido.Id = (int)dataReader["Id"];
                            pedido.NomeCliente = (string)dataReader["NomeCliente"];
                            pedidos.Add(pedido);
                        }
                    }
                    
                }     
            }
            
            return ListarItens(pedidos);
        }

        public List<Pedido> ListarItens(List<Pedido> pedidos)
        {
            
            using (var conexao2 = new SqlConnection(stringConexao))
            {
                conexao2.Open();
                using (var comando2 = conexao2.CreateCommand())
                {
                    foreach (var pedido in pedidos)
                    {
                        List<ItemPedido> itens = new List<ItemPedido>();
                        comando2.CommandText =
                        @"SELECT IPo.Id, IPo.ProdutoId, IPo.Quantidade " +
                        " FROM ItemPedido IPo " +
                        " INNER JOIN Pedido Ped ON Ped.Id = IPo.PedidoId " +
                        " WHERE Ped.Id = @idped ";

                        comando2.Parameters.Clear();
                        comando2.Parameters.AddWithValue("@idped", pedido.Id);

                        using (var dataReader2 = comando2.ExecuteReader())
                        {
                            while (dataReader2.Read())
                            {
                                var itemPedido = new ItemPedido();
                                itemPedido.Id = (int)dataReader2["Id"];
                                itemPedido.ProdutoId = (int)dataReader2["ProdutoId"];
                                itemPedido.Quantidade = (int)dataReader2["Quantidade"];
                                itens.Add(itemPedido);
                            }
                            pedido.Itens = itens;
                        }                       
                    }
                }
            }            
            return pedidos;
        }


        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}


/*
 * CREATE TABLE Pedido (
	Id INT IDENTITY(1,1) NOT NULL CONSTRAINT [PK_Pedido] PRIMARY KEY,
	NomeCliente VARCHAR(256) NOT NULL,
);

CREATE TABLE ItemPedido (
	Id INT IDENTITY(1,1) NOT NULL CONSTRAINT [PK_ItemPedido] PRIMARY KEY,
	PedidoId INT NOT NULL CONSTRAINT [FK_ItemPedio_Pedido] FOREIGN KEY REFERENCES Pedido(Id),
	ProdutoId INT NOT NULL CONSTRAINT [FK_ItemPedio_Produto] FOREIGN KEY REFERENCES Produto(Id),
	Quantidade INT NOT NULL
);*/
 
