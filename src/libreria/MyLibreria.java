

package libreria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * Classe che implementa una Lista che figura la nostra libreria multimediale.
 * Per implementare la lista si utilizza la Classe ArrayList che fornisce un'infrastruttura per la collection List.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 * 
 */

public class MyLibreria implements Serializable{
/**
 * VARIABILI.
 * 
 * -libreria -> ArrayList che contiene istanze della classe Elemento (cioè Brani multimediali, Ebook o Video)
 * -elemento -> oggetto che figura il file multimediale da inserire nell'arrayList
 */
    private ArrayList<Elemento> libreria;
    private Elemento elemento = null;
  
/**
 * COSTRUTTORE.
 * Crea un oggetto libreria di tipo ArrayList
 */
    public MyLibreria(){
        libreria = new ArrayList<Elemento>();
   
    }

/**
 * Metodo che implementa il metodo add() (già definito nell'interfaccia List)
 * @param temp -> elemento da inserire nella libreria
 */
    public void inserisci (Elemento temp){
        libreria.add(temp);
        
    }
    
/**
 * Metodo che ritorna la Libreria
 * @return libreria
 */  
    public ArrayList<Elemento> getLibreria(){
        return libreria;
    }
    
/**
 * Metodo che setta la libreria passatagli come parametro
 * @param libreria 
 */
    public void setLibreria(ArrayList<Elemento> libreria){
    
        this.libreria = new ArrayList<Elemento>();
        this.libreria = libreria;
        
    }
    
/**
 * Metodo che ritorna la dimensione della libreria
 * @return dimenzione Libreria
 */
    public int size(){
        return libreria.size();
    }
    
/**
 * Metodo che ritorna l'elemento in posizione Row contenuto all'interno della libreria 
 * @param row -> posizione 
 * @return Elemento 
 */
    public Elemento get(int row){
        return libreria.get(row);
    }

/**
 * Metodo che crea un branoMusicale e lo inserisce all'interno della libreria
 * @param titolo -> Titolo brano.
 * @param autore -> Autore brano.
 * @param anno -> Anno di uscita del brano.
 * @param durata -> Durata (in minuti) del brano.
 * @param frequenza -> Frequenza di campionamento del brano.
 * @param percorso -> pathname del brano.
 */
    public void creaBrano (String titolo, String autore, String anno, String durata, String frequenza, String percorso){
     elemento = new BranoMusicale(titolo, autore, anno, durata, frequenza, percorso);
     inserisci(elemento);
     elemento=null;
    }

/**
 * Metodo che crea un video e lo inserisce all'interno della libreria
 * @param titolo -> Titolo video.
 * @param autore -> Autore video.
 * @param anno -> Anno di uscita del video.
 * @param durata -> Durata (in minuti) del video.
 * @param percorso -> pathname del video.
 */
    public void creaVideo (String titolo, String autore, String anno, String durata, String percorso){
     elemento = new Video(titolo, autore, anno, durata, percorso);
     inserisci(elemento);
     elemento=null;
    }
    
/**
 * Metodo che crea un ebook e lo inserisce all'interno della libreria
 * @param titolo -> Titolo ebook.
 * @param autore -> Autore ebook.
 * @param anno -> Anno di uscita del ebook.
 * @param numPagine -> Numero pagine ebook
 * @param percorso -> pathname del ebook.
 */
    public void creaEBook(String titolo, String autore, String anno, String numPagine, String percorso){
    
        elemento = new EBook(titolo, autore, anno, numPagine, percorso);
        inserisci(elemento);
        elemento=null;
    }
    
/**
 * Metodo che implementa il metodo remove() (già definito nell'interfaccia List).
 * @param pos -> posizione dell'elemento da eliminare all'interno della lista
 */
    public void elimina(int pos){
        this.get(pos).stop();
        libreria.remove(pos);
    }
    
/**
 * Metodo che controlla se lista è vuota implementando il metodo isEmpty() definito nell'intefaccia List
 * @return 1 se è vuota, altrimenti 2
 */    
    public int IsEmpty(){
         if(this.libreria.isEmpty())
             return 1;
         else
             return 2;
    } 
}
