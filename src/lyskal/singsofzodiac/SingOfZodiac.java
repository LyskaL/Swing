package lyskal.singsofzodiac;


public class SingOfZodiac {
	private String _name;
	private String _element;
	private String _date;
	private String _description;
	
	SingOfZodiac() {
		_name = "";
		_element = "";
		_date = "";
		_description = "";
	}
	
	String getName() {
		return _name;
	}
	String getElement() {
		return _element;
	}
	String getDate() {
		return _date;
	}
	@Override
	public String toString() {
		return "SingOfZodiac [_name=" + _name + ", _element=" + _element + ", _date=" + _date + ", _description="
				+ _description + "]";
	}

	String getDescription() {
		return _description;
	}
	void setName(final String name) {
		_name = name;
	}
	void setElement(final String element) {
		_element = element;
	}
	void setDate(final String date) {
		_date = date;
	}
	void setDescription(final String description) {
		_description += description;
	}
	
	boolean isDateInRange (final int bithDay, final int bithMonth) {
		int firstDay = Integer.parseInt(this._date.substring(0, 2));
		int firstMonth = Integer.parseInt(this._date.substring(3, 5));
		int secondDay = Integer.parseInt(this._date.substring(6, 8));
		int secondMonth = Integer.parseInt(this._date.substring(9, this._date.length()));
		
		if (bithMonth==firstMonth && bithDay>=firstDay) {
			return true;
		} else if (bithMonth==secondMonth && bithDay<=secondDay) {
			return true;
		} else {
			return false;
		}
	}
}