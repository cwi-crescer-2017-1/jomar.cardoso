using Demo1.Dominio.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.InfraEstrutura.Repositorios
{
    public class ProdutoRepositorio
    {

        private static string CONEXAO_STRING =
           "Server=13.65.101.67; Database=aluno02db; User id=jomar.cardoso; Password=123456";

        public void Criar(Produto produto)
        {           
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {     
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText = "SELECT @@IDENTITY";
                    produto.Id = (int)(decimal)command.ExecuteScalar();
                }
            }
          }
        
        public List<Produto> Listar()
        {
            var produtos = new List<Produto>();

            using (var conexao = new SqlConnection(CONEXAO_STRING))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT Id, Nome, Preco, Estoque FROM Produto";

                    var dataReader = comando.ExecuteReader();
                    while(dataReader.Read())
                    {
                        var produto = new Produto();
                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];
                        produtos.Add(produto);
                    }
                }
            }
            return produtos;
        }      
    }
}
