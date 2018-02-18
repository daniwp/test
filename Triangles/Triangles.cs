using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Triangles {
    public class Triangles {

        public static string getTriangleType(int a, int b, int c) {

            if (isOverflow(a, b, c)) {
                return "Invalid triangle";
            }

            if (!isCandidateSides(a, b, c)) {
                return "Invalid triangle";
            }

            if (isEquilateral(a, b, c)) {
                return "The triangle is equilateral";
            }

            if (isIsosceles(a, b, c)) {
                return "The triangle is isosceles";
            }

            if (isScalene(a, b, c)) {
                return "The triangle is scalene";
            }

            return "Invalid triangle";
        }

        public static Boolean isEquilateral(int a, int b, int c) {
            return a == b && c == b;
        }

        public static Boolean isCandidateSides(int a, int b, int c) {
            return a > 0 && b > 0 && c > 0;
        }

        public static Boolean isOverflow(int a, int b, int c) {
            return (a > int.MaxValue && b > int.MaxValue && c > int.MaxValue);
        }

        public static Boolean isIsosceles(int a, int b, int c) {
            return (a == b && c < (a * 2)) || (a == c && b < (a * 2)) || (b == c && a < (b * 2));
        }


        public static Boolean isScalene(int a, int b, int c) {

            int[] sides = { a, b, c };
            int longestSide = sides.Max();
            int[] remainders = new int[2];
            int count = 0;

            for (int i = 0, max = sides.Length; i < max; i++) {
                if (sides[i] != longestSide) {
                    remainders[count] = sides[i];
                    count++;
                }
            }

            return longestSide < remainders[0] + remainders[1];
        }

    }
}
