package lyskal.singsofzodiac;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class SingsOfZodiac {
	private List<SingOfZodiac> _sings;
	final int SIZE_LIST = 12;

	public SingsOfZodiac() {
		_sings = new ArrayList<>(SIZE_LIST);
		
		readDataTromFile("res/text/Aries.txt");
		readDataTromFile("res/text/Aquarius.txt");
		readDataTromFile("res/text/Cancer.txt");
		readDataTromFile("res/text/Capricorn.txt");
		readDataTromFile("res/text/Gemini.txt");
		readDataTromFile("res/text/Leo.txt");
		readDataTromFile("res/text/Libra.txt");
		readDataTromFile("res/text/Pisces.txt");
		readDataTromFile("res/text/Sagittarius.txt");
		readDataTromFile("res/text/Scorpio.txt");
		readDataTromFile("res/text/Taurus.txt");
		readDataTromFile("res/text/Virgo.txt");
	}
	
	private void addImages(final SingOfZodiac sing) {
		String path = "res/img/" + sing.getName() +".png";
		URL url = getClass().getResource((path));
		ImageIcon image = new ImageIcon(url);
		sing.setImage(image);
	}

	private void readDataTromFile(final String path) {
		//InputStream in = getClass().getResourceAsStream("res/text/Aries.txt");
		//BufferedReader fin = new BufferedReader(new InputStreamReader(in));
		InputStream in = getClass().getResourceAsStream(path);
			try {
				SingOfZodiac temp = new SingOfZodiac();
				BufferedReader fin = new BufferedReader(new InputStreamReader(in));
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
				addImages(temp);
				_sings.add(temp);
			} catch (IOException e) {
				e.printStackTrace();
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