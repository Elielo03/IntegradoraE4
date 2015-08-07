/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanArea;
import app.model.BeanEditorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliel David
 */
public class DaoArea extends AbstractDao<BeanArea>{

    public DaoArea(Connection con) {
        super(con);
    }

    public boolean addArea(BeanArea beanArea) {
        
        String query = "INSERT into Area(nombre, alta) values(? ?);";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, beanArea.getNombre());
            ps.setString(2, beanArea.getAlta()+"");

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    List<BeanArea> passResultSet(ResultSet res, List<BeanArea> list) throws SQLException {
       while (res.next()){
           BeanArea area = new BeanArea();
          
				area.setId_area(res.getInt("id_area"));
				area.setNombre(res.getString("nombre"));
				area.setAlta(res.getBoolean("alta"));
				list.add(area);
           
       }
       return list;
    }

    @Override
    public List<BeanArea> getAll() {
        
        List<BeanArea> areas= new ArrayList();
        String query = "select * from Area ORDER by id_area ASC;";
        
        ResultSet result= executeQuery(query);
        try {
            
            areas= passResultSet(result, areas);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return areas;
    }

    @Override
    public BeanArea get(int id) {
        BeanArea area = new BeanArea();
         String query ="SELECT * FROM Area WHERE id_area=?;";
        try {
           
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result= ps.executeQuery();
            
            if(result.next()){
                area.setId_area(result.getInt("id_area"));
                area.setNombre(result.getString("nombre"));
                area.setAlta(result.getBoolean("alta"));
                
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return area;
        
    }

    @Override
    public boolean update(BeanArea bean) {
       
        String query = "UPDATE " + "Area" + " SET"
                + " nombre = ?,"
                + " alta = ?"
                + " WHERE " + "id_area" + " = ?;";
       bean.toString();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getAlta()+"");
            ps.setInt(3, bean.getId_area());
            if (ps.executeUpdate() == 1) {
                
                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

//=======
//        
//        
//       String query = "UPDATE Area set nombre= ?, alta= ? where id_area= ?;";
//       
//        try {
//            PreparedStatement ps =con.prepareStatement(query);
//            
//            ps.setString(1, bean.getNombre());
//            ps.setBoolean(2, bean.getAlta());
//            ps.setInt(3, bean.getId_area());
//            
//            if(ps.executeUpdate()==1){
//            ps.close();
//            return true;
//            }
//           ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         return false;
//>>>>>>> origin/master
    }
    

    @Override
    public boolean delete(BeanArea id) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean deleteArea(int id){
        String query = "DELETE  Area WHERE id_area= ?;";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean add(BeanArea beanArea) {
    String query = "insert into Area (nombre) values (?);";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, beanArea.getNombre());
            
            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
     public List<BeanArea> getActive() {
        
        List<BeanArea> areas= new ArrayList();
        String query = "select * from Area WHERE alta="
                + "\'true\' ORDER by id_area ASC;";
        
        ResultSet result= executeQuery(query);
        try {
            
            areas= passResultSet(result, areas);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return areas;
    }
     public boolean baja(int id) {
        String query= "UPDATE Area SET alta='false' WHERE id_area= ?;";
         
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate()==1){
                 ps.close();
                return true;
               
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return false;
     }

     public BeanArea findByNombre(String nombre){
         
         String query = "SELECT * from Area where nombre = ?;";
        BeanArea area = new BeanArea();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);

            ResultSet result = ps.executeQuery();
            if (result.next()) {

               
                area.setId_area(result.getInt("id_area"));
                area.setNombre(result.getString("nombre"));
                area.setAlta(result.getBoolean("alta"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return area;
    }
         
         
         
     
}
