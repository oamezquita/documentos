/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201
 */
public class AdministradorDAO implements DAOInterface<Administrador>{

    @Override
    public boolean save(Administrador entity) {
        String sql="";
        boolean exito = false;
        
           
        
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getNumeroDocumento())==null) 
            {    
             statement=
                    c.prepareStatement("insert into administrador values(?,?,?,?,?,?)");
            
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getClave());
            statement.setString(3, entity.getNumeroDocumento());
            statement.setString(4, entity.getNombres());
            statement.setString(5, entity.getApellido1());
            statement.setString(6, entity.getApellido2());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  administrador set login=?, clave=?,numero_documento=?,nombres=?,apellido1=?,apellido2=? where numero_documento=?");
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getClave());
            statement.setString(3, entity.getNumeroDocumento());
            statement.setString(4, entity.getNombres());
            statement.setString(5, entity.getApellido1());
            statement.setString(6, entity.getApellido2());
            statement.setString(7, entity.getNumeroDocumento());
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
    public void delete(Administrador entity) {
        
    }

    @Override
    public Administrador findById(Object id) {
        return null;
    }

    @Override
    public ArrayList<Administrador> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    public static void  main(String args[])
    {
    Administrador a=new Administrador("ricardo", "123","1564646","Ricardo","Perez","Juarez");
    
    AdministradorDAO dao=new AdministradorDAO();
    dao.save(a);
    }
}
