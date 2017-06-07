namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajudarTamanhosDescricoes : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Opcional", "Descricao", c => c.String(maxLength: 511));
            AlterColumn("dbo.Produto", "Descricao", c => c.String(maxLength: 511));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Produto", "Descricao", c => c.String(maxLength: 50));
            AlterColumn("dbo.Opcional", "Descricao", c => c.String(maxLength: 50));
        }
    }
}
