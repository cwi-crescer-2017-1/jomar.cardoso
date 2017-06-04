namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class autorNull : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            AlterColumn("dbo.Livros", "IdAutor", c => c.Int());
            CreateIndex("dbo.Livros", "IdAutor");
            AddForeignKey("dbo.Livros", "IdAutor", "dbo.Autores", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            AlterColumn("dbo.Livros", "IdAutor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdAutor");
            AddForeignKey("dbo.Livros", "IdAutor", "dbo.Autores", "Id", cascadeDelete: true);
        }
    }
}
