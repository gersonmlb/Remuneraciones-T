/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

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
public class Control_Doc_descuentos {
              DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"ID_DOC_DESC", "DNI_DOC","ID_DES","FECHA","MONTO_DES"};
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
        ejecutarGETdescuento();
        
     }
                                  
                                     public void ejecutarGETdescuento() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                           try{
                                // creamos la Conexion
                                 conexion.setAutoCommit(false);
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_doc_des()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              int descuentos=0;
                              
                           while(rs.next()){
                            descuentos = rs.getInt("ID_DOC_DESC");    
                           }
                                  
                                BD_HAB_DES.Agregar_hab_des.idDescu_doc=descuentos;
                               
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
       

                                           
                                     
                                     
                                     
                                         public static void  adddescuentos(int ID_DOC_DESC, String DNI_DOC,int ID_DES,String fecha,double monto) {

         Connection reg = ConexionConBaseDatos.getConexion();      
   try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_doc_descuento  (?,?,?,?,?)}");
     
                // enviar parametros
            cst.setInt(1, ID_DOC_DESC);
            cst.setString(2,DNI_DOC);
                cst.setInt(3, ID_DES);
            cst.setString(4,fecha);
            cst.setDouble(5,monto);
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
