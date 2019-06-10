package Control_BD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import BD_Docente.AgregarDocente;
import BD_Establecimiento.ModificarEstablecimiento;
import Control_BD.CerrarConexiones;
import Control_BD.ConexionConBaseDatos;
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
public class Control_Establecimiento {
    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"ID_ESTABLECIMIENTO", "COD_ESTABLECIMIENTO", "ESTABLECIMIENTO", "SEDE_UGEL"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
            public void ModificarEstablecimiento(String ID_ESTABLECIMIENTO,String COD_ESTABLECIMIENTO,
                    String ESTABLECIMIENTO,String SEDE_UGEL) {

    
        try {
             conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            
            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update t_establecimiento set COD_ESTABLECIMIENTO ='" + COD_ESTABLECIMIENTO + "', "
                + " ESTABLECIMIENTO ='" + ESTABLECIMIENTO + "' "+ ", SEDE_UGEL ='" + SEDE_UGEL + "'  where ID_ESTAB ='" + ID_ESTABLECIMIENTO+"'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe establecimiento de un codigo "+ID_ESTABLECIMIENTO);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }//cierra metodo modificarCliente
    

     public static void  addEstablecimiento(int ID_ESTABLECIMIENTO, String COD_ESTABLECIMIENTO,
             String ESTABLECIMIENTO,String SEDE_UGEL) {

         Connection reg = ConexionConBaseDatos.getConexion();      
   try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_establecimiento  (?,?,?,?)}");
     
                // enviar parametros
            cst.setInt(1, ID_ESTABLECIMIENTO);
            cst.setString(2,COD_ESTABLECIMIENTO);
            cst.setString(3,ESTABLECIMIENTO);
            cst.setString(4, SEDE_UGEL);
            
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
     
     
         public void CargarDocenteconsultaReporteEstablecimiento(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
             ModificarEstablecimiento.jTableListarEstablecimiento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEstablecimiento();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
             
             
             
             
             
         public void CargarEstablecimientoDocente(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
             AgregarDocente.SeleccionarEstablecimiento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEstablecimiento();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
             Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

                     public void ejecutarConsultaTodaTablaEstablecimiento() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                        try{
                                // creamos la Conexion
                           
                                 conexion.setAutoCommit(false);
                                
                             
                                
                                /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_establecimiento()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              
                              
                           while(rs.next()){
                           String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_ESTABLECIMIENTO = rs.getString("COD_ESTABLECIMIENTO");
                String ESTABLECIMIENTO = rs.getString("ESTABLECIMIENTO");
                String SEDE_UGEL = rs.getString("SEDE_UGEL");


                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {ID_ESTABLECIMIENTO, COD_ESTABLECIMIENTO, ESTABLECIMIENTO,SEDE_UGEL};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);
                                  
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
                  //           Control_Establecimiento cc = new Control_Establecimiento();
      public void buscarEstablecimientoParaAgregarDocente(String parametroBusqueda) {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            AgregarDocente.SeleccionarEstablecimiento.setModel(modelo);
            //ejecuta una consulta a la BD
            parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroEstablecimiento(parametroBusqueda);

    }
    public void buscarRegistroEstablecimiento(String parametroBusqueda) {

              conexion = ConexionConBaseDatos.getConexion();
                       ResultSet rs; 
   try {
       
                                 conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call establecimiento_buscar  (?)}");
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);

                              rs=prcProcedimientoAlmacenado.executeQuery();                     
                           while(rs.next()){
                           String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_ESTABLECIMIENTO = rs.getString("COD_ESTABLECIMIENTO");
                String ESTABLECIMIENTO = rs.getString("ESTABLECIMIENTO");
                String SEDE_UGEL = rs.getString("SEDE_UGEL");
             //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {ID_ESTABLECIMIENTO, COD_ESTABLECIMIENTO, ESTABLECIMIENTO,SEDE_UGEL};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);
                                  
                           }
                                  
                                conexion.commit();
                                
                             
                                
                        }
                         
         

   
          catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
}                    
                    
    public void buscarDocenteParaConsultaestalecimiento(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ModificarEstablecimiento.jTableListarEstablecimiento.setModel(modelo);
            //ejecuta una consulta a la BD
           parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroEstablecimiento(parametroBusqueda);

    }
    
                                  public void CargarGETestablecimiento(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //ejecuta una consulta a la BD
        ejecutarGETestablecimiento();
        
     }
                                  
                                     public void ejecutarGETestablecimiento() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                           try{
                                // creamos la Conexion
                           
                                 conexion.setAutoCommit(false);
                                
                             
                                
                                /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_establecimiento()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              int establecimiento=0;
                              
                           while(rs.next()){
                            establecimiento = rs.getInt("ID_ESTABLECIMIENTO");

                                  
                           }
                                  
                                BD_Establecimiento.AgregarEstablecimiento.ultim0_establecimiento=establecimiento;
                               
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
          
 }

