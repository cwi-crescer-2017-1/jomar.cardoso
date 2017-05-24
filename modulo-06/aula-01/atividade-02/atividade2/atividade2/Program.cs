using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//namespace atividade2
//{
//    class Program
//    {
//        static void Main(string[] args)
//        {
//            List<int> entradas = new List<int>();

//            while (true)
//            {
//                Console.WriteLine("Digite um valor: ");
//                var entrada = Console.ReadLine();
//                if (entrada == "exit")
//                {
//                    break
//                        ;
//                }
//                var valor = int.Parse(entrada);
//                entradas.Add(valor);
//            }
//            foreach (var entrada in entradas)
//            {
//                Console.WriteLine(entrada);
                
//            }
//            Console.ReadKey();
//        }
//    }
//}

namespace atividade2
{
    class Program
    {
        static void Main(string[] args)
        {
            var entradas = new int[] { };
            Console.WriteLine("Digite um valor: ");

            while (true)
            {
                var entrada = Console.ReadLine();
                if (entrada == "exit")
                {
                    break;
                }
                var nrEntradas = entradas.Length;
                var entradasAux = new int[nrEntradas + 1];
                for (int i = 0; i < nrEntradas; i++)
                {
                    entradasAux[i] = entradas[i];
                }
                entradasAux[nrEntradas] = int.Parse(entrada);
                entradas = entradasAux;
            }
            foreach (var entrada in entradas)
            {
                Console.WriteLine(entrada);                
            }
            Console.ReadKey();
        }
    }
}