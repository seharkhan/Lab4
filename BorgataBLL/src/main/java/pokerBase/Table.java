package pokerBase;

import java.util.ArrayList;

import domain.TableDomainModel;

public class Table extends TableDomainModel {

	private ArrayList<Player> Players = new ArrayList<Player>();
	
	public Table() {
		super();
	}

	public ArrayList<Player> getPlayers() {
		return Players;
	}

	public void setPlayers(ArrayList<Player> players) {
		Players = players;
	}

	public Table addPlayer(Player p)
	{
		Players.add(p);
		return this;
	}

	public Table removePlayer(Player p)
	{
		Players.remove(p);
		return this;
	}
}
