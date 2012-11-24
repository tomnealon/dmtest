import java.io.IOException;


public class Loader {
	
    public static void main(String[] args) throws IOException {
        Loader.load();
     }
    
    public static void load() throws IOException {
    	Reader myReader = new Reader("Example.csv");
    	System.out.println(myReader.getCell(0, 3));
    	System.out.println(myReader.getCell(2, 4));
    	myReader.printRow(0);
    }
    
    
}
