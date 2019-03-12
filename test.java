import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent; 

public class test extends Application {
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
						System.out.println("You clicked on a White Knight. Click where you want to move it.");
					}
				});

				wK.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						wK.setX((int)(event.getSceneX()/100)*100);
						wK.setY((int)(event.getSceneY()/100)*100);
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
						System.out.println("You clicked on a Black Knight. Click where you want to move it.");
					}
				});

				bK.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						bK.setX((int)(event.getSceneX()/100)*100);
						bK.setY((int)(event.getSceneY()/100)*100);
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
						System.out.println("You clicked on a White Pawn. Click where you want to move it.");
					}
				});

				wP.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						wP.setX((int)(event.getSceneX()/100)*100);
						wP.setY((int)(event.getSceneY()/100)*100);
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
						System.out.println("You clicked on a Black Pawn. Click where you want to move it.");
					}
				});

				bP.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						bP.setX((int)(event.getSceneX()/100)*100);
						bP.setY((int)(event.getSceneY()/100)*100);
					}
				});
				
        			primaryStage.setScene(scene);
				primaryStage.show();
			}
		}
	}
}