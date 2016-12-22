package lyskal.singsofzodiac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SingsOfZodiac {
	private List<SingOfZodiac> _sings;
	final int SIZE_LIST = 12;

	SingsOfZodiac() {
		_sings = new ArrayList<>(SIZE_LIST);
		readDataTromFile();
	}

	@SuppressWarnings("resource")
	void readDataTromFile() {
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

	SingOfZodiac getSing (final int index) {
		return _sings.get(index);
	}
	
	Collection<SingOfZodiac> getSings () {
		return Collections.unmodifiableCollection(_sings);
	}
}