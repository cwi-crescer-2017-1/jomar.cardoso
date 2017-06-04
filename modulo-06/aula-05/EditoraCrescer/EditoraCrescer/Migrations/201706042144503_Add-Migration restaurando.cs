namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddMigrationrestaurando : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.UsuarioPermissaos", "Usuario_Id", "dbo.Usuarios");
            DropForeignKey("dbo.UsuarioPermissaos", "Permissao_Id", "dbo.Permissao");
            DropIndex("dbo.UsuarioPermissaos", new[] { "Usuario_Id" });
            DropIndex("dbo.UsuarioPermissaos", new[] { "Permissao_Id" });
            DropTable("dbo.Permissao");
            DropTable("dbo.Usuarios");
            DropTable("dbo.UsuarioPermissaos");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.UsuarioPermissaos",
                c => new
                    {
                        Usuario_Id = c.Guid(nullable: false),
                        Permissao_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Usuario_Id, t.Permissao_Id });
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateIndex("dbo.UsuarioPermissaos", "Permissao_Id");
            CreateIndex("dbo.UsuarioPermissaos", "Usuario_Id");
            AddForeignKey("dbo.UsuarioPermissaos", "Permissao_Id", "dbo.Permissao", "Id", cascadeDelete: true);
            AddForeignKey("dbo.UsuarioPermissaos", "Usuario_Id", "dbo.Usuarios", "Id", cascadeDelete: true);
        }
    }
}
