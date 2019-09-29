public class SimplePlayer implements Player{
    String name;
    public SimplePlayer(String name){
        this.name=name;
    }
    public void addToTeam(Team){
        Team.getPlayers().add(this);
    }
}