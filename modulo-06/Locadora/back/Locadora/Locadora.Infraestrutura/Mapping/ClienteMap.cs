﻿using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mapping
{
    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(x => x.Id);
            Property(x => x.Nome)
                .HasMaxLength(50)
                .IsRequired(); 
            Property(x => x.Cpf)
                .IsRequired()
                .HasMaxLength(30);
            Property(x => x.Endereco)
                .IsRequired()
                .HasMaxLength(50);
        }
    }
}
