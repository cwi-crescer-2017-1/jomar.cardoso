namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoFKRevisor : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropColumn("dbo.Livros", "DataRevisao");
            DropColumn("dbo.Livros", "IdRevisor");
        }
    }
}
