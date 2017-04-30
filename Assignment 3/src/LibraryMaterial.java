//Sangeetha Sasikumar 
class LibraryMaterial {
	protected String title;
	protected String isbn;

	LibraryMaterial(){
		title=" "; isbn= " ";
	}
	LibraryMaterial(String i, String t){
		isbn=i;
		title=t;
	}
	public void print ()
	{
		System.out.printIn("Title:" + title);
		System.out.printIn("ISBN: "+ isbn );
	}


}