package domain;

import java.util.ArrayList;
import java.util.UUID;

public class TableDomainModel {

	private UUID TableID;
	
	public UUID getTableID() {
		return TableID;
	}


	public void setTableID(UUID tableID) {
		TableID = tableID;
	}


	public TableDomainModel ()
	{
		setTableID(UUID.randomUUID());
		
	}
}
