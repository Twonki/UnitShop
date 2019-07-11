public class distanceTests{

    @Test
    public void testDistance_pointIs100Away_shouldBe100(){
        Point a = new Point(0,0);
        Point b = new Point(100,0);

        double distance = a.distanceTo(b);

        assertEquals(100,distance);
    }

    @Test
    public void testDistance_distanceToItself_shouldBe0(){
        Point a = new Point(0,0);

        assertEquals(0,a.distanceTo(a));
    }
}