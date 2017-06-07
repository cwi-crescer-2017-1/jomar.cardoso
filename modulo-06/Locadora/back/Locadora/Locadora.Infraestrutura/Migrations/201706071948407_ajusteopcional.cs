namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajusteopcional : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.PedidoOpcionals", newName: "PedidoOpcional");
            RenameColumn(table: "dbo.PedidoOpcional", name: "Pedido_Id", newName: "IdPedido");
            RenameColumn(table: "dbo.PedidoOpcional", name: "Opcional_Id", newName: "IdOpcional");
            RenameIndex(table: "dbo.PedidoOpcional", name: "IX_Pedido_Id", newName: "IX_IdPedido");
            RenameIndex(table: "dbo.PedidoOpcional", name: "IX_Opcional_Id", newName: "IX_IdOpcional");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.PedidoOpcional", name: "IX_IdOpcional", newName: "IX_Opcional_Id");
            RenameIndex(table: "dbo.PedidoOpcional", name: "IX_IdPedido", newName: "IX_Pedido_Id");
            RenameColumn(table: "dbo.PedidoOpcional", name: "IdOpcional", newName: "Opcional_Id");
            RenameColumn(table: "dbo.PedidoOpcional", name: "IdPedido", newName: "Pedido_Id");
            RenameTable(name: "dbo.PedidoOpcional", newName: "PedidoOpcionals");
        }
    }
}
