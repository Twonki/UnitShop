public class SimpleTeamTest{
    @Test 
    void addPlayer_WithstubPlayer_ShouldHaveOnePlayer(){
        //Arrange
        Team testObject = new SimpleTeam();
        Player stub = new StubPlayer();
        //Act
        testObject.addPlayer(stub);
        //Assert
        assertEquals(1,testObject.getPlayers().size());
    }
    @Test
    void addPlayer_WithStubPlayer_shouldContainStubPlayer(){
        //Arrange
        Team testObject = new SimpleTeam();
        Player stub = new StubPlayer();
        //Act
        testObject.addPlayer(stub);
        //Assert
        assertTrue(testObject.getPlayers().contains(stub));
    }
}