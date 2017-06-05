using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Repositorios
{
    public class ColaboradorRepositorio
    {
        //static readonly Dictionary<string, Colaborador> _colaboradores = new Dictionary<string, Colaborador>();
        private Contexto contexto = new Contexto();
        public Colaborador Obter(string email)
        {
            return contexto.Colaborador.Include(x => x.PermissoesColaborador).Where(u => u.Email == email).FirstOrDefault();
        }

        public void Criar(Colaborador colaborador)
        {
            contexto.Colaborador.Add(colaborador);
            contexto.SaveChanges();
        }
    }
}
