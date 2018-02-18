using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Triangles.Tests {

    [TestClass()]
    public class TrianglesTests {

        [TestMethod()]
        public void testZeroLengthSides() {
            Assert.AreEqual(Triangles.isCandidateSides(0, 0, 0), false);
            Assert.AreEqual(Triangles.isCandidateSides(4, 0, 4), false);
            Assert.AreEqual(Triangles.isCandidateSides(0, 4, 4), false);
            Assert.AreEqual(Triangles.isCandidateSides(4, 4, 0), false);
        }

        [TestMethod()]
        public void testNegativeLengthSides() {
            Assert.AreEqual(Triangles.isCandidateSides(-4, -4, -4), false);
            Assert.AreEqual(Triangles.isCandidateSides(-4, 0, 0), false);
            Assert.AreEqual(Triangles.isCandidateSides(0, 0, -4), false);
            Assert.AreEqual(Triangles.isCandidateSides(0, -4, 0), false);
        }

        [TestMethod()]
        public void testOverflowLengthSides() {
            // Not possible to test??
        }

        [TestMethod()]
        public void testEquilateral() {
            Assert.AreEqual(Triangles.isEquilateral(3, 3, 3), true);
            Assert.AreEqual(Triangles.isEquilateral(4, 3, 3), false);
        }

        [TestMethod()]
        public void testIsosceles() {
            Assert.AreEqual(Triangles.isIsosceles(3, 3, 2), true);
            Assert.AreEqual(Triangles.isIsosceles(3, 3, 6), false);
            Assert.AreEqual(Triangles.isIsosceles(3, 3, 7), false);
        }

        [TestMethod()]
        public void testScalene() {
            Assert.AreEqual(Triangles.isScalene(4, 2, 3), true);
            Assert.AreEqual(Triangles.isScalene(4, 2, 7), false);
        }
    }
}