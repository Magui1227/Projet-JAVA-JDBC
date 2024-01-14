package Metier;
import java.util.List;
import entities.Voiture;

public interface Ivoiture {
    public int add(Voiture v);
    public List<Voiture>liste();
    public int update(Voiture v);
    //methode pour la recuperation
    public Voiture get(int id);
    //methode pour la suppression
    public int delete(int id);
}
