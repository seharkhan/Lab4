package domain;

import java.util.ArrayList;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import domain.RuleDomainModel;

public class GamePlayDomainModel {

	
	@XmlElement
	private UUID GameID;
	@XmlElement
	private int MaxNbrOfPlayers;
	@XmlElement
	private int NbrOfCards;
	@XmlElement
	private int NbrOfJokers;
	@XmlElement
	private ArrayList<CardDomainModel> WildCards = new ArrayList<CardDomainModel>();
	
	public UUID GetGameID()
	{
		return this.GameID;
	}
		
	public int GetMaxNumberOfPlayers()
	{
		return MaxNbrOfPlayers;
	}
	
	public int GetNumberOfCards()
	{
		return NbrOfCards;
	}
	
	public int GetNumberOfJokers()
	{
		return NbrOfJokers;
	}
	
	public ArrayList<CardDomainModel> GetWildCards()
	{
		return this.WildCards;
	}

	public UUID getGameID() {
		return GameID;
	}

	public void setGameID(UUID gameID) {
		GameID = gameID;
	}

	public int getMaxNbrOfPlayers() {
		return MaxNbrOfPlayers;
	}

	public void setMaxNbrOfPlayers(int maxNbrOfPlayers) {
		MaxNbrOfPlayers = maxNbrOfPlayers;
	}

	public int getNbrOfCards() {
		return NbrOfCards;
	}

	public void setNbrOfCards(int nbrOfCards) {
		NbrOfCards = nbrOfCards;
	}

	public int getNbrOfJokers() {
		return NbrOfJokers;
	}

	public void setNbrOfJokers(int nbrOfJokers) {
		NbrOfJokers = nbrOfJokers;
	}

	public ArrayList<CardDomainModel> getWildCards() {
		return WildCards;
	}

	public void setWildCards(ArrayList<CardDomainModel> wildCards) {
		WildCards = wildCards;
	}

}
