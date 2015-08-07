/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanAutor;
import app.model.BeanEditorial;
import app.model.BeanLibro;
import app.model.BeanPrestamo;
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
 * @author Eric
 */

public class DaoPrestamo extends AbstractDao<BeanPrestamo>{
    public DaoPrestamo(Connection con) {
      super (con);
        //
    }

   

    

    @Override
    List<BeanPrestamo> passResultSet(ResultSet res, List<BeanPrestamo> list) throws SQLException {
        while (res.next()){
            BeanPrestamo ed = new BeanPrestamo();
            ed.setId_prestamo(res.getInt("id_prestamo"));
            ed.setId_usuario(res.getInt("id_usuario"));
            ed.setId_ejemplar(res.getInt("id_ejemplar"));
            ed.setFecha_entrega(res.getDate("fecha_salida"));
            ed.setFecha_salida(res.getDate("fecha_entrega"));
            list.add(ed);
        }
        return list;
    }

    @Override
    public List<BeanPrestamo> getAll() {
       String query = "SELECT * FROM Prestamo"
			+ " ORDER BY id_prestamo ASC;" ;
       
		List<BeanPrestamo> list = new ArrayList<>();
		try {
			PreparedStatement sql = con.prepareStatement(query);
			list = (List<BeanPrestamo>) passResultSet(sql.executeQuery(), list);
			sql.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
                for (BeanPrestamo list1 : list) {
                    System.out.println(list1);
            }
		
		return list;
    }
    public List<BeanPrestamo> getActive(){
        String query = "SELECT * FROM Prestamo"
			+ " ORDER BY id_prestamo ASC;" ;
       
		List<BeanPrestamo> list = new ArrayList<>();
		try {
			PreparedStatement sql = con.prepareStatement(query);
			list = (List<BeanPrestamo>) passResultSet(sql.executeQuery(), list);
			sql.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
                for (BeanPrestamo list1 : list) {
                    System.out.println(list1);
            }
		
		return list;
    }

    @Override
    public BeanPrestamo get(int id) {
         BeanPrestamo prestamo = new BeanPrestamo();

        String query = "SELECT * FROM " + "Prestamo" + " WHERE " + "id_prestamo" + " = ?";


        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                prestamo.setId_prestamo(result.getInt("id_prestamo"));
                

//                prestamo.setFecha_Salida(result.getDate("primer_apellido"));
                prestamo.setFecha_entrega(result.getDate("segundo_apellido"));
                prestamo.setId_usuario(result.getInt("pais"));

            }

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prestamo;
    }

    @Override
    public boolean update(BeanPrestamo bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BeanPrestamo id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(BeanPrestamo bean) {
        String query = "INSERT INTO  prestamo( fecha_salida, fecha_entrega, id_usuario, id_ejemplar)"
                + "values(?,?,?,?);";
        try (PreparedStatement ps = con.prepareStatement(query)) {
          ps.setDate(1, bean.getFecha_salida());
          ps.setDate(2, bean.getFecha_entrega());
          ps.setInt(3, bean.getId_usuario());
          ps.setInt(4, bean.getId_ejemplar());

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

   
  

   
}

