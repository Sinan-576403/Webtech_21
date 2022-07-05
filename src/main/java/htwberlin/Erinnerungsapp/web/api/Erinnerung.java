package htwberlin.Erinnerungsapp.web.api;

public class Erinnerung {

    private long id;
    private String ersteAufgabe;
    private String nachsteAufgabe;
    private boolean erledigt;
    private String job;
    private String art;

    public Erinnerung(long id, String ersteAufgabe, String nachsteAufgabe, boolean erledigt, String job, String art ) {
        this.id = id;
        this.ersteAufgabe = ersteAufgabe;
        this.nachsteAufgabe = nachsteAufgabe;
        this.erledigt = erledigt;
        this.job = job;
        this.art = art;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getArt() {
        return art;
    }

    public void getArt(String art) {
        this.art = art;
    }

}
