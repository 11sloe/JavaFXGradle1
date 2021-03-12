import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller extends Beobachter{

    // Attribute
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNeuerBeat;

    @FXML
    private Label lblBeat;
    
    private BeatModel model;
    
    // Konstruktor
    public Controller()
    {
        
    }
    
    // Methoden
    void setModel(BeatModel m)
    {
        model = m;
        model.registrieren(this);
        aktualisieren();
    }
    
    @FXML
    void langsamer(ActionEvent event) {
        model.langsamer();

    }

    @FXML
    void neuenBeatSetzen(ActionEvent event) {
        int beat = Integer.parseInt(txtNeuerBeat.getText());
        model.setBPM(beat);

    }

    @FXML
    void schneller(ActionEvent event) {
        model.schneller();
    }
    
    public void aktualisieren()
    {
        // Setze die Anzeige auf den Wert des Modells
        lblBeat.setText(""+model.getBPM());
    }

    @FXML
    void initialize() {
        assert txtNeuerBeat != null : "fx:id=\"txtNeuerBeat\" was not injected: check your FXML file 'view.fxml'.";
        assert lblBeat != null : "fx:id=\"lblBeat\" was not injected: check your FXML file 'view.fxml'.";

    }
}
