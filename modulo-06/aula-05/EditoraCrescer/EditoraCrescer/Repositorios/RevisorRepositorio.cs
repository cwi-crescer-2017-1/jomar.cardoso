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

        public List<Revisor> Obter(int id)
        {
            return contexto.Revisor.Where(r => r.Id == id).ToList();
        }

        public void Incluir(Revisor revisor)
        {
            contexto.Revisor.Add(revisor);
            contexto.SaveChanges();
        }
        public Revisor alterar(int isbn, Revisor revisor)
        {
            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            return revisor;
        }
        public void Excluir(int id)
        {
            var revisor = new Revisor { Id = id };
            contexto.Revisor.Attach(revisor);
            contexto.Revisor.Remove(revisor);
            contexto.SaveChanges();
        }
        public bool validar(int id, Revisor revisor, out List<string> mensagens)
        {
            mensagens = new List<string>();
            //verificar id com id do revisor
            if (revisor.Id != id)
                mensagens.Add("id invalido");
            //verificar se tem revisor com esta isbn
            if (contexto.Revisor.Count(l => l.Id == id) == 0)
                mensagens.Add("Não encontrado");
            var teste = mensagens.Count() != 0;
            return mensagens.Count() != 0;
        }
    }
}
