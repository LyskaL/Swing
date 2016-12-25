package lyskal.singsofzodiac;

import javax.swing.ImageIcon;

public class SingOfZodiac {
	private String _name;
	private String _element;
	private String _date;
	private String _description;
	private ImageIcon _image;
	
	public SingOfZodiac() {
		_name = "";
		_element = "";
		_date = "";
		_description = "";
	}
	
	public String getName() {
		return _name;
	}
	
	public String getElement() {
		return _element;
	}
	
	public String getDate() {
		return _date;
	}

	public String getDescription() {
		return _description;
	}
	
	public void setName(final String name) {
		_name = name;
	}
	
	public void setElement(final String element) {
		_element = element;
	}
	
	public void setDate(final String date) {
		_date = date;
	}
	
	public void setDescription(final String description) {
		_description += description;
	}
	
	public boolean isDateInRange (final int bithDay, final int bithMonth) {
		int firstDay = Integer.parseInt(_date.substring(0, 2));
		int firstMonth = Integer.parseInt(_date.substring(3, 5));
		int secondDay = Integer.parseInt(_date.substring(6, 8));
		int secondMonth = Integer.parseInt(_date.substring(9, _date.length()));
		
		if (bithMonth == firstMonth && bithDay >= firstDay) {
			return true;
		} else if (bithMonth == secondMonth && bithDay <= secondDay) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "SingOfZodiac [_name=" + _name + ", _element=" + _element + ", _date=" + _date + ", _description="
				+ _description + "]";
	}

	public ImageIcon getImage() {
		return _image;
	}

	public void setImage(final String imagePath) {
		_image = new ImageIcon(imagePath);
	}
}