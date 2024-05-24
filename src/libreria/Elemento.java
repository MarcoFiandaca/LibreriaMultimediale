

package libreria;

import java.io.Serializable;

/**
 * 
 * 
 * La classe elemento implementa un generico file multimediale. 
 * Essa è astratta (non istanziabile) e contiene variabili e metodi comuni ai tre tipi di file multimediali istanziabili.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */
public abstract class Elemento implements Serializable{

/**
 * VARIABILI (dichiarate protected per essere accessibili solo alle sottoclassi di Elemento).
 * -titolo -> titolo del file multimediale.
 * -autore -> autore del file multimediale.
 * -percorso -> pathname del file multimediale.
 * -anno -> anno di uscita del file multimediale
 */
    protected String titolo, autore, percorso, anno;
    
    
/**
 * Metodo che imposta la variabile titolo del file multimediale
 * @param titolo inserito dall'utente 
 */
    public void setTitolo(String titolo){
	this.titolo=titolo;
    }
	
    
/**
 * Metodo che imposta la variabile autore del file multimediale
 * @param autore inserito dall'utente 
 */
    public void setAutore(String autore){
	this.autore=autore;
    }

/**
 * Metodo che imposta la variabile percorso del file multimediale
 * @param percorso ottenuto mediante il FileChooser
 */
    public void setPercorso(String percorso){
	this.percorso=percorso;
    }
	

        
/**
 * Verifica se una stringa è un numero (double o int).
 * @param num
 * @return -1 se non è una stringa valida, 0 se è un int, 1 se è un double
 */
    public static int isDoubleOrInt(String num){
        try{
            Integer.parseInt(num);
            return 0;
        }catch(NumberFormatException e){
            try{
                Double.parseDouble(num);
                return 1;
            }catch(NumberFormatException e2){
                return -1;
            }
        }
    }       
/**
 * Metodo che imposta la variabile anno del file multimediale
 * @param anno inserito dall'utente 
 */
    public void setAnno(String anno){
        if (isDoubleOrInt(anno)==0)
            this.anno=anno;
    }
    
/**
 * Metodo che ritorna il titolo del file multimediale
 * @return titolo
 */	
    public String getTitolo(){
	return titolo;
    }
	
    
/**
 * Metodo che ritorna l'autore del file multimediale 
 * @return autore
 */
    public String getAutore(){
	return autore;
    }
    
/**
 * Metodo che ritorna il percorso del file multimediale 
 * @return percorso
 */  
    public String getPercorso(){
	return percorso;
    }

/**
 * Metodo che ritorna l'anno del file multimediale 
 * @return autore
 */
    public String getAnno(){
	return anno;
    }
        
/**
 * Metodi astratti, cioè metodi che vanno implementati dalle sottoclassi di Elemento
 * @return 
 */
    abstract public  String getTipo();
    abstract public void play();
    abstract public void stop();

     
}