package BD_HAB_DES;
import Descuentos.*;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class MyTableCellEditor_Descuentos extends AbstractCellEditor implements TableCellEditor{

    private databaseDescuentos db;
    private String OldValue=""; //Valor antiguo de la celda
    private String NewValue=""; //valor nuevo de la celda
    private String NameColum="";//nombre de la columna
    private String ID_DOC_HAB="";// Llave del registro
    private String DNI_DOC="";// Llave del DOCENTE
    private JComponent component = new JTextField();

    public MyTableCellEditor_Descuentos(databaseDescuentos db, String NameColumn)
    {
            this.db = db;
            this.NameColum = NameColumn;
    }

    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        OldValue = value.toString();//Toma valor de celda antes de cualquier modificación
        ID_DOC_HAB = table.getValueAt(row,0).toString();//obtiene el ID unico del registro
           DNI_DOC = table.getValueAt(row,1).toString();//obtiene el ID unico del registro
        ((JTextField)component).setText(value.toString());//coloca valor de la celda al JTextField
        return component;
    }

    @Override
    public boolean stopCellEditing() {
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
            if( !db.update( NameColum+"='"+NewValue+"' ", ID_DOC_HAB,DNI_DOC ) )
            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                ((JTextField)component).setText(OldValue);
            }
        }
        return super.stopCellEditing();
    }
}
