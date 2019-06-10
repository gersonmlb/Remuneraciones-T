/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import BD_Docente.ModificarDocente;
import BD_Establecimiento.ModificarEstablecimiento;
import BD_Reportes.ConsultarReporte;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC PERSONAL RICH
 */
public class Control_Reportes {
    
    /*
    SELECT t_planilla.FECHA, t_docente.DNI_DOCENTE, t_docente.NOMBRE,t_docente.AP_PATERNO,AP_MATERNO,
    t_planilla.HABERES,t_planilla.DESCUENTOS,t_planilla.M_TOTAL,t_establecimiento.ESTABLECIMIENTO
    */
            DefaultTableModel modelo;
    //vector con los titulos de cada columna
                String[] titulosColumnas = { "Haberes","Monto",};   

    String[] titulosColumnasHaberes = { "Haberes","Monto",};   
    String[] titulosColumnasDescuentos = { "Descuentos","Monto",}; 
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
    
     public void buscarReportePorDocentePlanilla(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ModificarDocente.jtablereporte_pordocente.setModel(modelo);
            //ejecuta una consulta a la BD

            ReportePorDocente(parametroBusqueda);

    }
        public void buscarReportePorDocenteReporte(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ConsultarReporte.jTableListar.setModel(modelo);
            //ejecuta una consulta a la BD

            ReportePorDocente(parametroBusqueda);

    }
     public void buscarReportePorEstablecimientoPlanilla(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ModificarEstablecimiento.jtablereporte_porestablec.setModel(modelo);
            //ejecuta una consulta a la BD

            ReportePorEstablecimiento(parametroBusqueda);

    }
             Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    
    
                    
                            public void buscarReporteDescuento(String p1, String p2,String dni) {

        

            modelo = new DefaultTableModel(info, titulosColumnasDescuentos) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
                                ConsultarReporte.jtablaDescuento.setModel(modelo);
            //ejecuta una consulta a la BD

            ReporteDescuento(p1,p2,dni);

    } 
    
                                        public void ReporteDescuento(String P1,String P2,String dni){
                   conexion = ConexionConBaseDatos.getConexion();
                       ResultSet rs; 
   try {
            // Llamada al procedimiento almacenado
                                 conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call reporte_buscar_descuento(?,?,?)}");
                // Parametro 1 del procedimiento almacenado
            prcProcedimientoAlmacenado.setString(1,P1);
            prcProcedimientoAlmacenado.setString(2,P2);
            prcProcedimientoAlmacenado.setString(3,dni);
             double total=0;
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                              rs=prcProcedimientoAlmacenado.executeQuery();
                           while(rs.next()){
                        // int ID_DES = rs.getInt("ID_DES");     
                         String NOMBRE_DESC = rs.getString("NOMBRE_DESC");
                double MONTO_DES = rs.getDouble("MONTO_DES");
                     total=total+MONTO_DES;
     String NOMBRE = rs.getString("NOMBRE");
       String AP_PATERNO = rs.getString("AP_PATERNO");
       String AP_MATERNO = rs.getString("AP_MATERNO");
                               ConsultarReporte.nombre_docente=NOMBRE+" "+AP_PATERNO+" "+AP_MATERNO;
                Object[] info = {NOMBRE_DESC, MONTO_DES};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);
                           }
                            ConsultarReporte.total_descuentos=total;
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

             
             
             
             
             
             
             
       
                 
                 
           
                 
                            public void buscarReporteHaber(String p1, String p2,String dni) {

        

            modelo = new DefaultTableModel(info, titulosColumnasHaberes) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
                                ConsultarReporte.jtablahaber.setModel(modelo);
            //ejecuta una consulta a la BD

            ReporteHaber(p1,p2,dni);

    }      

                 
                 
                 
                 public void ReporteHaber(String P1,String P2,String dni){
                   conexion = ConexionConBaseDatos.getConexion();
                       ResultSet rs; 
   try {
            // Llamada al procedimiento almacenado
                                 conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call reporte_buscar_hab(?,?,?)}");
                // Parametro 1 del procedimiento almacenado
            prcProcedimientoAlmacenado.setString(1,P1);
            prcProcedimientoAlmacenado.setString(2,P2);
            prcProcedimientoAlmacenado.setString(3,dni);
            double total=0;
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                              rs=prcProcedimientoAlmacenado.executeQuery();
                           while(rs.next()){
                        // int ID_HAB = rs.getInt("ID_HAB");     
                         String NOMBRE_HAB = rs.getString("NOMBRE_HAB");
                double MONTO_HAB = rs.getDouble("MONTO_HAB");
                total=total+MONTO_HAB;
                  String NOMBRE = rs.getString("NOMBRE");
       String AP_PATERNO = rs.getString("AP_PATERNO");
       String AP_MATERNO = rs.getString("AP_MATERNO");
                               ConsultarReporte.nombre_docente=NOMBRE+" "+AP_PATERNO+" "+AP_MATERNO;
                            
                Object[] info = {NOMBRE_HAB, MONTO_HAB};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);
                           }
                               ConsultarReporte.total_haberes=total;
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
             
                 
                 
                 
                 
                 
                 
                 
                 
                 
 
             
                 
                 
     
             
             
    
 
    
    
        public void ReportePorEstablecimiento(String parametroBusqueda) {

                   conexion = ConexionConBaseDatos.getConexion();
                       ResultSet rs; 
   try {
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            
            // Llamada al procedimiento almacenado
       
                                 conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call reporte_buscar_por_establecimiento(?)}");
                // Parametro 1 del procedimiento almacenado
            prcProcedimientoAlmacenado.setString(1,parametroBusqueda);
             
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              
                              
                           while(rs.next()){
                         String FECHA = rs.getString("FECHA");
                String DNI_DOCENTE = rs.getString("DNI_DOCENTE");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                 String AP_MATERNO = rs.getString("AP_MATERNO");
                String HABERES = rs.getString("HABERES");
                String DESCUENTOS = rs.getString("DESCUENTOS");
                String M_TOTAL = rs.getString("M_TOTAL");
                String ESTABLECIMIENTO = rs.getString("ESTABLECIMIENTO");
                
                Object[] info = {FECHA, DNI_DOCENTE, NOMBRE, AP_PATERNO,AP_MATERNO,HABERES,DESCUENTOS,M_TOTAL,ESTABLECIMIENTO};

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void ReportePorDocente(String parametroBusqueda) {
            conexion = ConexionConBaseDatos.getConexion(); ResultSet rs; 
   try {
            conexion.setAutoCommit(false);            // Llamada al procedimiento almacenado
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call reporte_buscar_por_docente(?)}");
            prcProcedimientoAlmacenado.setString(1,parametroBusqueda);// Parametro 1 del procedimiento almacenado
            rs=prcProcedimientoAlmacenado.executeQuery();
                           while(rs.next()){// Definimos los tipos de los parametros de salida 
                         String FECHA = rs.getString("FECHA");
                String DNI_DOCENTE = rs.getString("DNI_DOCENTE");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                 String AP_MATERNO = rs.getString("AP_MATERNO");
                String HABERES = rs.getString("HABERES");
                String DESCUENTOS = rs.getString("DESCUENTOS");
                String M_TOTAL = rs.getString("M_TOTAL");
                String ESTABLECIMIENTO = rs.getString("ESTABLECIMIENTO");
                Object[] info = {FECHA, DNI_DOCENTE, NOMBRE, AP_PATERNO,AP_MATERNO,HABERES,DESCUENTOS,M_TOTAL,ESTABLECIMIENTO};
                modelo.addRow(info); //al modelo de la tabla le agrega una fila
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
}




