using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dojo
{
    class Program
    {
        static void Main(string[] args)
        {
            using (var fs = File.OpenRead(@"C:\test.csv"))
            using (var reader = new StreamReader(fs))
            {
                List<string> listA = new List<string>();
                while (!reader.EndOfStream)
                {
                    var line = reader.ReadLine();
                    var values = line.Split(';');
                    listA.Add(values[0]); 
                }
            }
        }

        public static void main()
        {

        }
    }
}

