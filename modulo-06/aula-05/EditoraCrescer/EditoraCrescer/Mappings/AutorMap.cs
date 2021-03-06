﻿using EditoraCrescer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Mappings
{
    public class AutorMap : EntityTypeConfiguration<Autor>
    {
        public AutorMap()
        {
            HasKey(x => x.Id);

            ToTable("Autores");
            Property(p => p.Nome).HasMaxLength(300);
        }
    }
}
