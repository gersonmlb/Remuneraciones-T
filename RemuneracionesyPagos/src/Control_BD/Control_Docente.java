/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import BD_Docente.ModificarDocente;
import BD_Establecimiento.ModificarEstablecimiento;
import BD_HAB_DES.Agregar_hab_des;

import BD_Reportes.ConsultarReporte;
import static BD_Reportes.ConsultarReporte.jtablahaber;
import static BD_Reportes.ConsultarReporte.jTableListar;
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
public class Control_Docente {
    
    
        DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = { "DNI_DOCENTE", "ID_ESTABLECIMIENTO", "COD_MOD","TIPO","CUENTA_BANCARIA","NOMBRE","AP_PATERNO","AP_MATERNO"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
    
        public void ModificarDocente(String DNI_DOCENTE,
                String ID_ESTABLECIMIENTO,String COD_MOD,String TIPO,
                String CUENTA_BANCARIA,String NOMBRE,String AP_PATERNO,String AP_MATERNO) {

    
        try {
             conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            
            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update t_docente set "
                + " COD_MOD ='" + COD_MOD + "' "+ ", TIPO ='" + TIPO + "'"+ ", CUENTA_BANCARIA ='" + CUENTA_BANCARIA + "'"+ " , NOMBRE ='" + NOMBRE + "' , AP_PATERNO ='" + AP_PATERNO + "' , AP_MATERNO ='" + AP_MATERNO + "'  where DNI_DOC='" + DNI_DOCENTE+"'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe docente de un codigo "+DNI_DOCENTE);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }//cierra metodo modificarCliente

     public static void  addDocente(String DNI_DOCENTE, String ID_ESTABLECIMIENTO,
             String COD_MOD,String TIPO,String CUENTA_BANCARIA,String NOMBRE,String AP_PATERNO,
             String AP_MATERNO) {

         Connection reg = ConexionConBaseDatos.getConexion();//conecccion a la base de datos
   try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_docente(?,?,?,?,?,?,?,?)}");

                // definimos los parametros de entrada
            
            cst.setString(1,DNI_DOCENTE);
            cst.setString(2,ID_ESTABLECIMIENTO);
            cst.setString(3, COD_MOD);
            cst.setString(4, TIPO);
            cst.setString(5,CUENTA_BANCARIA);
            cst.setString(6,NOMBRE);
            cst.setString(7, AP_PATERNO);
            cst.setString(8, AP_MATERNO);
               
                   System.out.println("ejecutada: "+ID_ESTABLECIMIENTO);
                // Ejecuta el procedimiento almacenado
                cst.execute();
                
                // Se obtienen la salida del procedimineto almacenado


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
     
     

         ///////////
               public void CargarDocenteReporte(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                   ConsultarReporte.jTableListar.setModel(modelo);


        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaDocente();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
            public void CargarDocenteconsultadocente(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                ModificarDocente.jTableListarDocente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaDocente();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
                   public void CargarDocente_hab_des(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                       Agregar_hab_des.jTableListarDocente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaDocente();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }     
            
            
            
                       public void CargarDocenteconsultaReportedocente(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                           ModificarEstablecimiento.jTableListarEstablecimiento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaDocente();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
            
             Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

                     public void ejecutarConsultaTodaTablaDocente() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                        try{
                                // creamos la Conexion
                           
                                 conexion.setAutoCommit(false);
                                
                             
                                
                                /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_docente()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              
                              
                           while(rs.next()){
                     
                String DNI_DOCENTE = rs.getString("DNI_DOC");
                String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_MOD = rs.getString("COD_MOD");
                 String TIPO = rs.getString("TIPO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                String AP_MATERNO = rs.getString("AP_MATERNO");
//                BD_Planilla.AgregarPlanilla.ultimo_numero_id_planilla=
//                BD_Planilla.AgregarPlanilla.ultimo_numero_id_planilla;
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = { DNI_DOCENTE, ID_ESTABLECIMIENTO,COD_MOD,TIPO, CUENTA_BANCARIA, NOMBRE,AP_PATERNO,AP_MATERNO};

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
                     
    
    
    /////////
    public void buscarDocenteParaAgregarReporte(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ConsultarReporte.jTableListar.setModel(modelo);
            //ejecuta una consulta a la BD
                       parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroPlanilla(parametroBusqueda);

    }
        public void buscarDocentePordni(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ConsultarReporte.jtablahaber.setModel(modelo);
            //ejecuta una consulta a la BD
                  
            buscarRegistroPlanillapordni(parametroBusqueda);

    }
     
    
    public void buscarDocenteParaConsultadocente(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ModificarDocente.jTableListarDocente.setModel(modelo);
            //ejecuta una consulta a la BD
                       parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroPlanilla(parametroBusqueda);

    }
    
        public void buscarDocenteParahab_des(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            Agregar_hab_des.jTableListarDocente.setModel(modelo);
            //ejecuta una consulta a la BD
                       parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroPlanilla(parametroBusqueda);

    }
      public void buscarDocenteParaConsultareporte(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ConsultarReporte.jTableListar.setModel(modelo);
            //ejecuta una consulta a la BD
                       parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroPlanilla(parametroBusqueda);

    }

      
          public void buscarRegistroPlanillapordni(String parametroBusqueda) {
           conexion = ConexionConBaseDatos.getConexion();ResultSet rs; 
   try {   conexion.setAutoCommit(false); // Llamada al procedimiento almacenado
        CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call docente_buscar_dni  (?)}");
        prcProcedimientoAlmacenado.setString(1, parametroBusqueda);// Parametro 1 del procedimiento almacenado
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                rs=prcProcedimientoAlmacenado.executeQuery();
                while(rs.next()){
                String DNI_DOCENTE = rs.getString("DNI_DOC");
                String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_MOD = rs.getString("COD_MOD");
                 String TIPO = rs.getString("TIPO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                String AP_MATERNO = rs.getString("AP_MATERNO");
                Object[] info = { DNI_DOCENTE, ID_ESTABLECIMIENTO,COD_MOD,TIPO, CUENTA_BANCARIA, NOMBRE,AP_PATERNO,AP_MATERNO};
                modelo.addRow(info);  //al modelo de la tabla le agrega una fila
                           }conexion.commit();
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
      
      
      
      
      
      
      
      
      
      
    public void buscarRegistroPlanilla(String parametroBusqueda) {

                   conexion = ConexionConBaseDatos.getConexion();
                       ResultSet rs; 
   try {
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            
            // Llamada al procedimiento almacenado
       
                                 conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call docente_buscar  (?)}");
                // Parametro 1 del procedimiento almacenado
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);
             
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              
                              
                           while(rs.next()){
                String DNI_DOCENTE = rs.getString("DNI_DOC");
                String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_MOD = rs.getString("COD_MOD");
                 String TIPO = rs.getString("TIPO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                String AP_MATERNO = rs.getString("AP_MATERNO");
                
                Object[] info = { DNI_DOCENTE, ID_ESTABLECIMIENTO,COD_MOD,TIPO, CUENTA_BANCARIA, NOMBRE,AP_PATERNO,AP_MATERNO};

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
    
}