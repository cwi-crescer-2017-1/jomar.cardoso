namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriarTodasTabelasPaaaaaaaaaaaaaaaaaaa : DbMigration
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
                        MyProperty = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 50),
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
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 511),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        TipoFesta = c.Int(nullable: false),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 50),
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
                "dbo.PedidoOpcionals",
                c => new
                    {
                        Pedido_Id = c.Int(nullable: false),
                        Opcional_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Pedido_Id, t.Opcional_Id })
                .ForeignKey("dbo.Pedido", t => t.Pedido_Id, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.Opcional_Id, cascadeDelete: true)
                .Index(t => t.Pedido_Id)
                .Index(t => t.Opcional_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Pedido", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Pedido", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.PedidoOpcionals", "Opcional_Id", "dbo.Opcional");
            DropForeignKey("dbo.PedidoOpcionals", "Pedido_Id", "dbo.Pedido");
            DropForeignKey("dbo.Pedido", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.PedidoOpcionals", new[] { "Opcional_Id" });
            DropIndex("dbo.PedidoOpcionals", new[] { "Pedido_Id" });
            DropIndex("dbo.Pedido", new[] { "IdProduto" });
            DropIndex("dbo.Pedido", new[] { "IdPacote" });
            DropIndex("dbo.Pedido", new[] { "IdCliente" });
            DropTable("dbo.PedidoOpcionals");
            DropTable("dbo.Usuario");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.Pedido");
            DropTable("dbo.Opcional");
            DropTable("dbo.Cliente");
        }
    }
}
