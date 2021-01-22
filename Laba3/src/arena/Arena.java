package arena;

import droids.Team;

public class Arena {
    public Team team1;
    public Team team2;
    public Arena(){
        team1 = new Team("RedTeam");
        team2 = new Team("BlueTeam");
    }
}