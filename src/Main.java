
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		File file = new File("database.txt");	
		
		Scanner read = new Scanner(file, "UTF-8");
		String[] leftData = read.nextLine().split(",");
		String[] rightData = read.nextLine().split(",");

		
		read.close();
		
		Rectangle recLeft = new Rectangle(500,500, Color.web("#DDD"));
		Font f = new Font(35.00);
		Text txtLeft = new Text();
		txtLeft.setFont(f);
		StackPane left = new StackPane(recLeft, txtLeft);
		
		Rectangle recRight = new Rectangle(500,500, Color.web("#DDD"));
		Text txtRight = new Text();
		txtRight.setFont(f);
		StackPane right = new StackPane(recRight, txtRight);
		
		Button gen = new Button("Generate");
		
		HBox hb = new HBox(left,right);
		VBox vb = new VBox(gen, hb);
		hb.setSpacing(20);
		vb.setPadding(new Insets(20,20,20,20));		
			
		gen.setOnAction(e -> {
			generate(txtLeft, leftData, txtRight, rightData);
		});
		
		
		
		Scene scene = new Scene(vb);
		
		primaryStage.setTitle("Enter your information");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
		
	public static void main(String[] args) {
		Application.launch(args);
			
	}
	


	public static void generate(Text txtLeft, String[] leftData, Text txtRight, String[] rightData) {
		Random r = new Random();
		int maxL = leftData.length - 1;
		int maxR = rightData.length - 1;
		
		int randomLeft = Math.abs(r.nextInt() % maxL);
		int randomRight = Math.abs(r.nextInt() % maxR);
		
		System.out.println(randomLeft + "/ " + maxL);
		System.out.println(randomRight + "/ " + maxR);
		
		txtLeft.setText(leftData[randomLeft]);
		txtRight.setText(rightData[randomRight]);
		
		
	}
	
	
	
	
}
	