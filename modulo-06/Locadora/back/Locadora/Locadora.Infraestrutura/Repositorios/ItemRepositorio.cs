﻿using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public abstract class ItemRepositorio : IDisposable
    {
        public Contexto contexto = new Contexto();
        abstract public  List<Item> Obter();
        abstract public Item Obter(int id);
        public void Dispose()
        {
            ((IDisposable)contexto).Dispose();
        }
    }
}
