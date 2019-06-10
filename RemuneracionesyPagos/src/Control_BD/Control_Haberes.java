/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import static BD_HAB_DES.Agregar_hab_des.cbox_HAB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC PERSONAL RICH
 */
public class Control_Haberes {
        DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"ID_HAB", "NOMBRE_HAB"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
              Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
    
    
    
    
    
    
    
    
    
    
    
    
           public void CargarGEThaber(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //ejecuta una consulta a la BD
        ejecutarGEThaber();
        
     }
                                  
                                     public void ejecutarGEThaber() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                           try{
                                // creamos la Conexion
                                 conexion.setAutoCommit(false);
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_haberes()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              int haberes=0;
                              
                           while(rs.next()){
                            haberes = rs.getInt("ID_HAB");    
                           }
                                  
                                BD_HAB_DES.AgregarHaberes.idHaber=haberes;
                               
                                conexion.commit();
                     
                        }
                         
                         
                         catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta
       
                                     public void ejecutarGETcargarCOMBO() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                       cbox_HAB.removeAllItems();
                           try{
                                // creamos la Conexion
                                 conexion.setAutoCommit(false);
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_haberes()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              int haberes=0;
                              
                           while(rs.next()){
                            cbox_HAB.addItem(rs.getString("NOMBRE_HAB")); 
                          
                           }
                                  
                         
                           
                                conexion.commit();
                     
                        }
                         
                         
                         catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta
                                           
                                     
                                     
                                     
                                         public static void  addHaberes(int ID_HAB, String NOMBRE_HAB) {

         Connection reg = ConexionConBaseDatos.getConexion();      
   try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_haberes  (?,?)}");
     
                // enviar parametros
            cst.setInt(1, ID_HAB);
            cst.setString(2,NOMBRE_HAB);

            
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                            
                   System.out.println("ejecutada");
                // Ejecuta el procedimiento almacenado
                cst.execute();
  

   }
          catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                reg.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
