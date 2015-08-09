/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanEjemplar;
import app.model.BeanEstante;
import app.model.BeanLibro;
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
 * @author ricardo
 */
public class DaoEjemplar extends AbstractDao<BeanEjemplar> {

    private static final String TABLA = "usuario";
    private static final String PK = "id_usuario";
//	private static final String[] ATRIBUTES =
//	{"nombre", "primer_apellido","segundo_apellido","correo",""};

    public DaoEjemplar(Connection con) {
        super(con);
    }

    /**
     *
     * @return TODOS los usuarios
     */
//		String query = "SELECT * FROM USUARIO"
//			+ "  ORDER BY nombre ASC;";
//		
//		List<BeanUsuario> list = new ArrayList<>();
//		try {
//			PreparedStatement sql = con.prepareStatement(query);
//			list = passResultSet(sql.executeQuery(), list);
//			
//		} catch (SQLException ex) {
//			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		
//		return list;
//	}
//	
    /**
     *
     * @return Usuarios con alta = true
     */
    public List<BeanEjemplar> getActive() {
        String query = "SELECT * FROM usuario WHERE alta = 'true'"
                + " ORDER BY id_usuario ASC;";
        List<BeanEjemplar> list = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            list = (List<BeanEjemplar>) passResultSet(sql.executeQuery(), list);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void consultaLogin(String correo , String pass){
        
    }
    
    @Override
    List<BeanEjemplar> passResultSet(ResultSet res, List<BeanEjemplar> list) throws SQLException {

        while (res.next()) {
            BeanEjemplar ej = new BeanEjemplar();
            ej.setId_ejemplar(res.getInt("id_ejemplar"));
            
            BeanLibro libro= new BeanLibro();
            DaoLibro daoLibro= new DaoLibro(con);
            libro=daoLibro.get(res.getInt("id_libro"));
            ej.setLibro(libro);
            
            BeanEstante estante = new BeanEstante();
            DaoEstante daoEstante= new DaoEstante(con);
            estante=daoEstante.get(res.getInt("id_estante"));
            ej.setEstante(estante);
            
            
            list.add(ej);
        }

        return list;
    }

    @Override
    public List<BeanEjemplar> getAll() {
        String query = "SELECT * FROM Ejemplar"
                + " ORDER BY id_ejemplar ASC;";
        List<BeanEjemplar> list = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            list = (List<BeanEjemplar>) passResultSet(sql.executeQuery(), list);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    

    @Override
    public BeanEjemplar get(int id) {
        BeanEjemplar ejemplar = new BeanEjemplar();
        String query = "SELECT * FROM " + "Ejemplar" + " WHERE " + "id_ejemplar" + " = ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

           ejemplar= passResultSet(result, new ArrayList<BeanEjemplar>()).get(0);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ejemplar;
    }

    @Override
    public boolean update(BeanEjemplar bean) {

     
        String query = "UPDATE " + "Ejemplar" + " SET"
                + " libro = ?,"
                + " estante = ?"          
                + " WHERE " + " id_ejemplar" + " = ?;";
       

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bean.getLibro().getId_libro());
            ps.setInt(2, bean.getEstante().getId_estante());
            ps.setInt(3, bean.getId_ejemplar());
            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
        public boolean baja(int id) {
        String query= "DELETE FROM Ejemplar WHERE id_ejemplar= ?;";
         
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate()==1){
                 ps.close();
                return true;
               
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return false;
     }
        public boolean deleteUser(int id) {
            
        String query= "DELETE  usuario WHERE id_usuario= ?;";
         
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate()==1){
                 ps.close();
                return true;
               
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return false;
     }
    
    @Override
        public boolean add(BeanEjemplar bean) {
            
            
        String query = "INSERT INTO Ejemplar"
                + " (id_libro, id_estante)"
                + " VALUES (?, ?);";
        

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bean.getLibro().getId_libro());
            ps.setInt(2, bean.getEstante().getId_estante());
            
            if (ps.executeUpdate() == 1) {

                ps.close();
                return true;
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
        
        
         public boolean addEjemplar(BeanEjemplar bean) {
            
            
        String query = "INSERT INTO Ejemplar"
                + " (id_libro, id_estante)"
                + " VALUES (?, ?);";
        
//  for(int x = 0; x < a; x++){
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bean.getLibro().getId_libro());
            ps.setInt(2, bean.getEstante().getId_estante());
            
            if (ps.executeUpdate() >= 1) {

                ps.close();
                return true;
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
//  }
        return false;
    }
         
        
        public boolean addLib(BeanEjemplar bean, int a) {
             String query = "INSERT INTO Ejemplar"
                + " (id_libro, id_estante)"
                + " VALUES (?, ?);";
            
            for(int x = 0; x < a; x++){
                
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bean.getLibro().getId_libro());
            ps.setInt(2, bean.getEstante().getId_estante());
            
            ps.executeUpdate();
            ps.close();
        } 
            catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        return true;
    }
        
        public int idmax(){
            String query = "SELECT MAX(id_libro) FROM Libro";
        int max =0;
        try {
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                max = rs.getInt(1);
            }
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            max = max+1;
        return max;
    }
        
        
        public String maxEjemplars(){
            String [] b = new String[1]; 
            String query = "SELECT DISTINCT Libro.titulo FROM Libro JOIN Ejemplar ON Libro.id_libro = Ejemplar.id_libro\n" +
            "GROUP BY Libro.titulo, Libro.id_libro HAVING COUNT(*)=(SELECT top 1 COUNT(id_libro) \n" +
            "FROM Ejemplar GROUP BY id_libro ORDER BY COUNT(id_libro) DESC)";
            String a=""; 
            try {
            PreparedStatement sql = con.prepareStatement(query);
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                a = rs.getString(1);
            }
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            return a;
        }
        
        //metodo correcto
        public List<BeanEjemplar> maxEjemplar() {
        String query = "SELECT DISTINCT Libro.titulo FROM Libro JOIN Ejemplar ON Libro.id_libro = Ejemplar.id_libro\n" +
            "GROUP BY Libro.titulo, Libro.id_libro HAVING COUNT(*)=(SELECT top 1 COUNT(id_libro) \n" +
            "FROM Ejemplar GROUP BY id_libro ORDER BY COUNT(id_libro) DESC);";
        List<BeanEjemplar> list = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            list = (List<BeanEjemplar>) passResultSet(sql.executeQuery(), list);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
           

  
    public boolean delete(int id) {
          
        String query= "DELETE  usuario WHERE id_usuario= ?;";
         
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
    
    
    
    public int countDisponibles(BeanLibro libro){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM Ejemplar"
			+ " WHERE id_libro = "+libro.getId_libro()
			+ " and id_ejemplar not in"
			+ " (SELECT id_ejemplar FROM Prestamo);";
		
		try {
			ResultSet result = con.prepareStatement(sentence).executeQuery();
			
			if (result != null){
				cuenta = result.getInt("cuenta");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return cuenta;
	}

    @Override
    public boolean delete(BeanEjemplar id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}


