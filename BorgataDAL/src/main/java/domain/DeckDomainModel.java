package domain;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import enums.eRank;
import enums.eSuit;

@XmlRootElement
public class DeckDomainModel {
	
	@XmlElement (name="Remaining Card")
	public ArrayList<CardDomainModel> cards;

}