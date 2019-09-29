public class SimpleTeam implements Team {
    private List<Player> players = 
    	new LinkedList<>();
    
    public List<Player> getPlayers() {
        return  players;
    }
    
    public void addPlayer(Player p){
        players.add(p);
    }
}