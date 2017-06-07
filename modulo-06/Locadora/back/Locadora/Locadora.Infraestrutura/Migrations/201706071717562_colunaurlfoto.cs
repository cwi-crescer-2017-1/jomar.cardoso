namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class colunaurlfoto : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Opcional", "urlFoto", c => c.String());
            AddColumn("dbo.Pacote", "urlFoto", c => c.String());
            AddColumn("dbo.Produto", "urlFoto", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Produto", "urlFoto");
            DropColumn("dbo.Pacote", "urlFoto");
            DropColumn("dbo.Opcional", "urlFoto");
        }
    }
}
