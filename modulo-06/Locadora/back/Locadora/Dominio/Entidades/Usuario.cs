﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Usuario : EntidadeBasica
    {
        static readonly char[] _caracteresNovaSenha = "abcdefghijklmnopqrstuvzwyz1234567890*-_".ToCharArray();
        static readonly int _numeroCaracteresNovaSenha = 10;

        public int Id { get; set; }
        public string Nome { get; set; }
        public string Login { get; set; }
        public string Senha { get; set; }
        public bool Gerente { get; set; }

        // Construtor padrão para o Entity Framework
        protected Usuario()
        {
        }

        public Usuario(string nome, string login, string senha, bool gerente)
        {
            Nome = nome;
            Login = login;
            if (!string.IsNullOrWhiteSpace(senha))
                Senha = CriptografarSenha(senha);
            Gerente = gerente;   
        }

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
            byte[] inputBytes = Encoding.Default.GetBytes(Login + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            return CriptografarSenha(senha) == Senha;
        }

        public void AtribuirGerente(bool gerente)
        { 
            Gerente = gerente;
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
