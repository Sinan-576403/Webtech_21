package htwberlin.Erinnerungsapp.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ErinnerungManipulationRequest {

        @Size(min = 2, message = "Geben sie mind. 2 Buchstaben an.")
        private String ersteAufgabe;

        @NotBlank(message = "Die nächste Aufgabe darf nicht leer sein .")
        private String nachsteAufgabe;

        @Pattern(
            regexp = "planen|sport|kochen|termin|freizeit|ha",
            message = "Geben Sie planen,sport, kochen, termin, freizeit oder ha an")
        private String job;
        private boolean erledigt;


    public ErinnerungManipulationRequest() {}

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
}
