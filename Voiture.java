package entities;

public class Voiture {
    private int id;
    private String matricule;
    private String marque;

    public Voiture() {
    }

    public Voiture(int id, String matricule, String marque) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
