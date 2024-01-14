package Metier;

import entities.Voiture;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IvoitureImplemente implements Ivoiture{
    private DB db=new DB();
    private int OK;
    private ResultSet rs;

    @Override
    public int add(Voiture v) {
        String sql = "INSERT INTO voiture (marque, matricule) VALUES (?, ?)";
        try {
            db.initPrepa(sql);
            db.getPstm().setString(2, v.getMarque());
            db.getPstm().setString(1, v.getMatricule());

            OK = db.executeMS();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OK;
    }

    @Override
    public List<Voiture> liste() {
        String sql="Select * from voiture";
        List<Voiture>voitures=new ArrayList<Voiture>();
        try {
            db.initPrepa(sql);
            rs=db.executesSelect();
            while (rs.next()){
                Voiture v=new Voiture();
                v.setId(rs.getInt(1));
                v.setMarque(rs.getString(2));
                v.setMatricule(rs.getString(3));
                voitures.add(v);
            }
        }catch (Exception e){}
        return voitures;
    }

    @Override
    public int update(Voiture v) {
        String sql = "UPDATE voiture SET marque=?, matricule=? WHERE id=?";
        try {
            db.initPrepa(sql);
            db.getPstm().setString(1, v.getMarque());
            db.getPstm().setString(2, v.getMatricule());
            db.getPstm().setInt(3, v.getId());
            OK = db.executeMS();

            if (OK != 0) {
                System.out.println("Mise à jour réussie pour la voiture avec l'ID " + v.getId());
            } else {
                System.out.println("Aucune mise à jour effectuée pour la voiture avec l'ID " + v.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Ajoutez un message pour afficher l'erreur
            System.out.println("Erreur lors de la mise à jour de la voiture : " + e.getMessage());
        }
        return OK;
    }



    @Override
    public Voiture get(int id) {
        String sql = "Select * from voiture where id=?";
        Voiture voiture = null;

        try {
            db.initPrepa(sql);
            db.getPstm().setInt(1, id);
            rs = db.executesSelect();

            if (rs.next()) {
                voiture = new Voiture();
                voiture.setId(rs.getInt(1));
                voiture.setMarque(rs.getString(2));
                voiture.setMatricule(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return voiture;
    }


    @Override
    public int delete(int id) {
        String sql="Delete from  voiture  where id=?";
        try {

            db.initPrepa(sql);
            db.getPstm().setInt(1,id);
            OK=db.executeMS();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return OK;
    }
}
