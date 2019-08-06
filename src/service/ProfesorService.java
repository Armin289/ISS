/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.model;
import iss.model.Administrator;
import static iss.model.Baza.DB;
import iss.model.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Armin
 */
public class ProfesorService implements  model<Profesor>{

    public static final ProfesorService profesorService = new ProfesorService();
    
    @Override
    public Profesor spasi(Profesor profesor) {
        try {
            PreparedStatement upit = DB.prepare ("INSERT INTO profesor VALUES(null, ?, ?, ?, ?, MD5(?), ?)");
            upit.setString(1, profesor.getIme());
            upit.setString(2, profesor.getPrezime());
            upit.setString(3, profesor.getTitula());
            upit.setString(4, profesor.getKorisnicko_ime());
            upit.setString(5, profesor.getLozinka());
            upit.setBoolean(6, profesor.isPrijavljen());
            upit.executeUpdate();
            /* Dohvati id korisnika iz baze podataka */
            ResultSet rs = upit.getGeneratedKeys();
            if (rs.next()){
                /* Postavi id korisnika iz baze podataka objektu korisnik */
                profesor.setId(rs.getInt(1));
            }
            return profesor;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } 
    }

    @Override
    public Profesor uredi(Profesor profesor) {
       try {
            PreparedStatement upit = DB.prepare ("UPDATE profesor SET ime=?, prezime=?, titula = ?, korisnicko_ime=?, lozinka=?, prijavljen =? WHERE id=?");
            upit.setString(1, profesor.getIme());
            upit.setString(2, profesor.getPrezime());
            upit.setString(3, profesor.getTitula());
            upit.setString(4, profesor.getKorisnicko_ime());
            upit.setString(5, profesor.getLozinka());
            upit.setBoolean(6, profesor.isPrijavljen());
            upit.setInt(7, profesor.getId());
            upit.executeUpdate();
            return profesor;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean brisi(Profesor profesor) {
        try {
            PreparedStatement upit = DB.prepare ("DELETE FROM profesor WHERE id=?");
            upit.setInt(1, profesor.getId());
            upit.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return false;
        }    
    }

    @Override
    public List<Profesor> sveIzBaze() {
      try {
            ObservableList <Profesor> profesori = FXCollections.observableArrayList();
        ResultSet rs = DB.select("SELECT * FROM profesor");
            while (rs.next()){
                profesori.add(new Profesor(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7)
                            
                ));
            }
            return profesori;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Profesor izBazePremaId(int id) {
        try {
            PreparedStatement upit = DB.prepare ("SELECT * FROM profesor WHERE id=?");
            upit.setInt(1, id);
            ResultSet rs = upit.executeQuery();
            if (rs.next()){
                return new Profesor(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7)
                );
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }
    
    
}
