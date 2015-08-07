/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanUsuario;
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
public class DaoUsuario extends AbstractDao<BeanUsuario> {

    private static final String TABLA = "usuario";
    private static final String PK = "id_usuario";
//	private static final String[] ATRIBUTES =
//	{"nombre", "primer_apellido","segundo_apellido","correo",""};

    public DaoUsuario(Connection con) {
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
    public List<BeanUsuario> getActive() {
        String query = "SELECT * FROM usuario WHERE alta = 'true'"
                + " ORDER BY id_usuario ASC;";
        List<BeanUsuario> list = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            list = (List<BeanUsuario>) passResultSet(sql.executeQuery(), list);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public boolean consultaLogin(String correo,String pass){
          boolean resultado = false;              
        try {
           
            String Query = "SELECT es_admi from usuario WHERE correo = ? and pass =? and alta='true' and es_admi='true';";
            PreparedStatement pstm = con.prepareStatement(Query);
           
            pstm.setString(1,correo);
            pstm.setString(2,pass);
         
            ResultSet rs=pstm.executeQuery();
    if (pstm.executeQuery().next()){
	pstm.close();
	resultado=true;
			}
			
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
   return  resultado ;
    }
    
    
    @Override
    List<BeanUsuario> passResultSet(ResultSet res, List<BeanUsuario> list) throws SQLException {

        while (res.next()) {
            BeanUsuario us = new BeanUsuario();
            us.setId_usuario(res.getInt("id_usuario"));
            us.setAlta(res.getBoolean("alta"));
            us.setEs_admi(res.getBoolean("es_admi"));
            us.setCorreo(res.getString("correo"));
            us.setPass(res.getString("pass"));
            us.setTelefono(res.getString("telefono"));
            us.setNombre(res.getString("nombre"));
            us.setDireccion(res.getString("direccion"));
            us.setPrimer_apellido(res.getString("primer_apellido"));
            us.setSegundo_apellido(res.getString("segundo_apellido"));
            list.add(us);
        }

        return list;
    }

    @Override
    public List<BeanUsuario> getAll() {
        String query = "SELECT * FROM usuario"
                + " ORDER BY id_usuario ASC;";
        List<BeanUsuario> list = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            list = (List<BeanUsuario>) passResultSet(sql.executeQuery(), list);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    

    @Override
    public BeanUsuario get(int id) {
        BeanUsuario usuario = new BeanUsuario();
        String query = "SELECT * FROM " + "usuario" + " WHERE " + "id_usuario" + " = ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                usuario.setId_usuario(result.getInt("id_usuario"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setPrimer_apellido(result.getString("primer_apellido"));
                usuario.setSegundo_apellido(result.getString("segundo_apellido"));
                usuario.setCorreo(result.getString("correo"));
                usuario.setEs_admi(result.getBoolean("es_admi"));
                usuario.setPass(result.getString("pass"));
                usuario.setDireccion(result.getString("direccion"));
                usuario.setTelefono(result.getString("telefono"));
                usuario.setAlta(result.getBoolean("alta"));

            }

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean update(BeanUsuario bean) {

     
        String query = "UPDATE " + "usuario" + " SET"
                + " nombre = ?,"
                + " primer_apellido = ?,"
                + " segundo_apellido = ?,"
                + " correo = ?,"
                + " es_admi = ?,"
                + " pass = ?,"
                + " direccion = ?,"
                + " telefono = ?,"
                + " alta = ?"
                
                + " WHERE " + " id_usuario" + " = ?;";
       

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getPrimer_apellido());
            ps.setString(3, bean.getSegundo_apellido());
            ps.setString(4, bean.getCorreo());
            ps.setString(5, bean.isEs_admi()+"");
            ps.setString(6, bean.getPass());
            ps.setString(7, bean.getDireccion());
            ps.setString(8, bean.getTelefono());
            ps.setString(9, bean.isAlta()+"");
            ps.setInt(10, bean.getId_usuario());
            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
        public boolean baja(int id) {
        String query= "UPDATE usuario SET alta='false' WHERE id_usuario= ?;";
         
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
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return false;
     }
    
    @Override
        public boolean add(BeanUsuario bean) {
            
        String query = "INSERT INTO usuario"
                + " (nombre, primer_apellido, segundo_apellido, correo, es_admi, pass, direccion, telefono, alta)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getPrimer_apellido());
            ps.setString(3, bean.getSegundo_apellido());
            ps.setString(4, bean.getCorreo());
            ps.setString(5, "" + bean.isEs_admi());
            ps.setString(6, bean.getPass());
            ps.setString(7, bean.getDireccion());
            ps.setString(8, bean.getTelefono());
             ps.setString(9, bean.isAlta()+"");
           
            if (ps.executeUpdate() == 1) {

                ps.close();
                return true;
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

        public boolean autenticar(String correo, String passwd){
		
		try {
			PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM dbo.usuario WHERE"
					+ " correo = ? and"
					+ " pass = ?;" );
			ps.setString(1, correo);
			ps.setString(2, passwd);
			
			if (ps.executeQuery().next()){
				ps.close();
				return true;
			}
			
			ps.close();
		} catch (SQLException ex) {
                    System.out.println("ahhagd");
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}

    @Override
    public boolean delete(BeanUsuario id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

//	public BeanUsuario get(int id) {
//		BeanUsuario usr = null;
//		try {
//			PreparedStatement sql = con.prepareStatement(
//				"SELECT * FROM USUARIO WHERE usuario_id = "+id+";");
//			
//			ResultSet res  = sql.executeQuery();
//			List<BeanUsuario> list = new ArrayList<>();
//			list = passResultSet(res, list);
//			usr = list.get(0);
//			
//			sql.close();
//		} catch (SQLException ex) {
//			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (IndexOutOfBoundsException ex){}
//		
//		return usr;
//	}
//	public boolean update(UsuarioBean bean) {
//		String query = "UPDATE USUARIO SET"
//			+ " nombre = ?"
//			+ ", correo = ?"
//			+ ", passwd = ?"
//			+ ", telefono = ?"
//			+ ", direccion = ?"
//			+ ", deuda = ?"
//			+ ", alta= ?"
//			+ ", es_admi= ?"
//			+ " WHERE usuario_id = " + bean.getUsuario_id() + ";";
//		
//		try {
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, bean.getNombre());
//			ps.setString(2, bean.getCorreo());
//			ps.setString(3, bean.getPasswd());
//			ps.setString(4, bean.getTelefono());
//			ps.setString(5, bean.getDireccion());
//			ps.setDouble(6, bean.getDeuda());
//			ps.setString(7, bean.isAlta()+"");
//			ps.setString(8, bean.isEs_admi()+"");
//			
//			if (ps.executeUpdate() >= 1){
//				ps.close();
//			return true;
//			}
//			ps.close();
//		} catch (SQLException ex) {
//			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		
//		return false;
//		
//	}
//	public boolean delete(UsuarioBean bean) {
//		String query = "DELETE FROM USUARIO WHERE usuario_id = "+bean.getUsuario_id();
//		
//		try {
//			PreparedStatement statement = con.prepareStatement(query);
//			if (statement.executeUpdate() >= 1){
//				statement.close();
//			return true;
//			}
//			statement.close();
//		} catch (SQLException ex) {
//			
//			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		
//		return false;
//	}
//	public boolean add(BeanUsuario bean) {
//		String query = "INSERT INTO USUARIO"
//			+ " (nombre, primer_apellido, segundo_apellido, correo, es_admi, pass, direccion, telefono, alta)"
//			+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
//		
//		try {
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, bean.getNombre());
//                        ps.setString(2, bean.getPrimer_apellido());
//			ps.setString(3, bean.getSegundo_apellido());
//                        ps.setString(3, bean.getSegundo_apellido());
//			ps.setString(7, bean.isEs_admi()+"");
//			
//			if (ps.executeUpdate() ==1){
//				ps.close();
//				return true;
//			}
//			
//			ps.close();
//			
//		} catch (SQLException ex) {
//			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		
//		return false;
//	}
	
//	public UsuarioBean findByCorreo(String correo){
//		UsuarioBean usuario = new UsuarioBean();
//		
//		String sentence ="SELECT * FROM USUARIO WHERE correo = ?;";
//		
//		try {
//			PreparedStatement ps = con.prepareStatement(sentence);
//			ps.setString(1, correo);
//			
//			ResultSet rs  = ps.executeQuery();
//			
//			if (rs.next()){
//				usuario.setAlta(rs.getBoolean("alta"));
//				usuario.setEs_admi(rs.getBoolean("es_admi"));
//				usuario.setNombre(rs.getString("nombre"));
//				usuario.setCorreo(rs.getString("correo"));
//				usuario.setPasswd(rs.getString("passwd"));
//				usuario.setDireccion(rs.getString("direccion"));
//				usuario.setTelefono(rs.getString("telefono"));
//				usuario.setDeuda(rs.getDouble("deuda"));
//				usuario.setUsuario_id(rs.getInt("usuario_id"));
//			}
//			
//		} catch (SQLException ex) {
//			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		
//		return usuario;
//	}
//	
//	 List<UsuarioBean> passResultSet(ResultSet res, List<UsuarioBean> list) throws SQLException {
//		
//		while (res.next()){
//			UsuarioBean us = new UsuarioBean();
//			us.setUsuario_id(res.getInt("usuario_id"));
//			us.setAlta(res.getBoolean("alta"));
//			us.setEs_admi(res.getBoolean("es_admi"));
//			us.setCorreo(res.getString("correo"));
//			us.setPasswd(res.getString("passwd"));
//			us.setTelefono(res.getString("telefono"));
//			us.setNombre(res.getString("nombre"));
//			us.setDireccion(res.getString("direccion"));
//			
//			
//			us.setDeuda(res.getDouble("deuda"));
//			list.add(us);
//		}
//		
//		return list;
//	}
//	 public int countPrestamos(UsuarioBean usuario){
//		 int n = -1;
//		 String sentence = "SELECT COUNT(*) as cuenta FROM PRESTAMO"
//			 + " WHERE usuario_id = ?";
//		 
//		 try(PreparedStatement ps = con.prepareStatement(sentence)){
//			 ps.setInt(1, usuario.getUsuario_id());
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()){
//				n = rs.getInt("cuenta");
//			}
//			
//			ps.close();
//		 } catch (SQLException ex) {
//			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		 return n;		 
//	 }

