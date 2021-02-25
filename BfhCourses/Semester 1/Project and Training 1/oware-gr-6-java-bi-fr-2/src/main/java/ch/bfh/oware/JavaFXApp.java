/*
 * Project and Training 1: Oware Game - Computer Science, Berner Fachhochschule
 * 
 * As you will see, we didn't use your model implementation for our javaFX application.
 * Even thought we did it.
 * The reason is we didn't knew how to implement the computer player in the required implementation.
 * But found a solution for the way we finally implemented it.
 * The number of pots is fix, we weren't able to made the javaFX pot display flexible.
 * You can change the number of seeds in each pot (at the start) in:
 * 	ch.bfh.oware.JavaFXApp; 
 */
package ch.bfh.oware;

import ch.bfh.oware.model.GameState;
import ch.bfh.oware.model.Player.State;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
	
	/*
	 * change the value, to set the number of seeds in each pots.
	 */
	private int seeds = 4;
	
	private GameState game;
	
	/**
	 * Start method called by the JavaFX framework upon calling launch().
	 *
	 * @param stage a (default) stage provided by the framework
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
				primaryStage.setTitle("Oware Game");
				
				BorderPane borderPane = new BorderPane();
					
				final StackPane stack = new StackPane();
				final StackPane stackPaneCercleGauche = new StackPane();
				final StackPane stackPaneCercleDroite = new StackPane();
				
				Button playerVSplayer = new Button("Player VS Player");
				playerVSplayer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						game = new GameState(false, seeds);

						gameInterfaceInitialisation(primaryStage);	
					}
				});
				Button playerVSCPU = new Button("Player VS EASY");
				playerVSCPU.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						
						game = new GameState(true, false, seeds);

						gameInterfaceInitialisation(primaryStage);
					}
				});
				Button playerVSCPU2 = new Button("Player VS HARD");
				playerVSCPU2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						
						game = new GameState(true, true, seeds);

						gameInterfaceInitialisation(primaryStage);
					}
				});
				
				GridPane gridPane = new GridPane();
				gridPane.setMinSize(500, 500);
				gridPane.setPadding(new Insets(5, 5, 5, 5));
				gridPane.setVgap(5);
				gridPane.setHgap(5);

				VBox vBoxCercleGauche = new VBox();

				Scene scene = new Scene(borderPane, 1000, 700);

				Text owareGameTitle = new Text();
				owareGameTitle.setText("OWARE GAME");
				owareGameTitle.setFont(Font.font("Cooper Black", 100));
				
				Text creerPar = new Text();
				creerPar.setText("Created by C.G.B");
				
				Circle c1 = new Circle(200.0f, javafx.scene.paint.Color.GRAY);
				Circle c2 = new Circle(60.0f, javafx.scene.paint.Color.WHITESMOKE);
				Circle c3 = new Circle(60.0f, javafx.scene.paint.Color.WHITESMOKE);

				BorderPane.setAlignment(creerPar, Pos.CENTER);
				vBoxCercleGauche.setAlignment(Pos.CENTER);
				VBox.setMargin(playerVSCPU, new Insets(5, 5, 5, 5));
				VBox.setMargin(playerVSCPU2, new Insets(5, 5, 5, 5));
				vBoxCercleGauche.getChildren().addAll(playerVSCPU,playerVSCPU2);
				
				gridPane.add(stackPaneCercleGauche, 0, 0);
				gridPane.add(stackPaneCercleDroite, 1, 0);

				gridPane.setAlignment(Pos.CENTER);

				stackPaneCercleDroite.getChildren().addAll(c2,playerVSplayer);
				stackPaneCercleGauche.getChildren().addAll(c3,vBoxCercleGauche);

				BorderPane.setAlignment(owareGameTitle, Pos.CENTER);
				borderPane.setTop(owareGameTitle);
				borderPane.setBottom(creerPar);


				stack.getChildren().addAll(c1,gridPane);
				borderPane.setCenter(stack);

				primaryStage.setScene(scene);
				primaryStage.show();

			}

			public void displayInBottomLeftCorner(GridPane gridPaneForBorderPaneTOP, Text texteBottom) {
	
				if (game.getPlayer(1).state == State.WINNER) {
					texteBottom.setText("WINNER : Player 1");
					texteBottom.setFill(javafx.scene.paint.Color.GREEN);

				}else if (game.getPlayer(2).state == State.WINNER) {
					if (game.getWithIA()) {
						texteBottom.setText("WINNER : Computer");
						texteBottom.setFill(javafx.scene.paint.Color.GREEN);
					}else {
					texteBottom.setText("WINNER : Player 2");
					texteBottom.setFill(javafx.scene.paint.Color.GREEN);
					}
				}
				else if (game.getPlayer(1).state == State.ACTIV) {

					texteBottom.setText("ACTIVE : Player 1");
					texteBottom.setFill(javafx.scene.paint.Color.BLUE);
				}else if (game.getPlayer(2).state == State.ACTIV) {
					if (game.getWithIA()) {
						texteBottom.setText("ACTIVE : Computer");
						texteBottom.setFill(javafx.scene.paint.Color.BLUE);
					}else {
					texteBottom.setText("ACTIVE : Player 2");
					texteBottom.setFill(javafx.scene.paint.Color.BLUE);
					}
				}


			}

			public void gameInterfaceInitialisation(Stage primaryStage) {

				BorderPane borderPane = new BorderPane();

				Scene scene2 = new Scene(borderPane, 1000, 700);

				GridPane gridPaneForBorderPaneTOP = new GridPane();

				Text player1Name = new Text("Player 1");
				player1Name.setFont(Font.font("Cooper Black", 25));
				Text scoreTextPlayer1 = new Text("Score :");
				scoreTextPlayer1.setFont(Font.font("Cooper Black", 25));
				//get score du player 1
				Text intscoreTextPlayer1 = new Text(game.getScore(1));
				intscoreTextPlayer1.setFont(Font.font("Cooper Black", 30));

				GridPane.setHalignment(intscoreTextPlayer1, HPos.CENTER);
				GridPane.setHalignment(scoreTextPlayer1, HPos.RIGHT);


				Text player2Name = new Text("Player 2");
				player2Name.setFont(Font.font("Cooper Black", 25));
				Text scoreTextPlayer2 = new Text("Score :");
				scoreTextPlayer2.setFont(Font.font("Cooper Black", 25));
				//get score du player 2
				Text intscoreTextPlayer2 = new Text(game.getScore(2));
				intscoreTextPlayer2.setFont(Font.font("Cooper Black", 30));
				GridPane.setHalignment(intscoreTextPlayer2, HPos.CENTER);
				GridPane.setHalignment(scoreTextPlayer2, HPos.RIGHT);

				Text getNbrInPots0p2 = new Text(game.getSeedsOfPot(6));
				Text getNbrInPots1p2 = new Text(game.getSeedsOfPot(7));
				Text getNbrInPots2p2 = new Text(game.getSeedsOfPot(8));
				Text getNbrInPots3p2 = new Text(game.getSeedsOfPot(9));
				Text getNbrInPots4p2 = new Text(game.getSeedsOfPot(10));
				Text getNbrInPots5p2 = new Text(game.getSeedsOfPot(11));

				Text getNbrInPots0p1 = new Text(game.getSeedsOfPot(0));
				Text getNbrInPots1p1 = new Text(game.getSeedsOfPot(1));
				Text getNbrInPots2p1 = new Text(game.getSeedsOfPot(2));
				Text getNbrInPots3p1 = new Text(game.getSeedsOfPot(3));
				Text getNbrInPots4p1 = new Text(game.getSeedsOfPot(4));
				Text getNbrInPots5p1 = new Text(game.getSeedsOfPot(5));
				
				getNbrInPots0p1.setFont(Font.font("Cooper Black", 25));
				getNbrInPots1p1.setFont(Font.font("Cooper Black", 25));
				getNbrInPots2p1.setFont(Font.font("Cooper Black", 25));
				getNbrInPots3p1.setFont(Font.font("Cooper Black", 25));
				getNbrInPots4p1.setFont(Font.font("Cooper Black", 25));
				getNbrInPots5p1.setFont(Font.font("Cooper Black", 25));
				
				getNbrInPots0p2.setFont(Font.font("Cooper Black", 25));
				getNbrInPots1p2.setFont(Font.font("Cooper Black", 25));
				getNbrInPots2p2.setFont(Font.font("Cooper Black", 25));
				getNbrInPots3p2.setFont(Font.font("Cooper Black", 25));
				getNbrInPots4p2.setFont(Font.font("Cooper Black", 25));
				getNbrInPots5p2.setFont(Font.font("Cooper Black", 25));
				
				getNbrInPots0p2.setFill(javafx.scene.paint.Color.DARKGRAY);
				getNbrInPots1p2.setFill(javafx.scene.paint.Color.DARKGRAY);
				getNbrInPots2p2.setFill(javafx.scene.paint.Color.DARKGRAY);
				getNbrInPots3p2.setFill(javafx.scene.paint.Color.DARKGRAY);
				getNbrInPots4p2.setFill(javafx.scene.paint.Color.DARKGRAY);
				getNbrInPots5p2.setFill(javafx.scene.paint.Color.DARKGRAY);
				
				//-------------TOP---------------------------------------
				Button button = new Button("RESTART");

				button.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {				
						game.reset();
						actualiseALLText(intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				BorderPane.setAlignment(button, Pos.TOP_CENTER);
				borderPane.setLeft(button);
				GridPane.setHgrow(button, Priority.ALWAYS);
				

				Text texteBottom = new Text("ACTIVE : Player 1");
				texteBottom.setFont(Font.font("Cooper Black", 25));
				texteBottom.setFill(javafx.scene.paint.Color.BLUE);

				borderPane.setBottom(texteBottom);
				Text owareGameTitle = new Text("OWARE GAME");
				owareGameTitle.setFont(Font.font("Cooper Black", 80));
				owareGameTitle.setTextAlignment(TextAlignment.CENTER);
				BorderPane.setAlignment(owareGameTitle, Pos.CENTER);

				borderPane.setTop(owareGameTitle);

				TilePane tilePanePotsBoard = new TilePane();
				GridPane gridPanePlayer1 = new GridPane();
				GridPane gridPanePlayer2 = new GridPane();


				StackPane stackCenter = new StackPane();
				tilePanePotsBoard.setOrientation(Orientation.VERTICAL);
				stackCenter.setAlignment(Pos.CENTER);
				tilePanePotsBoard.setTileAlignment(Pos.CENTER);

				//------------Player 1---------------------------------


				GridPane.setHalignment(getNbrInPots0p2, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots1p2, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots2p2, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots3p2, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots4p2, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots5p2, HPos.CENTER);

				GridPane.setHalignment(getNbrInPots0p1, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots1p1, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots2p1, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots3p1, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots4p1, HPos.CENTER);
				GridPane.setHalignment(getNbrInPots5p1, HPos.CENTER);

				
				Button buttonPot1p1 = new Button("1");
				buttonPot1p1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(0, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);

					}
				});
				Button buttonPot2p1 = new Button("2");
				buttonPot2p1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(1, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot3p1 = new Button("3");
				buttonPot3p1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(2, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot4p1 = new Button("4");
				buttonPot4p1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(3, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);

					}
				});
				Button buttonPot5p1 = new Button("5");
				buttonPot5p1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(4, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot6p1 = new Button("6");
				buttonPot6p1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(5, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});



				gridPanePlayer1.add(buttonPot1p1, 5,3);
				gridPanePlayer1.add(buttonPot2p1, 4,3);
				gridPanePlayer1.add(buttonPot3p1, 3,3);
				gridPanePlayer1.add(buttonPot4p1, 2,3);
				gridPanePlayer1.add(buttonPot5p1, 1,3);
				gridPanePlayer1.add(buttonPot6p1, 0,3);

				GridPane.setHalignment(buttonPot1p1, HPos.CENTER);
				GridPane.setHalignment(buttonPot2p1, HPos.CENTER);
				GridPane.setHalignment(buttonPot3p1, HPos.CENTER);
				GridPane.setHalignment(buttonPot4p1, HPos.CENTER);
				GridPane.setHalignment(buttonPot5p1, HPos.CENTER);
				GridPane.setHalignment(buttonPot6p1, HPos.CENTER);

				Circle circle1Player1 = new Circle(65.0f, javafx.scene.paint.Color.DARKGRAY);
				Circle circle2Player1 = new Circle(65.0f, javafx.scene.paint.Color.DARKGRAY);
				Circle circle3Player1 = new Circle(65.0f, javafx.scene.paint.Color.DARKGRAY);
				Circle circle4Player1 = new Circle(65.0f, javafx.scene.paint.Color.DARKGRAY);
				Circle circle5Player1 = new Circle(65.0f, javafx.scene.paint.Color.DARKGRAY);
				Circle circle6Player1 = new Circle(65.0f, javafx.scene.paint.Color.DARKGRAY);

				gridPanePlayer1.add(player1Name, 0, 0);
				gridPanePlayer1.add(scoreTextPlayer1, 1, 0);
				gridPanePlayer1.add(intscoreTextPlayer1, 2, 0);

				gridPanePlayer1.add(circle1Player1, 5,1);
				gridPanePlayer1.add(circle2Player1, 4, 1);
				gridPanePlayer1.add(circle3Player1, 3, 1);
				gridPanePlayer1.add(circle4Player1, 2, 1);
				gridPanePlayer1.add(circle5Player1, 1, 1);
				gridPanePlayer1.add(circle6Player1, 0, 1);

				gridPanePlayer1.add(getNbrInPots0p1, 5,1);
				gridPanePlayer1.add(getNbrInPots1p1, 4, 1);
				gridPanePlayer1.add(getNbrInPots2p1, 3, 1);
				gridPanePlayer1.add(getNbrInPots3p1, 2, 1);
				gridPanePlayer1.add(getNbrInPots4p1, 1, 1);
				gridPanePlayer1.add(getNbrInPots5p1, 0, 1);

				//----------------END Player 1 ------------------------------------


				//----------------Player 2 ------------------------------------


				Button buttonPot1p2 = new Button("7");
				buttonPot1p2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(6, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot2p2 = new Button("8");
				buttonPot2p2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(7, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot3p2 = new Button("9");
				buttonPot3p2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(8, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot4p2 = new Button("10");
				buttonPot4p2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(9, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});
				Button buttonPot5p2 = new Button("11");
				buttonPot5p2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(10, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);

					}
				});
				Button buttonPot6p2 = new Button("12");
				buttonPot6p2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonAction(11, gridPaneForBorderPaneTOP,texteBottom, intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
								getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
								getNbrInPots0p2, getNbrInPots1p2,
								getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
					}
				});


				if (game.getWithIA()) {
					 player2Name = new Text("Computer");
					 player2Name.setFont(Font.font("Cooper Black", 25));
				}
				else {
				gridPanePlayer2.add(buttonPot1p2, 0,3);
				gridPanePlayer2.add(buttonPot2p2, 1,3);
				gridPanePlayer2.add(buttonPot3p2, 2,3);
				gridPanePlayer2.add(buttonPot4p2, 3,3);
				gridPanePlayer2.add(buttonPot5p2, 4,3);
				gridPanePlayer2.add(buttonPot6p2, 5,3);
				
				GridPane.setHalignment(buttonPot1p2, HPos.CENTER);
				GridPane.setHalignment(buttonPot2p2, HPos.CENTER);
				GridPane.setHalignment(buttonPot3p2, HPos.CENTER);
				GridPane.setHalignment(buttonPot4p2, HPos.CENTER);
				GridPane.setHalignment(buttonPot5p2, HPos.CENTER);
				GridPane.setHalignment(buttonPot6p2, HPos.CENTER);

				}

				GridPane.setHalignment(gridPanePlayer2, HPos.CENTER);

				Circle circle1Player2 = new Circle(65.0f, javafx.scene.paint.Color.BLACK);
				Circle circle2Player2 = new Circle(65.0f, javafx.scene.paint.Color.BLACK);
				Circle circle3Player2 = new Circle(65.0f, javafx.scene.paint.Color.BLACK);
				Circle circle4Player2 = new Circle(65.0f, javafx.scene.paint.Color.BLACK);
				Circle circle5Player2 = new Circle(65.0f, javafx.scene.paint.Color.BLACK);
				Circle circle6Player2 = new Circle(65.0f, javafx.scene.paint.Color.BLACK);

				gridPanePlayer2.add(player2Name, 0, 0);
				gridPanePlayer2.add(scoreTextPlayer2, 1, 0);
				gridPanePlayer2.add(intscoreTextPlayer2, 2, 0);

				gridPanePlayer2.add(circle1Player2, 5,1);
				gridPanePlayer2.add(circle2Player2, 4, 1);
				gridPanePlayer2.add(circle3Player2, 3, 1);
				gridPanePlayer2.add(circle4Player2, 2, 1);
				gridPanePlayer2.add(circle5Player2, 1, 1);
				gridPanePlayer2.add(circle6Player2, 0, 1);

				gridPanePlayer2.add(getNbrInPots0p2, 0,1);
				gridPanePlayer2.add(getNbrInPots1p2, 1, 1);
				gridPanePlayer2.add(getNbrInPots2p2, 2, 1);
				gridPanePlayer2.add(getNbrInPots3p2, 3, 1);
				gridPanePlayer2.add(getNbrInPots4p2, 4, 1);
				gridPanePlayer2.add(getNbrInPots5p2, 5, 1);


				//----------------END Player 2 ------------------------------------


				gridPanePlayer1.setAlignment(Pos.CENTER);
				gridPanePlayer2.setAlignment(Pos.CENTER);
				tilePanePotsBoard.getChildren().add(gridPanePlayer1);
				tilePanePotsBoard.getChildren().add(gridPanePlayer2);
				tilePanePotsBoard.setAlignment(Pos.CENTER);
				borderPane.setCenter(tilePanePotsBoard);
				primaryStage.setScene(scene2);
			}

			public void buttonAction(int potID, GridPane gridPaneForBorderPaneTOP, Text texteBottom,
					Text intscoreTextPlayer1, Text intscoreTextPlayer2, Text getNbrInPots0p1,
					Text getNbrInPots1p1, Text getNbrInPots2p1, Text getNbrInPots3p1, Text getNbrInPots4p1,
					Text getNbrInPots5p1, Text getNbrInPots0p2, Text getNbrInPots1p2,
					Text getNbrInPots2p2, Text getNbrInPots3p2, Text getNbrInPots4p2, Text getNbrInPots5p2) {

				game.play(potID);
				displayInBottomLeftCorner(gridPaneForBorderPaneTOP,texteBottom);
				actualiseALLText(intscoreTextPlayer1, intscoreTextPlayer2, getNbrInPots0p1, getNbrInPots1p1, 
						getNbrInPots2p1, getNbrInPots3p1, getNbrInPots4p1, getNbrInPots5p1,
						getNbrInPots0p2, getNbrInPots1p2,
						getNbrInPots2p2, getNbrInPots3p2, getNbrInPots4p2, getNbrInPots5p2);
				

			}

			public void actualiseALLText(Text scoreJ1, Text scoreJ2, Text pot0,
					Text pot1, Text pot2, Text pot3, Text pot4, Text pot5, Text pot6, Text pot7,
					Text pot8, Text pot9, Text pot10, Text pot11) {
				pot0.setText(game.getSeedsOfPot(0));
				pot1.setText(game.getSeedsOfPot(1));
				pot2.setText(game.getSeedsOfPot(2));
				pot3.setText(game.getSeedsOfPot(3));
				pot4.setText(game.getSeedsOfPot(4));
				pot5.setText(game.getSeedsOfPot(5));
				pot6.setText(game.getSeedsOfPot(6));
				pot7.setText(game.getSeedsOfPot(7));
				pot8.setText(game.getSeedsOfPot(8));
				pot9.setText(game.getSeedsOfPot(9));
				pot10.setText(game.getSeedsOfPot(10));
				pot11.setText(game.getSeedsOfPot(11));

				scoreJ1.setText(game.getScore(1));
				scoreJ2.setText(game.getScore(2));

			}

			public static void main(String[] args) {
				Application.launch(args);

			}

		}