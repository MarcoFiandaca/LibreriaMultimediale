
package libreria;


import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * 
 * Classe che implementa il FileChooser, cioè un oggetto grafico che permette di navigare il file system
 * e di selezionare uno o più file su cui eseguire una determinata operazione.
 * 
 * Nel nostro caso permette di selezionare il file multimediale da inserire all'interno della libreria.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class MyFileChooser extends JFileChooser{
/**
 * VARIABILI.
 * 
 * -filter -> Filtro che permette di selezionare file di un tipo specifico (MP3,MP4 o PDF)
 * -chooser -> istanza della classe JFileChooser utilizzato per la selezione del file mediante una finestra di dialogo.
 * -fileSelezionato -> file selezionato
 * 
 */
    private FileNameExtensionFilter filter;
    private JFileChooser chooser;
    private File fileSelezionato = null;
    
/**
 * Costruttore.
 * In base al tipo di Elemento da aggiungere crea il filtro appropriato per filtrare le estensioni dei file.
 * @param tipo -> indica in tipo di file multimediale che è possibile selezionare  
 */
    public MyFileChooser(int tipo){
        switch (tipo){
            case 1 : filter = new FileNameExtensionFilter("Brani musicali supportati","mp3"); break;//filtro mp3
            case 2 : filter = new FileNameExtensionFilter("Video supportati","mp4"); break;//filtro video
            case 3 : filter = new FileNameExtensionFilter("E-Book supportati","pdf"); break;//filtro pdf
        }
        chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
	int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       
	       fileSelezionato = chooser.getSelectedFile();
	       
	       }
    }
            
/**
 * Metodo che ritorna il file selezionato
 * @return fileSelezionato
 */
    public File getFile(){
        return fileSelezionato;
    }
       
        
}