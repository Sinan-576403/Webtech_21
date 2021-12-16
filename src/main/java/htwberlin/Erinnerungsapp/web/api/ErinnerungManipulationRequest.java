package htwberlin.Erinnerungsapp.web.api;

public class ErinnerungManipulationRequest {

    private String ersteAufgabe;
    private String nachsteAufgabe;
    private boolean erledigt;

    public ErinnerungManipulationRequest(String ersteAufgabe, String nachsteAufgabe, boolean erledigt) {
        this.ersteAufgabe = ersteAufgabe;
        this.nachsteAufgabe = nachsteAufgabe;
        this.erledigt = erledigt;
    }

    public String getErsteAufgabe() {
        return ersteAufgabe;
    }

    public void setErsteAufgabe(String ersteAufgabe) {
        this.ersteAufgabe = ersteAufgabe;
    }

    public String getNachsteAufgabe() {
        return nachsteAufgabe;
    }

    public void setNachsteAufgabe(String nachsteAufgabe) {
        this.nachsteAufgabe = nachsteAufgabe;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }
}
