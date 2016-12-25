package lyskal.singsofzodiac;

import java.text.SimpleDateFormat;

/**
 * The class carry out check of the strings 
 * on a validity. 
 * 
 * @author LyskaL
 */
public class Validator {
		
		@SuppressWarnings("serial")
		private static final SimpleDateFormat DATE_FORMAT = 
				new SimpleDateFormat("dd.MM") {{setLenient(false);}};
		
		/**
		 * Check a date correctness.
		 * 
		 * @param date - birth date of workers
		 * @return 
		 * true - date is correct;
		 * false - date is not correct.
		 */
		public static boolean isValidDate(final String date) {
			try {
				DATE_FORMAT.parse(date);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}