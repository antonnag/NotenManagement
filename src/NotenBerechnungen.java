import java.text.NumberFormat;
import java.util.List;


public class NotenBerechnungen {
 
	double mittelwertS = 0; double mittelwertM = 0; double mittelwertV = 0;
	double mittelwertTotal = 0;	
	NumberFormat nummerFormat;
	
	//Berechnet den Mittelwert von allen Note von einer Notenliste
	public double NotenMittelwertBerechnen(List<Note> notenSimpleListe){
	
		  double SummenNoten = 0;
	      double temporäreMittelwert = 0;
	      
	      int i = 0;
	      while (i < notenSimpleListe.size()) {
	    	  SummenNoten = SummenNoten + notenSimpleListe.get(i).getNoteAnteil();
				i++;
			}
	      temporäreMittelwert = SummenNoten / notenSimpleListe.size();
		  return temporäreMittelwert;

	}
	
	public double notenSchnittInklAllerTypenNoten(List<Note> listeSchrieftlich, List<Note> listeMuendlich, List<Note> listeVoci ){
    //  Berechnet den gesamten Notenschnitt eines Faches, dabei müssen alle NotenListen Typen (Schriftlich, Mündlich, Voci) als Parameter mitgegeben werden 

	    //Instanz um double Werte zu runden

		nummerFormat = NumberFormat.getInstance();
		nummerFormat.setMaximumFractionDigits(3);

		berechneneMittelWertS(listeSchrieftlich,listeVoci);
		berechneneMittelWertM(listeMuendlich);
		
	    //Runden des muenldichen Mittelwertes auf 2 Kommastellen
	    nummerFormat.setMaximumFractionDigits(2);
		mittelwertTotal = Double.parseDouble(nummerFormat.format(mittelwertS + mittelwertM));
		return mittelwertTotal;	
	}
	
	private void  berechneneMittelWertS(List<Note> listeSchrieftlich, List<Note> listeVoci ){
	  if(listeSchrieftlich.size() > 0){            	
       	//Verarbeiten der Note aus der der NotenListe <Schriftlich>
        	//Berücksichtigen der Voci Note. Mittelwert aller Voci Note zählt wie eine ganze schriftlich Note
        	if(listeVoci.size() > 0){
   			 ;  		
   	         //Runden des Voci Mittelwertes auf 3 Kommastellen
   		     this.mittelwertV = Double.parseDouble(nummerFormat.format(NotenMittelwertBerechnen(listeVoci)));
   		     //Voci Mittelwerte wird in die schriftlich Notenliste hinzugefügt
   		     listeSchrieftlich.add(new VociNote(this.mittelwertV,listeSchrieftlich.get(1).getAnteil(),"V","99999999"));
   		    }
            //Runden des schriftlichen Mittelwertes auf 3 Kommastellen
        	this.mittelwertS = Double.parseDouble(nummerFormat.format(NotenMittelwertBerechnen(listeSchrieftlich)));	
        }
	}
	
	private void berechneneMittelWertM(List<Note> listeMuendlich ){	
    ///Verarbeiten der Note aus der der NotenListe <Muendlich>
    if(listeMuendlich.size() > 0){ 	
    	 //Runden des muenldichen Mittelwertes auf 3 Kommastellen
			  this.mittelwertM = Double.parseDouble(this.nummerFormat.format(NotenMittelwertBerechnen(listeMuendlich)));	

    		}   
	}
    	
	
}
