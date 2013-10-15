/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import datos.configuracion.Conexion;
import datos.entidades.Denuncia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201
 */
public class DenunciaDAO implements DAOInterface<Denuncia>{

    @Override
    public boolean save(Denuncia entity) {
        String sql="";
        boolean exito = false;
               
        
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getIdDenuncia())==null) 
            {    
             statement=
                    c.prepareStatement("insert into denuncia values(?,?,?,?)");
            
            statement.setInt(1, entity.getIdDenuncia());
            statement.setDate(2, entity.getFechaDenuncia());
            statement.setDate(3, entity.getFechaPerdida());
            statement.setTime(4, entity.getHoraPerdida());
            
            
            }
            else
            {
                 statement=
                    c.prepareStatement("update  denuncia set id_denuncia=?, fecha_denuncia=?,fecha_perdida=?,hora_perdida=? where id_denuncia=?");
            statement.setInt(1, entity.getIdDenuncia());
            statement.setDate(2, entity.getFechaDenuncia());
            statement.setDate(3, entity.getFechaPerdida());
            statement.setTime(4, entity.getHoraPerdida());
            statement.setInt(5, entity.getIdDenuncia());
            }    
            
            exito = statement.execute();
            
            exito=true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        
        return exito;
    }

    @Override
    public void delete(Denuncia entity) {
        
    }

    @Override
    public Denuncia findById(Object id) {
        return null;
    }

    @Override
    public ArrayList<Denuncia> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public static void  main(String args[])
    {
        
        Calendar c=Calendar.getInstance();
        c.set(1999,12,10); 
        java.util.Date w=c.getTime();
        java.sql.Date z= new Date(w.getTime());
        Time time=new  Time(10, 20, 10);        
    Denuncia d=new Denuncia(123455,z,z,time);
    DenunciaDAO dao=new DenunciaDAO();
    dao.save(d);
    
    }
}
