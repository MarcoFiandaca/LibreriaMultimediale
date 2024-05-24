
package libreria;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * 
 * Classe che implementa un FolderChooser, cioè un FileChooser abilitato nella selezione di sole Folder(cartelle).
 * I file multimediali all'interno della folder selezionata hanno tutti lo stesso formato e vengono aggiunti alla libreria
 * mediante un istanza della classe AggiungiFile.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class FolderChooser extends JFileChooser{
/**
 * VARIABILI.
 * -chooser -> oggetto di tipo FileChooser utilizzato per la selezione dei file
 * -cartella -> folder contenente i file multimediali da inserire nella libreria
 * -files -> Array di File
 * -tipoElemento -> tipo dei file multimediali (MP3,MP4 o PDF)
 */    
    private JFileChooser chooser;
    private File cartella = null;
    private File [] files;
    private int tipoElemento;
    
    /**
     * Costruttore che crea un folder chooser.
     * In base al tipo di file che si vuole aggiungere, seleziona i file
     * della data estensione e li aggiunge alla libreria.
     * 
     * @param Tipo -> Tipo di file multimediale
     * @param Lib -> libreria dove salvare i file multimediali all'interno della folder selezionata
     * @param Modello -> modello per la visualizzazione dei file multimediali in forma tabellare
     * @param parent ->
     */
    public FolderChooser(int Tipo,MyLibreria Lib,MyTableModel Modello,java.awt.Frame parent){       
        this.tipoElemento=Tipo;
        chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String Estensione = "";
        
        switch(tipoElemento){
            case 1: Estensione=".mp3";
            break;
            case 2: Estensione=".mp4";
            break;
            case 3: Estensione=".pdf";
            break;
        }
        
        int ValRitorno = chooser.showOpenDialog(this);
        if(ValRitorno == JFileChooser.APPROVE_OPTION) {
            cartella = chooser.getSelectedFile();
	       files = cartella.listFiles();
               AggiungiFile Add;
               for(int i=0;i<files.length;i++)
                   if (Estensione.equals(getExtensionFile(files[i].getName())))
                       switch (Tipo){
                        case 1: Lib.creaBrano("", "", "" , "" , "",files[i].getAbsolutePath());  
                                Add = new AggiungiFile(Lib, Lib.size()-1, Modello, parent, true); 
                        break;
                        case 2: Lib.creaVideo("", "", "", "" ,files[i].getAbsolutePath()); 
                                Add = new AggiungiFile(Lib, Lib.size()-1, Modello, parent, true); 
                        break;
                        case 3: Lib.creaEBook("", "", "", "",files[i].getAbsolutePath()); 
                                Add = new AggiungiFile(Lib, Lib.size()-1, Modello, parent, true); 
                        break;
                        }
        }
        
    }
    
    
/**
 * Metodo che ritorna l'estensione di un file (es .pdf) oppure ritorna "cartella" se è una cartella.
 * @param nomeFile
 * @return "Cartellla"
 */
    private String getExtensionFile (String nomeFile){
        if (nomeFile.contains("."))
            return nomeFile.substring(nomeFile.lastIndexOf("."));
        else
            return"Cartella";
    }
    
    
}
