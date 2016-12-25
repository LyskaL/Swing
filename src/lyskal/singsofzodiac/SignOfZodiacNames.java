package lyskal.singsofzodiac;

import java.util.Arrays;
import java.util.Collection;

public class SignOfZodiacNames {
	public static final String AQUARIUS    = "Aquarius";
	public static final String ARIES       = "Aries";
	public static final String CANCER      = "Cancer";
	public static final String CAPRICORN   = "Capricorn";
	public static final String GEMINI      = "Gemini";
	public static final String LEO         = "Leo";
	public static final String LIBRA       = "Libra";
	public static final String PISCES      = "Pisces";
	public static final String SAGITTARIUS = "Sagittarius";
	public static final String SCORPIO     = "Scorpio";
	public static final String TAURUS      = "Taurus";
	public static final String VIRGO       = "Virgo";
	
	private static Collection<String> _allSignNames = null;
	
	public static Collection<String> getAllSignNames() {
		if (_allSignNames == null) {
			_allSignNames = generateCollectionOfSignNames();
		}
		
		return _allSignNames;
	}

	private static Collection<String> generateCollectionOfSignNames() {
		return Arrays.asList( AQUARIUS
				            , ARIES
				            , CANCER
				            , CAPRICORN
				            , GEMINI
				            , LEO
				            , LIBRA
				            , PISCES
				            , SAGITTARIUS
				            , SCORPIO
				            , TAURUS
				            , VIRGO);
	}
	
	
	
}
