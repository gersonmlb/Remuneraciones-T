/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package About;

import Control_BD.ConexionConBaseDatos;
import java.awt.Component;
import java.sql.Connection;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import sistemadrea.MenuPrincipal;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor{
    
                public static void main(String[] args) {
       

    }
          //  conexion = ConexionConBaseDatos.getConexion();
    //private database db;
      public static Connection db = ConexionConBaseDatos.getConexion();
//conexion = ConexionConBaseDatos.getConexion();
    private String OldValue=""; //Valor antiguo de la celda
    private String NewValue=""; //valor nuevo de la celda
    private String NameColum="";//nombre de la columna
    private String ID="";// Llave del registro
    private JComponent component = new JTextField();


    public MyTableCellEditor(Connection db, String NameColumn)
    {
            this.db = db;
            this.NameColum = NameColumn;
    }

    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        OldValue = value.toString();//Toma valor de celda antes de cualquier modificación
        ID = table.getValueAt(row,0).toString();//obtiene el ID unico del registro
        ((JTextField)component).setText(value.toString());//coloca valor de la celda al JTextField
        return component;
    }

    @Override
    public boolean stopCellEditing() {
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
         //   if( !db.update( NameColum+"='"+NewValue+"' ", ID ) )
         //   {   //Si existe algun error al actualizar, escribe viejo valor en la celda
            //    JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                ((JTextField)component).setText(OldValue);
          //  }
        }
        return super.stopCellEditing();
    }
}
