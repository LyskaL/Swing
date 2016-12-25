package lyskal.singsofzodiac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class SingsOfZodiac {
	private List<SingOfZodiac> _sings;
	final int SIZE_LIST = 12;

	private static final String FILE_PREFIX = "lyskal/singsofzodiac/information/";
	private static final String FILE_SUFFIX_TXT = ".txt";
	private static final String FILE_SUFFIX_IMG = ".png";

	public SingsOfZodiac() {
		_sings = new ArrayList<>(SIZE_LIST);
		readDataTromFile();
	}

	private void readDataTromFile() {
		for (String signName : SignOfZodiacNames.getAllSignNames()) {
			try (InputStream txtResource = ClassLoader.getSystemClassLoader().getResourceAsStream(FILE_PREFIX + signName + FILE_SUFFIX_TXT)) {
				SingOfZodiac temp = new SingOfZodiac();
				BufferedReader fin = new BufferedReader(new InputStreamReader(txtResource));
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
						temp.setDescription(line + "\n");
					}
				}
				temp.setImage(FILE_PREFIX + signName + FILE_SUFFIX_IMG);
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
			if (singOfZodiac.isDateInRange(day, month)) {
				return singOfZodiac;
			}
		}
		return null;
	}
}