import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

public class Controller2 extends Beobachter {

    // Attribute
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblBeat;
    
    @FXML
    private Circle kreis;
    
    // Das Modell
    private BeatModel model;
    ScaleTransition st;

     
     // Methoden
    void setModel(BeatModel m)
    {
        model = m;
        model.registrieren(this);
        transisionErstellen();
        aktualisieren();
        st.play();
    } 
    
    @FXML
    void initialize() {
        assert lblBeat != null : "fx:id=\"lblBeat\" was not injected: check your FXML file 'view.fxml'.";
        
    }
    
    public void aktualisieren()
    {
        int bpm = model.getBPM();
        lblBeat.setText(bpm+"");
        int millis = 60*1000/bpm;
        st.stop();
        st.setDuration(Duration.millis(millis));
        st.play();
    }
    
    public void transisionErstellen()
    {
        st = new ScaleTransition();
        st.setNode(kreis);
        st.setFromX(1);
        st.setToX(1.2);
        st.setFromY(1);
        st.setToY(1.2);
        st.setAutoReverse(true);
        st.setCycleCount(ScaleTransition.INDEFINITE);
    }
    
    
}
