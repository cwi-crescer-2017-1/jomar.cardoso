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
            //return 
            //contexto.Colaborador.Where(c => c.Email == email)
            //    .Select(c => new {
            //        Nome = c.Nome,
            //        Email = c.Email,
            //        Senha = c.Senha,
            //        PermissoesColaborador = c.PermissoesColaborador
            //    }).ToList<dynamic>().FirstOrDefault();

            //var colaborador = contexto.Colaborador.Where(c => c.Email == email);
            //var permissoes = colaborador.Include(x => x.PermissoesColaborador).FirstOrDefault(); ;
            //return contexto.Colaborador.Where(u => u.Email == email).FirstOrDefault();//.Include(x => x.PermissoesColaborador);

            return contexto.Colaborador.Include(x => x.PermissoesColaborador).Where(u => u.Email == email).FirstOrDefault();
        }
    }
}
