import java.util.*;

public class BeatModel
{
    // Attribute
    private int bpm;
    ArrayList<Beobachter> beobachterliste;

    // Konstruktor
    public BeatModel()
    {
        bpm = 90;
        beobachterliste = new ArrayList<Beobachter>();
    }
    
    public void registrieren(Beobachter b)
    {
        beobachterliste.add(b);
    }
    
    public void setBPM(int bpm_)
    {
        bpm = bpm_;
        benachrichtigeBeobachter();
    }
    
    public void schneller()
    {
        bpm++;
        benachrichtigeBeobachter();
    }
    
    public void langsamer()
    {
        bpm--;
        benachrichtigeBeobachter();
    }
    
    public int getBPM()
    {
        return bpm;
    }
    
    public void benachrichtigeBeobachter()
    {
        for (Beobachter b : beobachterliste)
        {
            b.aktualisieren();
        }
    }
}
