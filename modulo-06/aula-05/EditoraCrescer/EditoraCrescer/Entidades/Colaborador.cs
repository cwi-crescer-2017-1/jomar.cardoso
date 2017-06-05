using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Entidades
{
    public class Colaborador : EntidadeBasica
    {
        static readonly char[] _caracteresNovaSenha = "abcdefghijklmnopqrstuvzwyz1234567890*-_".ToCharArray();
        static readonly int _numeroCaracteresNovaSenha = 10;
        public int Id { get; private set; }
        public string Nome { get;  set; }
        public string Email { get;  set; }
        public string Senha { get;  set; }
        public ICollection<PermissaoColaborador> PermissoesColaborador { get; set; }

        // Construtor padrão para o Entity Framework
        public Colaborador()
        {
            //this.PermissoesColaborador = new HashSet<PermissaoColaborador>();
        }

        public Colaborador(string nome, string email, string senha)
        {
            Nome = nome;
            Email = email;
            //Id = Guid.NewGuid();
            //if (!string.IsNullOrWhiteSpace(senha))
            //    Senha = CriptografarSenha(senha);
            PermissoesColaborador = new List<PermissaoColaborador>();
            AtribuirPermissoes("Colaborador");
        }

        //implementa EntidadeBasica
        public string ResetarSenha()
        {
            var senha = string.Empty;
            for (int i = 0; i < _numeroCaracteresNovaSenha; i++)
            {
                senha += new Random().Next(0, _caracteresNovaSenha.Length);
            }

            Senha = CriptografarSenha(senha);

            return senha;
        }

        private string CriptografarSenha(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.Default.GetBytes(Email + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            var superCao = CriptografarSenha(senha);
            return CriptografarSenha(senha) == Senha;
        }

        public void AtribuirPermissoes(params string[] nomes)
        {
            foreach (var nome in nomes)
                PermissoesColaborador.Add(new PermissaoColaborador(nome));
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Email))
                Mensagens.Add("Email é inválido.");

            if (string.IsNullOrWhiteSpace(Senha))
                Mensagens.Add("Senha é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
