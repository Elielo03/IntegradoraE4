/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanAutor;
import app.model.BeanEditorial;
import app.model.BeanLibro;
import java.beans.Statement;
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
public class DaoEditorial extends AbstractDao<BeanEditorial> {

    

    public DaoEditorial(Connection con) {
        super(con);
    }
    public List<BeanEditorial> getActive() {
		String query = "SELECT * FROM Editorial WHERE alta = 'true'"
			+ " ORDER BY id_editorial ASC;" ;
		List<BeanEditorial> list = new ArrayList<>();
		try {
			PreparedStatement sql = con.prepareStatement(query);
			list = (List<BeanEditorial>) passResultSet(sql.executeQuery(), list);
			sql.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
                for (BeanEditorial list1 : list) {
                    
            }
		
		return list;
	}

   

    @Override
    List<BeanEditorial> passResultSet(ResultSet res, List<BeanEditorial> list) throws SQLException {
        while (res.next()){
            BeanEditorial ed = new BeanEditorial();
            ed.setId_editorial(res.getInt("id_editorial"));
            ed.setNombre(res.getString("nombre"));
            ed.setDireccion(res.getString("direccion"));
            ed.setAlta(res.getBoolean("alta"));
            list.add(ed);
        }
        return list;
    }
    
    List<BeanEditorial> passResultSetest(ResultSet res, List<BeanEditorial> list) throws SQLException {
        while (res.next()) {

            BeanEditorial bean = new BeanEditorial();
            bean.setNombre(res.getString("nombre"));
            list.add(bean);
        }

        return list;
    }

    @Override
    public List<BeanEditorial> getAll() {
        String query = "SELECT * FROM Editorial"
			+ " ORDER BY id_editorial ASC;" ;
       
		List<BeanEditorial> list = new ArrayList<>();
		try {
			PreparedStatement sql = con.prepareStatement(query);
			list = (List<BeanEditorial>) passResultSet(sql.executeQuery(), list);
			sql.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
                for (BeanEditorial list1 : list) {
                    System.out.println(list1);
            }
		
		return list;
    }

    @Override
    public boolean update(BeanEditorial bean) {
     
         String query=" UPDATE Editorial SET "
                    + " nombre = ?,"
                    + " direccion = ?,"
                    + " alta = ? "
                    + " WHERE id_editorial = ?";
        
        try {
           
            
            PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, bean.getNombre());
                ps.setString(2, bean.getDireccion());
                ps.setString(3,  ""+bean.getAlta());
                ps.setInt(4, bean.getId_editorial());
                
             
                if(ps.executeUpdate()==1){
                    ps.close();
                    return true;
                }
           ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
    public boolean updatees(BeanEditorial bean) {
        
         String query=" UPDATE Editorial SET "
                    + " nombre = ?,"
                    + " direccion = ?"
                    + " WHERE id_editorial = ?";        
        try {PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, bean.getNombre());
                ps.setString(2, bean.getDireccion());
                ps.setInt(3, bean.getId_editorial());
                
             
                if(ps.executeUpdate()==1){
                    ps.close();
                    return true;
                }
           ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
    
    @Override
    public boolean delete(BeanEditorial id) {
        String query=" DELETE Editorial WHERE id_editorial = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id.getId_editorial());
                if(ps.executeUpdate()==1){
                    ps.close();
                    return true;
                }
           ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
        
    }
    
    public boolean deleteEditorial(int id){
         String query=" DELETE Editorial WHERE id_editorial = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                if(ps.executeUpdate()==1){
                    ps.close();
                    return true;
                }
           ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
    
    public boolean deletees(int id) {
        String query=" UPDATE Editorial SET "
                    
                    + " alta = 'false' "
                    + " WHERE id_editorial = ?";
        
           
            
            try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate()==1){
                 ps.close();
                return true;
               
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return false;
        
     }

    @Override
    public boolean add(BeanEditorial bean) {
        
        String query = "INSERT INTO Editorial(nombre, direccion, alta)"
                + " values(?,?,?);";
        
        try (PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getDireccion());
            ps.setString(3, bean.getAlta()+"");
            
            

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public BeanEditorial get(int id) {
        BeanEditorial bean = new BeanEditorial();
        
         String query ="SELECT * FROM Editorial WHERE id_editorial= ?";
        
        try {
           
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet result= ps.executeQuery();
            
            while(result.next()){
                bean.setId_editorial(result.getInt("id_editorial"));
                bean.setNombre(result.getString("nombre"));
                bean.setDireccion(result.getString("direccion"));
            }
            
          
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bean;
        
    }
    public boolean deleteLogical(int id){
         String query=" UPDATE Editorial SET "
                    + " alta = 'false' "
                    + " WHERE id_editorial = ?";
        
        try {
           
            
            PreparedStatement ps = con.prepareStatement(query);
              
             
                ps.setInt(1, id);
                
             
                if(ps.executeUpdate()==1){
                    ps.close();
                    return true;
                }
           ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
        
    }
    
     public BeanEditorial findByNombre(String nombre) {

        String query = "SELECT * from Editorial where nombre= ?;";
        BeanEditorial ed = new BeanEditorial();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                
                ed.setId_editorial(result.getInt("id_editorial"));
               ed.setNombre(result.getString("nombre"));
               ed.setDireccion(result.getString("direccion"));
               ed.setAlta(result.getBoolean("alta"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ed;
    }
     public List<BeanEditorial> minEditorial() {
        String query = "SELECT Editorial.nombre FROM Editorial JOIN Libro ON Editorial.id_editorial = Libro.id_editorial\n" +
        "GROUP BY Editorial.nombre, Libro.id_editorial HAVING COUNT(*)=(SELECT top 1 COUNT(id_libro)\n" +
        "FROM Libro GROUP BY id_editorial ORDER BY COUNT(id_libro) ASC);";
        List<BeanEditorial> lista = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            lista = (List<BeanEditorial>) passResultSetest(sql.executeQuery(), lista);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
     
}

