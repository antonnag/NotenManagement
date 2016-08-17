import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Fach{

	int anzahlSchriftlichNoten;
	int anzahlMuendlichNoten;
	int anzahlAndereNoten;
	int anzahlVociNoten;
	

	double anteilSchriftlich = 0.8;
	double anteilMuendlich = 1 - anteilSchriftlich ;
	double anteilVoci = 1;
	
	String fachName;
   
    private List<Note> notenListe = new ArrayList<Note>();

	
	
	public Fach (String fachName){

		this.fachName = fachName;
	}
	
	public Fach (String fachName, double anteilSchriftlich, double anteilMuendlich){
		// TODO Auto-generated method stub
		//Konstruktor 2
		//Generiert ein Objekt mit custom Anteilwerten
		this.fachName = fachName;
		this.anteilSchriftlich = anteilSchriftlich;
		this.anteilMuendlich = anteilMuendlich;
	}

	/*Getter fuer Konstruktorvariabeln*/
	public String getFachName() {
		return this.fachName;
	}
	
	public void setNote(double note, String notenTyp, String datum) {
	//Erstellt spezfische Notenobjekte, je nach Typ		
		if (notenTyp.equalsIgnoreCase("S")){
		     notenListe.add(new SchriftlichNote(note,this.anteilSchriftlich,"S",datum));
		     anzahlSchriftlichNoten++;
		}
		
		if (notenTyp.equalsIgnoreCase("M")){
			 notenListe.add(new MuendlichNote(note,this.anteilMuendlich,"M",datum));
	         anzahlMuendlichNoten++;
	    }
		
    	if (notenTyp.equalsIgnoreCase("V")){
    	 	 notenListe.add(new VociNote(note,this.anteilVoci,"V",datum));
             anzahlVociNoten++;
        }
	}
   

	

	
	public List<Note> getNoteObjekte(){
		return getSortierteListe(notenListe);
	}
	/*-------------------------------------*/
	
	//Objektspezifische Listen ausgabe sortiert 
	public List<Note> getSchriftlicheNoteObjekte(){
	    List<Note> schriftlichNotenListe = new ArrayList<Note>();
	
	    for (Note element  : this.notenListe) {
			if(element instanceof SchriftlichNote){
				schriftlichNotenListe.add(element);	
			}
		}
	    
	    return getSortierteListe(schriftlichNotenListe);
	}
	
	public List<Note> getMuendlicheNoteObjekte(){
	    List<Note> muendlichNotenListe = new ArrayList<Note>();
	
	    for (Note element  : this.notenListe) {
			if(element instanceof MuendlichNote){
				muendlichNotenListe.add(element);	
			}
		}
	    return getSortierteListe(muendlichNotenListe);
	}	
	

	
	public List<Note> getVociNoteObjekte(){
	    List<Note> vociNotenListe = new ArrayList<Note>();
	
	    for (Note element  : this.notenListe) {
			if(element instanceof VociNote){
				vociNotenListe.add(element);	
			}
		}
		return getSortierteListe(vociNotenListe);
	}	
	/*------------------------------------*/
	
	public List<Note> getSortierteListe(List<Note> sortierteListe){
		 
	     Collections.sort(sortierteListe, Note.NotenDatumComparator);
		return sortierteListe;
	}

	public double getNotenSchnitt() {
		//Berechnet den gesamten Schnitt eins Faches
		double schnitt = 0;
        NotenBerechnungen notenFachObjekt = new NotenBerechnungen();
        schnitt = notenFachObjekt.notenSchnittInklAllerTypenNoten(getSchriftlicheNoteObjekte(), getMuendlicheNoteObjekte(), getVociNoteObjekte());
        return schnitt;
				
	}
	

	
	

}
