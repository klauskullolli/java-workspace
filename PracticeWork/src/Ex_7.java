import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ex_7 extends Application {
	private CirclePane circlePane = new CirclePane();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Hold two buttons in an HBox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("Enlarge");
		Button btShrink = new Button("Shrink");
		hBox.getChildren().add(btEnlarge);
		hBox.getChildren().add(btShrink);
		
		// Create and register the handler
		btEnlarge.setOnAction(new EnlargeHandler());
		btShrink.setOnAction(new ShrinkHandler() );
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);
		
		circlePane.setOnMouseClicked(e -> {
				if (e.getButton() == MouseButton.PRIMARY) {
					circlePane.enlarge();
				}
				else if (e.getButton() == MouseButton.SECONDARY) {
					circlePane.shrink();
				}
				});
				
				circlePane.setOnKeyPressed(e -> {
					if (e.getCode() == KeyCode.U) {
						circlePane.enlarge();
					}
					else if (e.getCode() == KeyCode.D) {
						circlePane.shrink();
					}
				});

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 200, 150);
		primaryStage.setTitle("ControlCircle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		circlePane.requestFocus();
	}

	
	public static void main(String[] args) {
		launch(args) ;

	}
	
	class EnlargeHandler implements EventHandler<ActionEvent> {
		@Override // Override the handle method
		public void handle(ActionEvent e) {
			circlePane.enlarge();
		}
	}
	
	class ShrinkHandler implements EventHandler<ActionEvent> {
		@Override // Override the handle method
		public void handle(ActionEvent e) {
			circlePane.shrink();
		}
	}
	
	class CirclePane extends StackPane {
		private Circle circle = new Circle(50);
		
		public CirclePane() {
			getChildren().add(circle);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
		}

		public void enlarge() {
			circle.setRadius(circle.getRadius() + 2);
		}

		public void shrink() {
			circle.setRadius(circle.getRadius() > 40 ?
					circle.getRadius() - 2 : circle.getRadius());
		}
	}
	
	
}
