/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanArea;
import app.model.BeanEstante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class DaoEstante extends AbstractDao<BeanEstante>{

    public DaoEstante(Connection con) {
        super(con);
    }

    @Override
    List<BeanEstante> passResultSet(ResultSet res, List<BeanEstante> list) throws SQLException {
        while (res.next()){
            BeanEstante bean= new BeanEstante();
            
            bean.setId_estante( res.getInt("id_estante"));
            bean.setUbicacion(res.getString("ubicacion"));
            list.add(bean);
        }
        return list;
    }

    @Override
    public List<BeanEstante> getAll() {
        List<BeanEstante>list= new ArrayList();
        
        String query="SELECT * FROM Estante;";
        
        ResultSet result= executeQuery(query);
         try {
            
            list= passResultSet(result, list);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        return list;
    }

    @Override
    public BeanEstante get(int id) {
        BeanEstante bean=new BeanEstante();
        
        String quuery= "SELECT * FROM Estante WHERE id_estante= ?;";
        
        try {
            PreparedStatement ps= con.prepareStatement(quuery);
            ps.setInt(1, id);
              ResultSet result=ps.executeQuery();
              if(result.next()){
                  bean.setId_estante(result.getInt("id_estante"));
                  bean.setUbicacion(result.getString("ubicacion"));
              }
            
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bean;
    }

    @Override
    public boolean update(BeanEstante bean) {
        String query ="UPDATE Estante SET ubicacion =? where id_estante=?;";
        
        try {
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, bean.getUbicacion());
            ps.setInt(2, bean.getId_estante());
            
            if(ps.executeUpdate()==1){
                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(BeanEstante id) {
        String query = "DELETE FROM Estante where id_estante= ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id.getId_estante());
            
            if(ps.executeUpdate()==1){
                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }

    @Override
    public boolean add(BeanEstante bean) {
         String query = "insert into Estante(ubicacion) values(?);";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bean.getUbicacion());

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

  public boolean del(int id){
      
      String query = "DELETE FROM Estante where id_estante= ?;";
        
       
          try (PreparedStatement ps = con.prepareStatement(query)) {
              ps.setInt(1, id);
              
              if(ps.executeUpdate()==1){
                  ps.close();
                  return true;
              }
          
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
      
      
  }
public BeanEstante findByNombre(String nombre) {

        String query = "SELECT * from Estante where ubicacion= ?;";
        BeanEstante ed = new BeanEstante();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                
                ed.setId_estante(result.getInt("id_estante"));
              
               ed.setUbicacion(result.getString("ubicacion"));
               
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ed;
    }
   

  

}
