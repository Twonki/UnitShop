public class distanceTests{
    @Test
    public void testDistance_pointIs100Away_shouldBe100(){
        //Arrange
        Point a = new Point(0,0);
        Point b = new Point(100,0);
        //Act
        double distance = a.distanceTo(b);
        //Assert
        assertEquals(100,distance);
    }

    @Test
    public void testDistance_distanceToItself_shouldBe0(){
        //Arrange
        Point a = new Point(75,6);
        //Act
        double distance = a.distanceTo(a);
        //Assert
        assertEquals(0.0,distance);
    }
}