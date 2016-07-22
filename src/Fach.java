import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Fach{

	int anzahlSchriftlichNoten;
	int anzahlMuendlichNoten;
	int anzahlAndereNoten;
	int anzahlVociNoten;
	
	//Standard anteil werte
	double anteilSchriftlich = 0.8;
	double anteilMuendlich = 1 - anteilSchriftlich ;
	double anteilVoci = 1;
	
	String fachName;
   
    private List<Noten> notenListe = new ArrayList<Noten>();

	
	
	public Fach (String fachName){
		//Konstruktor 1
		//Generiert ein Objekt mit standard Anteilwerten
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
   
	/*Getter fuer Konstruktorvariabeln*/
	public String getFachName() {
		return this.fachName;
	}
	
	public double getNote(Noten noteObjekt){
		return  noteObjekt.getNote();
	}
	
	public double getAnteil(Noten noteObjekt){
		return noteObjekt.getAnteil();
	}
	
	public double getNoteAnteil(Noten noteObjekt){
		return noteObjekt.getNoteAnteil();
	}
	
	public String getNoteDatum(Noten noteObjekt){
		return noteObjekt.getDatum();
	}
	
	
	public List<Noten> getNoteObjekte(){
		return getSortierteListe(notenListe);
	}
	/*-------------------------------------*/
	
	//Objektspezifische Listen ausgabe sortiert 
	public List<Noten> getSchriftlicheNoteObjekte(){
	    List<Noten> schriftlichNotenListe = new ArrayList<Noten>();
	
	    for (Noten element  : this.notenListe) {
			if(element instanceof SchriftlichNote){
				schriftlichNotenListe.add(element);	
			}
		}
		return schriftlichNotenListe;
	}
	
	public List<Noten> getMuendlicheNoteObjekte(){
	    List<Noten> muendlichNotenListe = new ArrayList<Noten>();
	
	    for (Noten element  : this.notenListe) {
			if(element instanceof MuendlichNote){
				muendlichNotenListe.add(element);	
			}
		}
		return muendlichNotenListe;
	}	
	

	
	public List<Noten> getVociNoteObjekte(){
	    List<Noten> vociNotenListe = new ArrayList<Noten>();
	
	    for (Noten element  : this.notenListe) {
			if(element instanceof VociNote){
				vociNotenListe.add(element);	
			}
		}
		return getSortierteListe(vociNotenListe);
	}	
	/*------------------------------------*/
	
	public List<Noten> getSortierteListe(List<Noten> sortierteListe){
		 
	     Collections.sort(sortierteListe, Noten.NotenDatumComparator);
		return sortierteListe;
	}

	public double getNotenSchnitt() {
		//Berechnet den gesamten Schnitt eins Faches
		double schnitt = 0;
        NotenBerechnungen notenFachObjekt = new NotenBerechnungen();
        schnitt = notenFachObjekt.NotenSchnittInklAllerTypenNoten(getSchriftlicheNoteObjekte(), getMuendlicheNoteObjekte(), getVociNoteObjekte());
        return schnitt;
				
	}
	



}
