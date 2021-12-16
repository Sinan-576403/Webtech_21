package htwberlin.Erinnerungsapp.web.persistence;

import javax.persistence.*;

@Entity(name = "Erinnerungen")
public class ErinnerungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Wichtigkeit")
    private long id;

    @Column(name = "Aufgabe_1", nullable = false)
    private String ersteAufgabe;

    @Column(name = "Aufgabe_2", nullable = false)
    private String nachsteAufgabe;

    @Column(name = "ist_erledigt")
    private boolean erledigt;

    public ErinnerungEntity(String ersteAufgabe, String nachsteAufgabe, boolean erledigt) {
        this.ersteAufgabe = ersteAufgabe;
        this.nachsteAufgabe = nachsteAufgabe;
        this.erledigt = erledigt;
    }

    protected ErinnerungEntity() {}

    public long getId() {
        return id;
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
