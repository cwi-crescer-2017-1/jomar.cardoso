namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class droptipo : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Cliente", "MyProperty");
            DropColumn("dbo.Produto", "TipoFesta");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Produto", "TipoFesta", c => c.Int(nullable: false));
            AddColumn("dbo.Cliente", "MyProperty", c => c.Int(nullable: false));
        }
    }
}
