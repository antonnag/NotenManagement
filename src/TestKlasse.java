import java.util.List;


public class TestKlasse {
	static Fach Bio;
	static Fach De;
	static Fach Bio2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	LadenDerFacher();
	NotenProFachSetzenDe(De);
 	NotenProFachSetzenBio(Bio);
 	NotenProFachSetzenBio(Bio2);
 	 	
 	OuptuAufbereitungProFach(De);
 	OuptuAufbereitungProFach(Bio);
 	OuptuAufbereitungProFach(Bio2);
	
	} 
      
		
	
	 public static void LadenDerFacher(){
	       De = new Fach("SpracheMitVoci ", 0.7 ,0.3 );
	       Bio = new Fach("FachNormal");
	       Bio2 = new Fach("FachCustom",0.6,0.4);
	      

	 }
	
     public static void AusgabeAllerNoten(List<Note> tempList) {
      int i = 0;
      while (i < tempList.size()) {
    	  System.out.println(" " + tempList.get(i).getNote()) ;
     /*test
    	  System.out.println(" " + tempList.get(i).getNote() + " " +tempList.get(i).getDatum() + " " + tempList.get(i).getAnteil() + " " + tempList.get(i).getNoteAnteil()) ;
	*/	
			i++;
		}
     }
     
     public static void OuptuAufbereitungProFach(Fach tempFach){
        
    	 
    	 
    	 
         System.out.println("___________________________________");
    	     System.out.println("Fach : " + tempFach.getFachName());
	     if (tempFach.getSchriftlicheNoteObjekte().size()> 0){
    	     System.out.println("Schrift: ");
	         AusgabeAllerNoten(tempFach.getSchriftlicheNoteObjekte());      
	     }
	     
	     if (tempFach.getMuendlicheNoteObjekte().size()> 0){
	         System.out.println("Muendlich: ");
	         AusgabeAllerNoten(tempFach.getMuendlicheNoteObjekte());
	     }
	     if (tempFach.getVociNoteObjekte().size()> 0){
	         System.out.println("Voci: ");
	         AusgabeAllerNoten(tempFach.getVociNoteObjekte());
	     }
	     

	         System.out.println("Schnitt: ");
	         System.out.println(tempFach.getNotenSchnitt());
	   
	     System.out.println("___________________________________"); 


     }
     
     public static void OuptuAufbereitungAlleFach(Fach tempFach){
         
         System.out.println("___________________________________");
    	 System.out.println("Fach : " + tempFach.getFachName());
         AusgabeAllerNoten(tempFach.getNoteObjekte());
         System.out.println("___________________________________");
     }
     
     public static void NotenProFachSetzenDe(Fach tempFach) {
    
    	 tempFach.setNote(6, "s", "20171010") ;
    	 tempFach.setNote(5.8, "s", "20161010");   	 
    	 tempFach.setNote(5.5, "s", "20161010");
    	 
         tempFach.setNote(5, "m", "20161010");
         tempFach.setNote(4.5, "m", "20161010");
      
         tempFach.setNote(1, "v", "20161010");
         tempFach.setNote(5, "v", "20161010");
     }
      
     public static void NotenProFachSetzenBio(Fach tempFach) {
    	    
    	 tempFach.setNote(6, "s", "20161010");
    	 tempFach.setNote(5.8, "s", "20161010");   	 
    	 tempFach.setNote(5.5, "s", "20161010");
    	 
         tempFach.setNote(5, "m", "20161010");
         tempFach.setNote(4.5, "m", "20161010");

     }
      



      
      

}
