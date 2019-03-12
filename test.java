import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// STILL EXTREMELY BUGGY 
// ASSUME EACH TURN CONSISTS OF WHITE MOVING FIRST THEN BLACK MOVING SECOND
// AS OF RIGHT NOW, MOVEMENT OF PIECES HAVE NO RESTRICTIONS, WHICH WILL BE FIXED LATER

public class test extends Application {
	private GameConfig config = new GameConfig();

	public static void main(String[] args) {
		Application.launch(args);
	}
    
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Apocalypse Chess");
        	Group root = new Group();
        	Scene scene = new Scene(root, 500, 500, Color.WHITE);

		// creating the board by using 100x100 squares in a for loop
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
        			Rectangle r = new Rectangle();
        			r.setX(j*100);
        			r.setY(i*100);
        			r.setWidth(100);
        			r.setHeight(100);
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					r.setFill(Color.GRAY);
				}
					else {
					r.setFill(Color.WHITE);
				}
        			root.getChildren().add(r);
			}
		}

		// for loop used to set the initial board AND direct movement of the pieces 
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {

				Image whiteKnight = new Image("whiteknight.png", 100, 100, false, false);
				ImageView wK = new ImageView(whiteKnight);

				// placing all the White Knights on the initial board
				if ((j == 0 || j == 4) && i == 0) {
        				root.getChildren().add(wK);
					wK.setX(j*100);
					wK.setY(i*100);
				}

				wK.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						System.out.println("You clicked on a White Knight. Click and drag where you want to move it.");
						config.changeBoard("BLANK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
					}
				});

				wK.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						wK.setX((int)(event.getSceneX()/100)*100);
						wK.setY((int)(event.getSceneY()/100)*100);
						config.changeBoard("wK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
					}
				});


				Image blackKnight = new Image("blackknight.png", 100, 100, false, false);
				ImageView bK = new ImageView(blackKnight);

				// placing all the Black Knights on the initial board
				if ((j == 0 || j == 4) && i == 4) {
					root.getChildren().add(bK);
					bK.setX(j*100);
					bK.setY(i*100);
				}

				bK.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						System.out.println("You clicked on a Black Knight. Click and drag where you want to move it.");
						config.changeBoard("BLANK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
					}
				});

				bK.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (config.getBoard()[(int)(event.getSceneY()/100)][(int)(event.getSceneX()/100)] == "wK") {
							bK.setImage(null);
        						Rectangle r = new Rectangle();
        						r.setX((int)(event.getSceneX()/100)*100);
        						r.setY((int)(event.getSceneY()/100)*100);
        						r.setWidth(100);
        						r.setHeight(100);

							if (((int)(event.getSceneX()/100) % 2 == 0 && (int)(event.getSceneY()/100) % 2 == 0) || ((int)(event.getSceneX()/100) % 2 != 0 && (int)(event.getSceneY()/100) % 2 != 0)) {
								r.setFill(Color.GRAY);
							}
							else {
								r.setFill(Color.WHITE);
							}

        						root.getChildren().add(r);
							config.changeBoard("BLANK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
						}
						else {
							bK.setX((int)(event.getSceneX()/100)*100);
							bK.setY((int)(event.getSceneY()/100)*100);
							config.changeBoard("bK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
						}
					}
				});

				Image whitePawn = new Image("whitepawn.png", 100, 100, false, false);
				ImageView wP = new ImageView(whitePawn);

				// placing all the White Pawns on the initial board
				if (((j == 1 || j == 2 || j == 3) && (i == 0)) || ((j == 0 || j == 4) && (i == 1))) {
					root.getChildren().add(wP);
					wP.setX(j*100);
					wP.setY(i*100);
				}

				wP.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						System.out.println("You clicked on a White Pawn. Click and drag where you want to move it.");
						config.changeBoard("BLANK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
					}
				});

				wP.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						wP.setX((int)(event.getSceneX()/100)*100);
						wP.setY((int)(event.getSceneY()/100)*100);
						config.changeBoard("wP", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
					}
				});

				Image blackPawn = new Image("blackpawn.png", 100, 100, false, false);
				ImageView bP = new ImageView(blackPawn);

				// placing all the Black Pawns on the initial board
				if (((j == 1 || j == 2 || j == 3) && (i == 4)) || ((j == 0 || j == 4) && (i == 3))) {
					root.getChildren().add(bP);
					bP.setX(j*100);
					bP.setY(i*100);
				}

				bP.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						System.out.println("You clicked on a Black Pawn. Click and drag where you want to move it.");
						config.changeBoard("BLANK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
					}
				});

				bP.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (config.getBoard()[(int)(event.getSceneY()/100)][(int)(event.getSceneX()/100)] == "wP") {
							bP.setImage(null);
        						Rectangle r = new Rectangle();
        						r.setX((int)(event.getSceneX()/100)*100);
        						r.setY((int)(event.getSceneY()/100)*100);
        						r.setWidth(100);
        						r.setHeight(100);

							if (((int)(event.getSceneX()/100) % 2 == 0 && (int)(event.getSceneY()/100) % 2 == 0) || ((int)(event.getSceneX()/100) % 2 != 0 && (int)(event.getSceneY()/100) % 2 != 0)) {
								r.setFill(Color.GRAY);
							}
							else {
								r.setFill(Color.WHITE);
							}

        						root.getChildren().add(r);
							config.changeBoard("BLANK", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
						}
						else if (config.getBoard()[(int)(event.getSceneY()/100)][(int)(event.getSceneX()/100)] == "wK") {
							bP.setImage(null);
						}
						else {
							bP.setX((int)(event.getSceneX()/100)*100);
							bP.setY((int)(event.getSceneY()/100)*100);
							config.changeBoard("bP", (int)(event.getSceneY()/100), (int)(event.getSceneX()/100));
						}
						
					}
				});
        			primaryStage.setScene(scene);
				primaryStage.show();
			}
		}
	}
}