/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control_BD;


import BD_Usuario.Modificar_usuario;
import BD_Usuario.Agregar_usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author richard
 */
public class Control_Usuario {
    
        Connection cn = null;
 //   private ConexionConBaseDatos mysql = new conexion();

    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;
   Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
             public void ModificarUsuario(int id,String usuario,String pasword) {
        try {
             conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update t_usuario set usuario ='" + usuario + "', "
                + " pasword ='" + pasword + "' "+ "  where id=" + id+"");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe establecimiento de un codigo "+id);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }//cierra metodo modificarCliente
    public DefaultTableModel contarid() {
        cn= ConexionConBaseDatos.getConexion();
        
        DefaultTableModel modelo;

        String[] titulos = {"id", "usuario", "pasword", "tipo"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.id,p.usuario,p.pasword,p.tipo"
                + " from t_usuario p";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");


                
                totalregistros = totalregistros + 1;
                Agregar_usuario.id=totalregistros;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public DefaultTableModel mostrar_inicial() {
        cn= ConexionConBaseDatos.getConexion();
        
        DefaultTableModel modelo;

        String[] titulos = {"id", "usuario", "pasword", "tipo"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.id,p.usuario,p.pasword,p.tipo"
                + " from t_usuario p";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
         

                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    public DefaultTableModel mostrar(String buscar) {
        cn= ConexionConBaseDatos.getConexion();
        DefaultTableModel modelo;
        String[] titulos = {"id", "usuario", "pasword", "tipo"};
        String[] registro = new String[14];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.id,p.usuario,p.pasword,p.tipo"
                + " from t_usuario p"
                + " where usuario like '%"
                + buscar + "%' "
                + "order by id desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(vusuario dts) {
        cn= ConexionConBaseDatos.getConexion();
       sSQL = "insert into t_usuario (id,usuario,pasword,tipo)"
                + "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            //PreparedStatement pst2 = cn.prepareStatement(sSQL2);
        pst.setInt(1, dts.getId());
            pst.setString(2, dts.getUsuario());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getTipo());
                  int n2 = pst.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vusuario dts) {
        cn= ConexionConBaseDatos.getConexion();
//consultar editar usuario
        
        sSQL2 = "update t_usuario set id=?,usuario=?,pasword=?,tipo=?"
                + " where id=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL2);

   

            pst.setInt(1, dts.getId());
            pst.setString(2, dts.getUsuario());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getTipo());
 

               int n2 = pst.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
         

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vusuario dts) {
        cn= ConexionConBaseDatos.getConexion();
//consulta eliminar usuario
                
          sSQL="delete from t_usuario where id=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getId());

               int n2 = pst.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
         

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public DefaultTableModel login(String usuario,String pasword) {
        cn= ConexionConBaseDatos.getConexion();
        DefaultTableModel modelo;

        String[] titulos = {"id", "usuario", "pasword", "tipo"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.id,p.usuario,p.pasword,p.tipo"
                + " from t_usuario p "
                + " where p.usuario='"
                + usuario + "' and p.pasword='" + pasword + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
}
