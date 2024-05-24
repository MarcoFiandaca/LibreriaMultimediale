
package libreria;

import java.io.File;
import java.io.IOException;

/** 
 * 
 * 
 * Sottoclasse che implementa la struttua di un ebook (Tipo di file multimediale).
 * Questa classe estende la superclasse Elemento (contenente tutte le variabili e metodi comuni ai file multimediale).
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */


public class EBook extends Elemento{

    private NotificaFrame frameNotifica;
    private String numPagine;
	/**
         * Implementa la struttura di un E-Book.
         * 
         * @param titolo
         * @param autore
         * @param anno
         * @param npagine
         * @param percorso 
         */
    @SuppressWarnings("OverridableMethodCallInConstructor")
	public EBook(String titolo, String autore, String anno, String npagine, String percorso){
		super.setTitolo(titolo);
		super.setAutore(autore);
		super.setAnno(anno);
		this.setNPagine(npagine);
		super.setPercorso(percorso);
	}
	
/**
 * Metodo che imposta la variabile numPagine.
 * @param npagine inserita dall'utente nel costruttore 
 */
    public void setNPagine(String npagine){
        if(Elemento.isDoubleOrInt(npagine)==0)
            this.numPagine=npagine;
    }
	
/**
 * Metodo che ritorna il numero di pagine.
 * @return numPagine
 */
    public String getNPagine(){
	return numPagine;
    }
    
/**
 * Metodo che esegue un E-Book.
 * Usa l'applicazione di default per aprire e visualizzare un E-Book.
 */
    @Override
    public void play() {
        File file = new File(this.getPercorso());
            try {
                java.awt.Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                frameNotifica = new NotificaFrame("Errore apertura File Multimediale",this.frameNotifica,true);
            }
    }

/**
 * Metodo che ritorna il tipo di Elemento
 * @return PDF
 */
    @Override
    public String getTipo() {
        return "PDF";
    }


    @Override
    public void stop() {
       
    }
    
    
}
