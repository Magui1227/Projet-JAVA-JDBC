import Metier.Ivoiture;
import Metier.IvoitureImplemente;
import entities.Voiture;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db ", "root", "");
          if (conn != null){
              System.out.println("Vous etes connecter !");
          }
          int choix=0;
          int id;

          Scanner cla=new Scanner(System.in);
          Ivoiture iv=new IvoitureImplemente();
          do {
              System.out.println("1.Ajouter");
              System.out.println("2.Lister");
              System.out.println("3.Modifier");
              System.out.println("4.Recherche");
              System.out.println("5.Delete");

              System.out.println("6.Quitter");



              System.out.println("Entrez votre choix:");

              choix = Integer.parseInt(cla.nextLine());

              switch (choix) {

                  case 1:

                      Voiture v=new Voiture();

                    System.out.println("INSERTION:");
                      System.out.println("Entrer le matricule");
                      v.setMatricule(cla.nextLine());
                      System.out.println("Entrer la marque");
                      v.setMarque(cla.nextLine());
                      int OK=iv.add(v);
                      if (OK!=0){
                          System.out.println("ajouter avec succes!");
                      }




 /*
                      String sql = "INSERT INTO personne(prenom, nom, age, adresse) VALUES (?, ?, ?, ?)";
                      PreparedStatement preparedStatement = conn.prepareStatement(sql);

                      System.out.println("Entrer votre prenom");
                      String prenom = cla.nextLine();
                      preparedStatement.setString(1, prenom);

                      System.out.println("Entrer votre nom");
                      String nom = cla.nextLine();
                      preparedStatement.setString(2, nom);

                      System.out.println("Entrer votre age");
                      int age = cla.nextInt();
                      preparedStatement.setInt(3, age);

                     cla.nextLine();

                      System.out.println("Entrer votre adresse");
                      String adresse = cla.nextLine();
                      preparedStatement.setString(4, adresse);

                      preparedStatement.executeUpdate();
                      System.out.println("Personne ajoutée avec succès!");*/
                      break;
                  case 2:
                      System.out.println("Liste des voitures :");

                      List<Voiture> voitures = iv.liste();

                      if (voitures.isEmpty()) {
                          System.out.println("Aucune voiture disponible.");
                      } else {
                          for (Voiture voiture : voitures) {
                              System.out.println("ID : " + voiture.getId() + ", Marque : " + voiture.getMarque() + ", Matricule : " + voiture.getMatricule());
                          }
                      }
                      break;


                      /*
                      System.out.println("La Liste des personne ");
                      Statement statement = conn.createStatement();
                      ResultSet resultSet=statement.executeQuery("Select * from personne");
                      while (resultSet.next()){
                          int idper = resultSet.getInt("id");
                          String prenomper = resultSet.getString("prenom");
                          String nomper = resultSet.getString("nom");
                          int ageper = resultSet.getInt("age");
                          String adresseper = resultSet.getString("adresse");


                          System.out.println("id = "+idper+" prenom = "+prenomper+" nom = "+nomper+" age = "+ageper+" adresse = "+adresseper);


                      }*/

                  case 3:
                      System.out.println("MODIFICATION - Modifier une voiture à partir de ID");
                      System.out.println("Saisir l'ID de la voiture à modifier :");
                      int idToUpdate = cla.nextInt();
                      cla.nextLine();

                      Voiture existingVoiture = iv.get(idToUpdate);

                      if (existingVoiture != null) {
                          System.out.println("Voiture actuelle :");
                          System.out.println("ID : " + existingVoiture.getId() + ", Marque : " + existingVoiture.getMarque() + ", Matricule : " + existingVoiture.getMatricule());

                          Voiture updatedVoiture = new Voiture();
                          updatedVoiture.setId(idToUpdate);

                          System.out.println("Entrer la nouvelle marque  :");
                          updatedVoiture.setMarque(cla.nextLine());

                          System.out.println("Entrer le nouveau matricule  :");
                          updatedVoiture.setMatricule(cla.nextLine());

                          if (!updatedVoiture.getMarque().isEmpty() || !updatedVoiture.getMatricule().isEmpty()) {
                              // Mettre a jour les champs qu'on a saisie
                              OK = iv.update(updatedVoiture);

                              if (OK != 0) {
                                  System.out.println("Voiture modifiée avec succès !");
                              } else {
                                  System.out.println("Erreur lors de la modification de la voiture.");
                              }
                          } else {
                              System.out.println(" Champs vides.");
                          }
                      } else {
                          System.out.println("Aucune voiture trouvée avec l'ID " + idToUpdate + ".");
                      }
                      break;
                  case 4:
                      System.out.println("RECHERCHE - Rechercher une voiture a partir de l'ID");
                      System.out.println("Veuillez entrer l'ID de la voiture à rechercher :");
                      int idToSearch = cla.nextInt();
                      cla.nextLine();

                      Voiture voiture = iv.get(idToSearch);

                      if (voiture != null) {
                          System.out.println("Voiture trouvée :");
                          System.out.println("ID : " + voiture.getId() + ", Marque : " + voiture.getMarque() + ", Matricule : " + voiture.getMatricule());
                      } else {
                          System.out.println("Aucune voiture trouvée avec l'ID " + idToSearch + ".");
                      }
                      break;




                  case 5:
                      System.out.println("DELETE - Supprimer une voiture");
                      System.out.println("Veuillez entrer l'ID de la voiture à supprimer :");
                      int idToDelete = cla.nextInt();
                      cla.nextLine();
                      int deleteResult = iv.delete(idToDelete);

                      if (deleteResult != 0) {
                          System.out.println("Voiture supprimée avec succès !");
                      } else {
                          System.out.println("Erreur lors de la suppression de la voiture.");
                      }


 /*
                      System.out.println("DELETE - Supprimer une personne");
                      System.out.println("Veuillez entrer l'ID de la personne à supprimer :");
                      int idToDelete = cla.nextInt();
                      cla.nextLine();
                      deletePersonne(conn, idToDelete);*/
                      break;
                  case 6:
                      System.out.println("Bye Bye :-)");
                  break;

                  default:
                      System.out.println("Erreur! Choix invalide.");
                      break;
              }
          } while (choix != 6);







      }
      catch(Exception e)
        {

        }
        }



}
