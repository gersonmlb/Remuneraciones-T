/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import BD_HAB_DES.Agregar_hab_des;
import static BD_HAB_DES.Agregar_hab_des.cbox_HAB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static BD_HAB_DES.Agregar_hab_des.cbox_DESC;
/**
 *
 * @author PC PERSONAL RICH
 */
public class Control_Descuentos {
       DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"ID_DES", "NOMBRE_DESC"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
              Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
    
    
    
    
    
    
    
    
    
    
    
    
           public void CargarGETdescuento(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //ejecuta una consulta a la BD
        ejecutarGETdescuento();
        
     }
                                                public void ejecutarGETcargarCOMBO() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                       cbox_DESC.removeAllItems();
                           try{
                                // creamos la Conexion
                                 conexion.setAutoCommit(false);
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_descuentos()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              int descuento=0;
                              
                           while(rs.next()){
                               cbox_DESC.addItem(rs.getString("NOMBRE_DESC"));    
                 
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
                                     public void ejecutarGETdescuento() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                           try{
                                // creamos la Conexion
                           
                                 conexion.setAutoCommit(false);
                                
                             
                                
                                /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_descuentos ()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              int descuentos=0;
                              
                           while(rs.next()){
                            descuentos = rs.getInt("ID_DES");

                                  
                           }
                                  
                                BD_HAB_DES.AgregarDescuentos.idDescuento=descuentos;
                               
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
       
                                     
                                     
                                     
                                     
                                         public static void  addDescuentos(int ID_DES, String NOMBRE_DESC) {

         Connection reg = ConexionConBaseDatos.getConexion();      
   try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_descuentos (?,?)}");
     
                // enviar parametros
            cst.setInt(1, ID_DES);
            cst.setString(2,NOMBRE_DESC);

            
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
