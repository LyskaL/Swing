package lyskal.module2.audioplayer;

public class Presets {
	private int _bass;
	private int _midrange;
	private int _treble;
	private int _balance;
	private int _volume;

	public Presets(final int bass, final int midrange, final int treble, 
				   final int balance, final int volume) {
		_bass = bass;
		_midrange = midrange;
		_treble = treble;
		_balance = balance;
		_volume = volume;
	}

	public int getBass() {
		return _bass;
	}

	public void setBass(final int bass) {
		this._bass = bass;
	}

	public int getMidrange() {
		return _midrange;
	}

	public void setMidrange(final int midrange) {
		this._midrange = midrange;
	}

	public int getTreble() {
		return _treble;
	}

	public void setTreble(final int treble) {
		this._treble = treble;
	}

	public int getBalance() {
		return _balance;
	}

	public void setBalance(final int balance) {
		this._balance = balance;
	}

	public int getVolume() {
		return _volume;
	}

	public void setVolume(final int volume) {
		this._volume = volume;
	}
}
