﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JomarCardoso
{
    public interface IFolhaPagamento
    {
        Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas);
    }
}
