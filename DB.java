package Metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
private Connection conn;
private ResultSet rs;
private int OK;
private PreparedStatement pstm;//permet de preparer la connection
    //getConnection pour ouvrir la connection
    private void getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db ", "root", "");
            if (conn!=null){
                System.out.println("vous etes connecter");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //la fonction initprepa pour preparer la requete
    public void initPrepa(String sql){
        try {
            getConnection();
            pstm = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //executesSelect() pour les requete de type select
    public ResultSet executesSelect(){
        try {
            rs=pstm.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    //executeMisajour permet de faire la mise a jour
    public int executeMS() {
        try {
            OK = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return OK;
    }

        public PreparedStatement getPstm () {
            return pstm;
        }

        public void setPstm (PreparedStatement pstm){
            this.pstm = pstm;
        }

    }
