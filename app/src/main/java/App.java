import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class App extends Application {
    
    // Das zugrundeliegende Modell! 
    BeatModel model = new BeatModel();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Darstellung als fxml-Datei
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();
        
        // Der Controller braucht Zugriff auf das Modell!
        Controller c = loader.getController();
        c.setModel(model);

        // Fenster erstellen und anzeigen
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Zweites Fenster       
        // Darstellung als fxml-Datei
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("view2.fxml"));
        Parent root2 = loader2.load();
        
        // Der Controller braucht Zugriff auf das Modell!
        Controller2 c2 = loader2.getController();
        c2.setModel(model);
        
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(root2));
        secondStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}