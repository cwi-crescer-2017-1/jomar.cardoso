namespace EditoraCrescer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class colaboradorPermissoes : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Permissoes", newName: "PermissoesColaborador");
        }
        
        public override void Down()
        {
            RenameTable(name: "dbo.PermissoesColaborador", newName: "Permissoes");
        }
    }
}
