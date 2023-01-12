
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

// créer un modèle de tableau pour afficher les images des contacts dans jtable
public class MyModel extends AbstractTableModel{
    
    private String[] columns;
    private Object[][] rows ;
    
    public MyModel(){}
    
    public MyModel(Object[][] data ,  String[] columnsName ){
        
        this.columns = columnsName ;
        this.rows = data ;
    }
    
    public Class getColumnClass(int col){
        
        // l’index de la colonne de l’image est 7
        if(col == 7){ return Icon.class ;}
        else{
            return getValueAt(0,col).getClass();
        }
    
    }

    @Override
    public int getRowCount() {
        
        return this.rows.length ;
       // throw new UnsupportedOperationException("Not supported yet."); //Pour modifier le corps des méthodes générées, choisissez Outils | Modèles.
    }

    @Override
    public int getColumnCount() {
       
        return this.columns.length ;
        //throw new UnsupportedOperationException("Not supported yet."); //Pour modifier le corps des méthodes générées, choisissez Outils | Modèles.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return this.rows[rowIndex][columnIndex] ;
        //throw new UnsupportedOperationException("Not supported yet."); //Pour modifier le corps des méthodes générées, choisissez Outils | Modèles.
    }
    
    @Override
    public String getColumnName(int col){
        
        return this.columns[col];
    }
    
}
