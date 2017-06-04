using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Entidades
{
    public class Livro
    {
        public int Isbn { get; set; }
        public string Titulo { get; set; }
        public string Descricao { get; set; }
        public string Genero { get; set; }
        public DateTime DataPublicacao { get; set; } = DateTime.Now;        
        public int? IdAutor { get; set; }
        [ForeignKey("IdAutor")]
        public Autor Autor { get; set; }
        public int? IdRevisor { get; set; }
        [ForeignKey("IdRevisor")]
        public Revisor Revisor { get; set; }
        public DateTime? DataRevisao { get; set; }// = DateTime.Now;
        public string Capa { get; set; }
    }
}
