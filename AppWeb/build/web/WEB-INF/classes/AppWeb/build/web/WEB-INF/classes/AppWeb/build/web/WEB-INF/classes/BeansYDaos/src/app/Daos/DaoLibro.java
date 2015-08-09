/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanArea;
import app.model.BeanAutor;
import app.model.BeanEditorial;

import app.model.BeanEjemplar;
import app.model.BeanEstante;


import app.model.BeanLibro;
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
 * @author miguelangel
 */
public class DaoLibro extends AbstractDao<BeanLibro> {

    private static final String TABLA = "libro";
    private static final String PK = "id_libro";
//	private static final String[] ATRIBUTES =
//	{"nombre", "primer_apellido","segundo_apellido","correo",""};

    public DaoLibro(Connection con) {
        super(con);
    }

    @Override
    List<BeanLibro> passResultSet(ResultSet res, List<BeanLibro> list) throws SQLException {
        while (res.next()) {

            BeanLibro bean = new BeanLibro();
            bean.setId_libro(res.getInt("id_libro"));
            bean.setTitulo(res.getString("titulo"));
            bean.setISBN(res.getLong("ISBN"));
            bean.setPaginas(res.getInt("paginas"));
            
           BeanArea area= new BeanArea();
           DaoArea daoArea = new DaoArea(con);
           area=daoArea.get(res.getInt("id_area"));
           bean.setArea(area);
            
            
            BeanEditorial editorial= new BeanEditorial();
            DaoEditorial daoEditorial= new DaoEditorial(con);
            editorial=daoEditorial.get(res.getInt("id_editorial"));
           bean.setEditorial(editorial);
           
           
          DaoAutor daoAutor=new DaoAutor(con); 
           List<BeanAutor>autores= daoAutor.findByLibro(bean);
            bean.setAutores(autores);
            list.add(bean);
        }

        return list;
    }

