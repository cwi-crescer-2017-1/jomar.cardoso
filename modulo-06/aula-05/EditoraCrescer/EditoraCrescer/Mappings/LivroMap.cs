using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Mappings
{
    public class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livros");

            HasKey(x => x.Isbn);

            //HasRequired(x => x.Autor)
            //    .WithMany()
            //    .HasForeignKey(x => x.IdAutor);

            //HasRequired(y => y.Revisor)
            //    .WithMany()
            //   .HasForeignKey(y => y.IdRevisor);
        }
    }
}
