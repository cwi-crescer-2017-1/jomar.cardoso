namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class dataRevisaoNull : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
        }
    }
}
