namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class fixNtoN : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.PermissaoColaboradorColaboradors", newName: "ColaboradorPermissao");
            RenameColumn(table: "dbo.ColaboradorPermissao", name: "PermissaoColaborador_Id", newName: "IdPermissao");
            RenameColumn(table: "dbo.ColaboradorPermissao", name: "Colaborador_Id", newName: "IdUsuario");
            RenameIndex(table: "dbo.ColaboradorPermissao", name: "IX_Colaborador_Id", newName: "IX_IdUsuario");
            RenameIndex(table: "dbo.ColaboradorPermissao", name: "IX_PermissaoColaborador_Id", newName: "IX_IdPermissao");
            DropPrimaryKey("dbo.ColaboradorPermissao");
            AddColumn("dbo.Colaboradores", "PermissaoColaborador_Id", c => c.Int());
            AddPrimaryKey("dbo.ColaboradorPermissao", new[] { "IdUsuario", "IdPermissao" });
            CreateIndex("dbo.Colaboradores", "PermissaoColaborador_Id");
            AddForeignKey("dbo.Colaboradores", "PermissaoColaborador_Id", "dbo.PermissoesColaborador", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Colaboradores", "PermissaoColaborador_Id", "dbo.PermissoesColaborador");
            DropIndex("dbo.Colaboradores", new[] { "PermissaoColaborador_Id" });
            DropPrimaryKey("dbo.ColaboradorPermissao");
            DropColumn("dbo.Colaboradores", "PermissaoColaborador_Id");
            AddPrimaryKey("dbo.ColaboradorPermissao", new[] { "PermissaoColaborador_Id", "Colaborador_Id" });
            RenameIndex(table: "dbo.ColaboradorPermissao", name: "IX_IdPermissao", newName: "IX_PermissaoColaborador_Id");
            RenameIndex(table: "dbo.ColaboradorPermissao", name: "IX_IdUsuario", newName: "IX_Colaborador_Id");
            RenameColumn(table: "dbo.ColaboradorPermissao", name: "IdUsuario", newName: "Colaborador_Id");
            RenameColumn(table: "dbo.ColaboradorPermissao", name: "IdPermissao", newName: "PermissaoColaborador_Id");
            RenameTable(name: "dbo.ColaboradorPermissao", newName: "PermissaoColaboradorColaboradors");
        }
    }
}
