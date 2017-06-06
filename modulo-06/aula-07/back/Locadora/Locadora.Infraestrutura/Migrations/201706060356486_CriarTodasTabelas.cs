namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriarTodasTabelas : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Cpf = c.String(maxLength: 30),
                        Endereco = c.String(maxLength: 50),
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
                        Descricao = c.String(maxLength: 50),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Id_Cliente = c.Int(nullable: false),
                        Id_Produto = c.Int(nullable: false),
                        Id_Pacote = c.Int(),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.Id_Cliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.Id_Pacote)
                .ForeignKey("dbo.Produto", t => t.Id_Produto, cascadeDelete: true)
                .Index(t => t.Id_Cliente)
                .Index(t => t.Id_Produto)
                .Index(t => t.Id_Pacote);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 50),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Descricao = c.String(maxLength: 50),
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
                        Nome = c.String(maxLength: 50),
                        Login = c.String(maxLength: 50),
                        Senha = c.String(maxLength: 50),
                        Gerente = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PedidoOpcional",
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
            DropForeignKey("dbo.Pedido", "Id_Produto", "dbo.Produto");
            DropForeignKey("dbo.Pedido", "Id_Pacote", "dbo.Pacote");
            DropForeignKey("dbo.PedidoOpcional", "Opcional_Id", "dbo.Opcional");
            DropForeignKey("dbo.PedidoOpcional", "Pedido_Id", "dbo.Pedido");
            DropForeignKey("dbo.Pedido", "Id_Cliente", "dbo.Cliente");
            DropIndex("dbo.PedidoOpcional", new[] { "Opcional_Id" });
            DropIndex("dbo.PedidoOpcional", new[] { "Pedido_Id" });
            DropIndex("dbo.Pedido", new[] { "Id_Pacote" });
            DropIndex("dbo.Pedido", new[] { "Id_Produto" });
            DropIndex("dbo.Pedido", new[] { "Id_Cliente" });
            DropTable("dbo.PedidoOpcional");
            DropTable("dbo.Usuario");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.Pedido");
            DropTable("dbo.Opcional");
            DropTable("dbo.Cliente");
        }
    }
}
