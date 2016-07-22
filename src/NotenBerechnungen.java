import java.text.NumberFormat;
import java.util.List;


public class NotenBerechnungen {
    
	//Berechnet den Mittelwert von allen Noten von einer Notenliste
	public double NotenMittelwertBerechnen(List<Noten> notenSimpleListe){
	
		double SumNoten = 0;
	      double tempMittelwert = 0;
	      
	      int i = 0;
	      while (i < notenSimpleListe.size()) {
	    	  SumNoten = SumNoten + notenSimpleListe.get(i).getNoteAnteil();
				i++;
			}
	      tempMittelwert = SumNoten / notenSimpleListe.size();
		  return tempMittelwert;

	}
	
	public double NotenSchnittInklAllerTypenNoten(List<Noten> n1, List<Noten> n2, List<Noten> n3 ){
    //  Berechnet den gesamten Notenschnitt eines Faches, dabei müssen alle NotenListen Typen (Schriftlich, Mündlich, Voci) als Parameter mitgegeben werden 
		double avgS = 0; double avgM = 0; double avgV = 0;
		double avgTotal = 0;	
	    //Instanz um double Werte zu runden
		NumberFormat n = NumberFormat.getInstance();
	    n.setMaximumFractionDigits(3);

		
        if(n1.size() > 0){            	
       	//Verarbeiten der Noten aus der der NotenListe <Schriftlich>
        	//Berücksichtigen der Voci Noten. Mittelwert aller Voci Noten zählt wie eine ganze schriftlich Note
        	if(n3.size() > 0){
   			 ;  		
   	         //Runden des Voci Mittelwertes auf 3 Kommastellen
   		     avgV = Double.parseDouble(n.format(NotenMittelwertBerechnen(n3)));
   		     //Voci Mittelwerte wird in die schriftlich Notenliste hinzugefügt
   	    	 n1.add(new VociNote(avgV,n1.get(1).getAnteil(),"V","99999999"));
   		    }
            //Runden des schriftlichen Mittelwertes auf 3 Kommastellen
        	avgS = Double.parseDouble(n.format(NotenMittelwertBerechnen(n1)));	
        
        }
        ///Verarbeiten der Noten aus der der NotenListe <Muendlich>
	    if(n2.size() > 0){ 	
	    	 //Runden des muenldichen Mittelwertes auf 3 Kommastellen
 			  avgM = Double.parseDouble(n.format(NotenMittelwertBerechnen(n2)));	
 		     }
     
        //Runden des muenldichen Mittelwertes auf 2 Kommastellen
	    n.setMaximumFractionDigits(2);
		avgTotal = Double.parseDouble(n.format(avgS + avgM));
		
		return avgTotal;	
	}
	
}
