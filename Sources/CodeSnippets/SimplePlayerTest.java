public class SimplePlayerTest{
    @Test
    void addToTeam_withMockTeam_MockTeamShouldHaveInvokedGetPlayers(){
        //Arrange
        Player testObject = new SimplePlayer("Diego");
        MockTeam mock = new MockTeam();
        //Act
        testObject.addToTeam(mock);
        //Assert
        assertTrue(mock.invokedGetPlayers);
    }

    @Test
    void addToTeam_withMockTeam_MockTeamShouldContainPlayer(){
        //Arrange
        Player testObject = new SimplePlayer("Diego");
        MockTeam mock = new MockTeam();
        //Act
        testObject.addToTeam(mock);
        //Assert
        assertTrue(mock.fakePlayerList.contains(testObject));
    }
}