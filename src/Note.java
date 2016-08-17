import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

//Abstrakteklasse für Note

public abstract class Note {
	double note = 0;
	double anteil = 0;
	double noteAnteil = 0;
	String klassifikation = "";
    //Datumformatierung
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");;
	Date datum;
	
	public Note (double note, double anteil, String klassifikation , String  datum){
		// TODO Auto-generated method stub
		this.note = note;
		this.anteil = anteil;
		this.noteAnteil = this.note * this.anteil;
		this.klassifikation = klassifikation;



		try {
			this.datum = sdf.parse(datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*Getter für die Konstruktorvariabeln*/ 
	public double getNote(){
		return this.note;
	}
	
	public double getAnteil(){
		return this.anteil;
	}
	
	public  double getNoteAnteil(){
		return this.noteAnteil;
	}
	
	public String getKlassifikation(){
		return this.klassifikation;
	}
  
	
	public Date getDatum(){
	  
		return this.datum;
		
	}
	
	/*-------------------------------------*/
	
	
    /*Comperator für die Sortierung NotenDatum*/
    public static Comparator<Note> NotenDatumComparator = new Comparator<Note>() {

    	public int compare(Note s1, Note s2) {
    	   Date NotenName1 = s1.getDatum();
    	   Date NotenName2 = s2.getDatum();

           return NotenName1.compareTo(NotenName2);


        }};

	/*-------------------------------------*/
}
