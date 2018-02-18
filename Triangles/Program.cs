using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Triangles
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Welcome to the triangle testing program:");
            Console.WriteLine();

            while (true) {
                Console.WriteLine("Enter three sides seperated by a comma (1,2,3):");

                String input = Console.ReadLine();

                if (ValidateInput(input)) {

                    int[] values = GetArrayFromInput(input);
                    Console.WriteLine(Triangles.getTriangleType(values[0], values[1], values[2]));
                } else {
                    Console.WriteLine("Invalid input");
                }
            }
        }

        static Boolean ValidateInput(String input) {

            Regex reg = new Regex("^([+-]?[0-9]{1,10}),([+-]?[0-9]{1,10}),([+-]?[0-9]{1,10})$");
            
            if (reg.Match(input).Success) {
                return true;
            }

            return false;
        }

        static int[] GetArrayFromInput(String input) {
            return Array.ConvertAll(input.Split(','), int.Parse);
        } 

    }
}
