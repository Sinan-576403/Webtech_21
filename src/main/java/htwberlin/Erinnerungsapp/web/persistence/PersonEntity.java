package htwberlin.Erinnerungsapp.web.persistence;

import javax.persistence.*;

@Entity(name = "Erinnerungen")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Wichtigkeit")
    private long id;

    @Column(name = "Aufgabe_1", nullable = false)
    private String firstName;

    @Column(name = "Aufgabe_2", nullable = false)
    private String lastName;

    @Column(name = "ist_erledigt")
    private boolean vaccinated;

    public PersonEntity(String firstName, String lastName, boolean vaccinated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccinated = vaccinated;
    }

    protected PersonEntity() {}

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
