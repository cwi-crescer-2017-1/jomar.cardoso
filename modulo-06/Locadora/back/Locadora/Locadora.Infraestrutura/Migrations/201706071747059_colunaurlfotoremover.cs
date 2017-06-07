namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class colunaurlfotoremover : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Opcional", "urlFoto");
            DropColumn("dbo.Pacote", "urlFoto");
            DropColumn("dbo.Produto", "urlFoto");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Produto", "urlFoto", c => c.String());
            AddColumn("dbo.Pacote", "urlFoto", c => c.String());
            AddColumn("dbo.Opcional", "urlFoto", c => c.String());
        }
    }
}
