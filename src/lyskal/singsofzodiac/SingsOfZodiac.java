package lyskal.singsofzodiac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingsOfZodiac {
	private List<SingOfZodiac> _sings;
	final int SIZE_LIST = 12;

	public SingsOfZodiac() {
		_sings = new ArrayList<>(SIZE_LIST);
		readDataTromFile();
		addImages();
	}
	
	private void addImages() {
		File actual = new File("src//lyskal//singsofzodiac//information//img");
		for (SingOfZodiac singOfZodiac : _sings) {
			for (File f : actual.listFiles()) {
				String nameImg = f.getName().substring(0, (f.getName().length()-4));
				if(singOfZodiac.getName().equals(nameImg)){
					singOfZodiac.setImage(f.getPath());
					break;
				}
			}
		}
	}

	@SuppressWarnings("resource")
	private void readDataTromFile() {
		File actual = new File("src//lyskal//singsofzodiac//information//text");
		/*for (File f : actual.listFiles()) {
			System.out.println(f.getName());
		}
		*/
		for (File f : actual.listFiles()) {
			try {
				SingOfZodiac temp = new SingOfZodiac();
				BufferedReader fin = new BufferedReader(new FileReader(f.getAbsoluteFile()));
				String line;
				int counterLine = 0;
				while ((line = fin.readLine()) != null) {
					counterLine++;
					if (counterLine == 1) {
						temp.setName(line);
					} else if (counterLine == 2) {
						temp.setElement(line);
					} else if (counterLine == 3) {
						temp.setDate(line);
					} else {
						temp.setDescription(line+"\n");
					}
				}
				_sings.add(temp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public SingOfZodiac getSing(final int index) {
		return _sings.get(index);
	}
	
	public SingOfZodiac getSing(final String date) {
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(3, 5));
		
		for (SingOfZodiac singOfZodiac : _sings) {
			if(singOfZodiac.isDateInRange(day, month)) {
				return singOfZodiac;
			}
		}
		return null;
	}
}