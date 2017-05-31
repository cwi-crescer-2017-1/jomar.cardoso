using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisor.ToList();
        }

        public void Incluir(Revisor revisor)
        {
            contexto.Revisor.Add(revisor);
            contexto.SaveChanges();
        }
        public void Excluir(int id)
        {
            var revisor = new Revisor { Id = id };
            contexto.Revisor.Attach(revisor);
            contexto.Revisor.Remove(revisor);
            contexto.SaveChanges();
        }
    }
}
