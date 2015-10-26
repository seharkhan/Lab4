package domain;

import java.util.UUID;

public class PlayerDomainModel {

	private UUID PlayerID;
	private String PlayerName;
	private int iPlayerPosition;
	
	public PlayerDomainModel(String PlayerName, int iPlayerPosition) {
	
		this.setPlayerID(UUID.randomUUID());
		this.setPlayerName(PlayerName);
		this.setiPlayerPosition(iPlayerPosition);	
	}

	public UUID getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(UUID playerID) {
		PlayerID = playerID;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public int getiPlayerPosition() {
		return iPlayerPosition;
	}

	public void setiPlayerPosition(int iPlayerPosition) {
		this.iPlayerPosition = iPlayerPosition;
	}

	
}
