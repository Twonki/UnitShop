public class MockTeam implements Team{
    
    public List<Player> fakePlayerList = new LinkedList<>();
    public boolean invokedGetPlayers=false;

    public List<Player> getPlayers(){
        invokedGetPlayers=true;
        return fakePlayerList;
    }

}