    @Override
    public List<BeanLibro> getAll() {
        List<BeanLibro> libros = new ArrayList();

        String query = "SELECT * from Libro order by id_libro" + " ASC;";

        try {
            ResultSet result = executeQuery(query);
            libros = passResultSet(result, libros);

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return libros;
    }
    
    
    
    public List<BeanLibro> getAllAu(int id) {
        List<BeanLibro> libros = new ArrayList();

        String query = "SELECT nombre FROM Autor JOIN (Autor_has JOIN Libro"
                + "ON Autor_has.id_libro = Libro.id_libro) ON Autor.id_autor ="
                + "Autor_has.id_autor WHERE Libro.id_libro = ?;";

        try {
            ResultSet result = executeQuery(query);
            libros = passResultSet(result, libros);

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return libros;
    }
    
    public List<BeanLibro> getAllbyAu(String bus) {
        List<BeanLibro> libros = new ArrayList();

        String query = "SELECT Libro.* FROM Autor JOIN ( Autor_has JOIN Libro"
                + "ON Autor_has.id_libro = Libro.id_libro) ON Autor.id_libro ="
                + "Autor_has.id_libro WHERE Autor.nombre like '%?%' by id_libro ASC;";

        try {
            ResultSet result = executeQuery(query);
            libros = passResultSet(result, libros);

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return libros;
    }

    @Override
    public BeanLibro get(int id) {
    BeanLibro libro = new BeanLibro();
        String query = "SELECT * FROM " + "Libro" + " WHERE " + "id_libro" + " = ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            libro=passResultSet(result, new ArrayList<BeanLibro>()).get(0);

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return libro;
    }

    public boolean addLibro(BeanLibro beanLibro) {
        String query = "INSERT INTO Libro(titulo, ISBN, paginas, area, editorial, autores)"
                + "VALUES(?,?,?,?,?,?);";
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, beanLibro.getTitulo());
            ps.setLong(2, beanLibro.getISBN());
            ps.setInt(3, beanLibro.getPaginas());
            ps.setObject(4, beanLibro.getArea());
            ps.setObject(5, beanLibro.getEditorial());

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(BeanLibro bean) {
        JOptionPane.showMessageDialog(null, bean.getId_libro());
        System.out.println(bean.getId_libro());
        String query = "UPDATE Libro SET titulo = ?, "
                + " ISBN = ?, "
                + " paginas = ?, "
                + " id_area= ?, "
                + " id_editorial= ? "
                + " WHERE id_libro = ?;";
          
          
          

        try  {
            
            PreparedStatement ps = con.prepareStatement(query);
             
           ps.setString(1, bean.getTitulo());
            ps.setLong(2, bean.getISBN());
            ps.setInt(3, bean.getPaginas());
            ps.setInt(4, bean.getArea().getId_area());
            ps.setInt(5, bean.getEditorial().getId_editorial());
            ps.setInt(6, bean.getId_libro());
            
            if (ps.executeUpdate()== 1) {
                JOptionPane.showMessageDialog(null, ":D");
                deleteAutores(bean);
                addAutores(bean);
               ps.close();
               return true;
            }
             
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean delete(BeanLibro id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean baja(int id) {
        String query = "DELETE FROM Libro WHERE id_libro= ?;";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
     List<BeanLibro> passResultSetest(ResultSet res, List<BeanLibro> list) throws SQLException {
        while (res.next()) {

            BeanLibro bean = new BeanLibro();
            bean.setTitulo(res.getString("titulo"));
            list.add(bean);
        }

        return list;
    }
    
     public List<BeanLibro> maxEjemplar() {
        String query = "SELECT DISTINCT Libro.titulo FROM Libro JOIN Ejemplar ON Libro.id_libro = Ejemplar.id_libro\n" +
            "GROUP BY Libro.titulo, Libro.id_libro HAVING COUNT(*)=(SELECT top 1 COUNT(id_libro) \n" +
            "FROM Ejemplar GROUP BY id_libro ORDER BY COUNT(id_libro) DESC);";
        List<BeanLibro> lista = new ArrayList<>();
        try {
            PreparedStatement sql = con.prepareStatement(query);
            lista = (List<BeanLibro>) passResultSetest(sql.executeQuery(), lista);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public boolean add(BeanLibro bean) {
         String query = "INSERT INTO Libro(titulo, ISBN, paginas, id_area, id_editorial)"
                + "VALUES(?,?,?,?,?);";
       
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getTitulo());
            ps.setLong(2, bean.getISBN());
            ps.setInt(3, bean.getPaginas());
            ps.setInt(4, bean.getArea().getId_area());
            ps.setInt(5, bean.getEditorial().getId_editorial());

            if (ps.executeUpdate() < 1) {
                ps.close();
                
                return false;
            }
            ps.close();
            
          bean.setId_libro(getByIsbn(bean.getISBN()).getId_libro());
          addAutores(bean);
          return true;
                   
                                        

        } catch (SQLException ex) {
            Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public BeanLibro getByIsbn(long isbn) {
       
		BeanLibro libro = null;
		try {
			PreparedStatement statement = con.prepareStatement(
				"SELECT * FROM LIBRO WHERE ISBN=?;");
			statement.setLong(1, isbn);
			ResultSet result = statement.executeQuery();
			
			libro = passResultSet(result, new ArrayList<BeanLibro>()).get(0);
			
			
			statement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IndexOutOfBoundsException ex){
			
		}
		
		return libro;
	}
    
    public boolean addAutores(BeanLibro bean){
		
		if (bean.getAutores() != null && bean.getAutores().size() > 0){
			
				for (BeanAutor autor : bean.getAutores()){
					try {
						String query = "INSERT INTO Autor_has (id_libro, id_autor)"
							+ " VALUES (?, ?);";
						PreparedStatement statement = con.prepareStatement(query);
                                                statement.setInt(1, bean.getId_libro());
						statement.setInt(2, autor.getId_autor());
						
						
						if (statement.executeUpdate() < 1) {
							statement.close();
							return false;
						}
						statement.close();
						
					} catch (SQLException ex) {
						Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		
		
		
		return true;
    
    
    
}
    
    public boolean deleteAutores(BeanLibro bean){
       
        
		String query = "DELETE FROM Autor_has WHERE id_autor = "+bean.getId_libro()+";";
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			if (ps.executeUpdate() == 1) 
                            return true;
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
    
    public BeanLibro findByNombre(String nombre) {

        String query = "SELECT * from Libro where titulo= ?;";
        BeanLibro ed = new BeanLibro();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                
                ed.setId_libro(result.getInt("id_libro"));
               ed.setTitulo(result.getString("titulo"));
               ed.setISBN(result.getLong("ISBN"));
               
               
               
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ed;
    }
    
    }
    



