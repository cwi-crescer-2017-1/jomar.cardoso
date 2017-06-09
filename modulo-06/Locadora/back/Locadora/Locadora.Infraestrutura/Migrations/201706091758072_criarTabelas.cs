namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class criarTabelas : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 50),
                        Cpf = c.String(nullable: false, maxLength: 30),
                        Endereco = c.String(nullable: false, maxLength: 50),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 511),
                        quantidade = c.Int(nullable: false),
                        quantidadeDisponivel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 511),
                        quantidade = c.Int(nullable: false),
                        quantidadeDisponivel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 511),
                        quantidade = c.Int(nullable: false),
                        quantidadeDisponivel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 50),
                        Login = c.String(nullable: false, maxLength: 50),
                        Senha = c.String(nullable: false, maxLength: 50),
                        Gerente = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PedidoOpcional",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdOpcional })
                .ForeignKey("dbo.Pedido", t => t.IdPedido, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdOpcional);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Pedido", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Pedido", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.PedidoOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.PedidoOpcional", "IdPedido", "dbo.Pedido");
            DropForeignKey("dbo.Pedido", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.PedidoOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.PedidoOpcional", new[] { "IdPedido" });
            DropIndex("dbo.Pedido", new[] { "IdProduto" });
            DropIndex("dbo.Pedido", new[] { "IdPacote" });
            DropIndex("dbo.Pedido", new[] { "IdCliente" });
            DropTable("dbo.PedidoOpcional");
            DropTable("dbo.Usuario");
            DropTable("dbo.Produto");
            DropTable("dbo.Pedido");
            DropTable("dbo.Pacote");
            DropTable("dbo.Opcional");
            DropTable("dbo.Cliente");
        }
    }
}
