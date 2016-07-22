import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

//Abstrakteklasse für Noten

public abstract class Noten {
	double note = 0;
	double anteil = 0;
	double noteAnteil = 0;
	String klassifikation = "";
    //Datumformatierung
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");;
	Date datum;
	
	public Noten (double note, double anteil, String klassifikation , String  datum){
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
	
	public String getDatum(){
		String datumString = sdf.format(datum);
		return datumString;
	}
	/*-------------------------------------*/
	
	
    /*Comperator für die Sortierung NotenDatum*/
    public static Comparator<Noten> NotenDatumComparator = new Comparator<Noten>() {

	public int compare(Noten s1, Noten s2) {
	   String NotenName1 = s1.getDatum().toUpperCase();
	   String NotenName2 = s2.getDatum().toUpperCase();

       return NotenName1.compareTo(NotenName2);


    }};
	/*-------------------------------------*/
}
