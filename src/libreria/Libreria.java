

package libreria;

/**
 * 
 * 
 * Classe contenente il main che implementa la libreria.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */


public class Libreria {

/**
 * Crea e mostra la libreria.
 * @param args the command line arguments
 */
    public static void main(String[] args) {
        
        MyLibreria lib = new MyLibreria();
        MyNewFrame prova = new MyNewFrame(lib);
        prova.setVisible(true);

 
    }
    
}
