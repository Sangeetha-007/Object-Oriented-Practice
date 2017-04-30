//Sangeetha Sasikumar
public class DVD extends LibraryMaterial{
	private String MainActor;
	
	public DVD(String a, String b, String c){
		isbn=a;
		title=b;
		MainActor=c;
	}
	
	 public String getActor () {return MainActor;}
	 public String getTitle() {return title;}
	 public String getIsbn() {return isbn;}
}
