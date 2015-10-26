package poker.app.view;

import enums.eGame;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import poker.app.MainApp;
import pokerBase.Card;
import pokerBase.Deck;
import pokerBase.GamePlay;
import pokerBase.GamePlayPlayerHand;
import pokerBase.Hand;
import pokerBase.Player;
import pokerBase.Rule;

public class PokerTableController {

	boolean bP1Sit = false;
	
	// Reference to the main application.
	private MainApp mainApp;
	private GamePlay gme = null;
	private int iCardDrawn = 0;
	
	@FXML
	public HBox h1P1;

	@FXML
	public TextField txtP1Name;
	
	@FXML
	public Label lblP1Name;

	@FXML
	public ToggleButton btnP1SitLeave;
	
	@FXML
	public Button btnDraw;
	
	@FXML
	public Button btnPlay;

	public PokerTableController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	@FXML
	private void handleP1SitLeave() {
		
		int iPlayerPosition = 1;
		
		if (bP1Sit == false)
		{
			Player p = new Player(txtP1Name.getText(),iPlayerPosition);
			mainApp.AddPlayerToTable(p);
			lblP1Name.setText(txtP1Name.getText());
			lblP1Name.setVisible(true);
			btnP1SitLeave.setText("Leave");
			txtP1Name.setVisible(false);
			bP1Sit = true;
		}
		else
		{
			mainApp.RemovePlayerFromTable(iPlayerPosition);
			btnP1SitLeave.setText("Sit");
			txtP1Name.setVisible(true);
			lblP1Name.setVisible(false);
			bP1Sit = false;			
		}
		
	}
	
	@FXML
	private void handleDraw()
	{
		iCardDrawn++;
				
		//	Draw a card for each player seated		
		for (Player p: mainApp.GetSeatedPlayers())
		{
				Card c = gme.getGameDeck().drawFromDeck();
				
				if (p.getiPlayerPosition() == 1)				
				{
					GamePlayPlayerHand GPPH = gme.FindPlayerGame(gme, p);
					GPPH.addCardToHand(c);
					String strCard = "/res/img/" + c.getCardImg() ;		
					ImageView img = new ImageView(new Image(getClass().getResourceAsStream(
							strCard), 75, 75, true, true));
					h1P1.getChildren().add(img);
					
					
					
					if (iCardDrawn == 5)
					{
						GPPH.getHand().EvalHand();
						System.out.println(GPPH.getHand().getHandStrength());
					}
				}
		}
		
		if (iCardDrawn == 5)
		{
			
			btnDraw.setVisible(false);			
		}
		
		
	}
	
	@FXML
	private void handlePlay()
	{
		//	Clear all players hands
		h1P1.getChildren().clear();
		
		//	Get the Rule, start the Game
		Rule rle = new Rule(eGame.FiveStud);		
		gme = new GamePlay(rle);
		
		//	Add the seated players to the game		
		for (Player p: mainApp.GetSeatedPlayers())
		{
			gme.addPlayerToGame(p);
			GamePlayPlayerHand GPPH = new GamePlayPlayerHand();
			GPPH.setGame(gme);
			GPPH.setPlayer(p);
			GPPH.setHand(new Hand());
			gme.addGamePlayPlayerHand(GPPH);			
		}
		
		//	Add a deck to the game
		gme.setGameDeck(new Deck());
		
		btnDraw.setVisible(true);
		iCardDrawn = 0;
	}
}









