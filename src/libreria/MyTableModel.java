

package libreria;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * Classe che implementa il modello di visulizzazione in forma tabellare degli elementi della libreria mostrando
 * i campi comuni dei file multimediali
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class MyTableModel extends AbstractTableModel{
    private MyLibreria lib;
    private final String [] intestazione ={"Tipo","Titolo","Autore","Anno"};
    
    /**
     * Costruttore. 
     * @param lib -> libreria 
     */
    public MyTableModel (MyLibreria lib){
            this.lib=lib;
      
    }

    /**
     * Metodo che ritorna il numero di righe.
     * @return lib.size() -> dimensione libreria (cioè quanti elementi contiene)
     */
    @Override
    public int getRowCount() {
    
        return lib.size();
    }

    /**
     * metodo che ritorna il numero di colonne.
     * @return intestazione.lenght -> dimensione del vettore intestazione
     */
    @Override
    public int getColumnCount() {
    
        return intestazione.length;
    }

    /**
     * Metodo che riempie i campi speficiati dalle colonne di un elemento in una posione specifica .
     * 
     * @param row -> riga
     * @param col -> colonna
     * @return null
     */
    @Override
    public Object getValueAt(int row, int col) {
        
        Elemento temp = lib.get(row);
        
        switch (col){
            case 0 : return temp.getTipo();
            case 1 : return temp.getTitolo();
            case 2 : return temp.getAutore();
            case 3 : return (temp.getAnno());
        }
        return null;
    }
    
    /**
     * Metodo booleano che ritorna se una cella è modificabile
     * @param row
     * @param col
     * @return false -> non editabile
     */
    @Override
    public boolean isCellEditable(int row, int col) { 
        
        return false; 
    }
    
    /**
     * metodo che ritorna il nome delle colonne
     * @param col -> colonna
     * @return Intestazione[col] -> vettore di stringhe contenente i nomi delle colonne
     */
    @Override
    public String getColumnName (int col){
        
        return (intestazione[col]);
        }
    
    /**
     * Metodo che aggiorna la tabella.
     * Notifica a tutti i listeners (interfacce che contengono i metodi relativi al tipo di evento che si vuole intercettare) che
     * i valori delle righe della tabella possono essere cambiati e ridisegna la tabella da zero
     * (mantenendo invariata la sua struttura).
     
     */
    public void aggiorna(){
    this.fireTableDataChanged();
    }
    
}
