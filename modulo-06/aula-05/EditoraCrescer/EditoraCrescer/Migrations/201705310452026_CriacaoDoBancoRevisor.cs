namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBancoRevisor : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Revisores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 300),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Revisores");
        }
    }
}
