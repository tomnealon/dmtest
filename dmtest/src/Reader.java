import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Reader {
	private ArrayList<ArrayList> store = new ArrayList<ArrayList>();
	private boolean setEmptyToNull = true;

	public Reader(String fileName) throws IOException {
		BufferedReader CSVFile = new BufferedReader(new FileReader(fileName));
		String dataRow = CSVFile.readLine();
		while (dataRow != null) {
			String[] dataArray = dataRow.split(",");
			store.add(setTypeList(dataArray));
		    dataRow = CSVFile.readLine();
	    }
		CSVFile.close();
	}
	
	public ArrayList getRow(int row) {
		return store.get(row);
	}
	
	public Object getCell(int row, int col) {
		return store.get(row).get(col);
	}
	
	public void printRow(int row) {
		ArrayList dataArray = getRow(row);
		for (Object item:dataArray) {
			System.out.print(item + "\t");
		}
	}
	
	private boolean detectInt(String cell) {
		return cell.matches("-?\\d+(\\.\\d+)?");
	}
	
	private ArrayList setTypeList(String[] rowArray) {
		ArrayList typedRow = new ArrayList();
		int currentCol = 0;
		for (String item:rowArray) {
			if (detectInt(item)) {
				typedRow.add(Integer.parseInt(item));
			} else {
				typedRow.add(item);
			}
			currentCol++;
		}
		return typedRow;
	}

}
