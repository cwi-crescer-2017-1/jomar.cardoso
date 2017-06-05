namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class colaborador : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Colaboradores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissoes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PermissaoColaboradorColaboradors",
                c => new
                    {
                        PermissaoColaborador_Id = c.Int(nullable: false),
                        Colaborador_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.PermissaoColaborador_Id, t.Colaborador_Id })
                .ForeignKey("dbo.Permissoes", t => t.PermissaoColaborador_Id, cascadeDelete: true)
                .ForeignKey("dbo.Colaboradores", t => t.Colaborador_Id, cascadeDelete: true)
                .Index(t => t.PermissaoColaborador_Id)
                .Index(t => t.Colaborador_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PermissaoColaboradorColaboradors", "Colaborador_Id", "dbo.Colaboradores");
            DropForeignKey("dbo.PermissaoColaboradorColaboradors", "PermissaoColaborador_Id", "dbo.Permissoes");
            DropIndex("dbo.PermissaoColaboradorColaboradors", new[] { "Colaborador_Id" });
            DropIndex("dbo.PermissaoColaboradorColaboradors", new[] { "PermissaoColaborador_Id" });
            DropTable("dbo.PermissaoColaboradorColaboradors");
            DropTable("dbo.Permissoes");
            DropTable("dbo.Colaboradores");
        }
    }
}
