package lyskal.module2.audioplayer;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Hashtable;

public class AudioPlayer implements ChangeListener {
	JLabel _bassLabel = new JLabel("Bass");
	JLabel _midrangeLabel = new JLabel("Midrange");
	JLabel _trebleLabel = new JLabel("Treble");
	JLabel _balanceLabel = new JLabel("Balance");
	JLabel _volumeLabel = new JLabel("Volume");
	JLabel _infoLabel = new JLabel("");
	
	JSlider _bassSlider = new JSlider(-10, 10);
	JSlider _midrangeSlider = new JSlider(-10, 10);
	JSlider _trebleSlider = new JSlider(-10, 10);
	JSlider _balanceSlider = new JSlider(0, 10, 0);
	JSlider _volumeSlider = new JSlider(-5, 5);
	
	JRadioButton _presetOneButton = new JRadioButton("Preset 1");
	JRadioButton _presetTwoButton = new JRadioButton("Preset 2");
	JRadioButton _defaultsButton = new JRadioButton("Defaults");
	JButton _storeButton = new JButton("Store Settings");
	//Объект предназначенный для форматирования значений,
	//отображаемых в линейном регуляторе.
	DecimalFormat _df;
	//В массиве содержатся сохранённые конфигурации. 
	Presets[] _presets;
	
	public AudioPlayer() {
		JFrame jFrame = getJFrame();
		//Создание объекта форматирования, который будет
		//отображать знаки + и -
		_df = new DecimalFormat("+#;-#");
		setupSliders();
		setupPresets();
		setupLabels();
		setupRButton();
		_bassSlider.addChangeListener(this);
		_midrangeSlider.addChangeListener(this);
		_trebleSlider.addChangeListener(this);
		_balanceSlider.addChangeListener(this);
		_volumeSlider.addChangeListener(this);
		
		_storeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				if(_presetOneButton.isSelected()) {
					storePreset(_presets[1]);
				} else if(_presetTwoButton.isSelected()) {
					storePreset(_presets[2]);
				}
			}
		});
		
		_defaultsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				loadPreset(_presets[0]);
			}
		});
		
		_presetOneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				loadPreset(_presets[1]);
			}
		});
		
		_presetTwoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				loadPreset(_presets[2]);
			}
		});
		Container cp = jFrame.getContentPane();
		
		cp.add(_bassLabel);
		cp.add(_bassSlider);
		cp.add(_midrangeLabel);
		cp.add(_midrangeSlider);
		cp.add(_trebleLabel);
		cp.add(_trebleSlider);
		cp.add(_balanceLabel);
		cp.add(_balanceSlider);
		cp.add(_volumeLabel);
		cp.add(_volumeSlider);
		cp.add(_defaultsButton);
		cp.add(_presetOneButton);
		cp.add(_presetTwoButton);
		
		cp.add(_storeButton);
		cp.add(new JLabel(""));
		cp.add(_infoLabel);
	}
	
	@Override
	public void stateChanged(final ChangeEvent ce) {
		//Отображение обновлённой информации.
		showSettings();
	}
	
	private void showSettings() {
		String balance;
		
		//Получение установок баланса.
		int b = _balanceSlider.getValue();
		if(b > 0) {
			balance = "Right " + _df.format(_balanceSlider.getValue());
		} else if (b == 0) {
			balance = "Center";
		} else {
			balance = "Left " + _df.format(-_balanceSlider.getValue());
		}
		_infoLabel.setText("<html>Treble: " + _df.format(_trebleSlider.getValue()) +
						   "<br>Midrange: " + _df.format(_midrangeSlider.getValue()) +
						   "<br>Bass: " + _df.format(_bassSlider.getValue()) +
						   "<br>Balance: " + balance +
						   "<br>Volume: " + _df.format(_volumeSlider.getValue()));
	}

	protected void loadPreset(final Presets presets) {
		// TODO Auto-generated method stub
		
	}

	protected void storePreset(final Presets presets) {
		// TODO Auto-generated method stub
		
	}

	private void setupRButton() {
		// TODO Auto-generated method stub
		
	}

	private void setupLabels() {
		// TODO Auto-generated method stub
		
	}

	private void setupPresets() {
		// TODO Auto-generated method stub
		
	}

	private void setupSliders() {
		//Добавление основных маркеров
		_bassSlider.setMajorTickSpacing(2);
		_midrangeSlider.setMajorTickSpacing(2);
		_trebleSlider.setMajorTickSpacing(2);
		_volumeSlider.setMajorTickSpacing(1);
		_balanceSlider.setMajorTickSpacing(1);
		//Добавление вспомогательных маркеров
		_bassSlider.setMinorTickSpacing(1);
		_midrangeSlider.setMinorTickSpacing(1);
		_trebleSlider.setMinorTickSpacing(1);
		//Создание меток для линейных регуляторов
		Hashtable<Integer, JLabel> table = new Hashtable<>();
		for (int i = -10; i <= 0; i+=2) {
			table.put(new Integer(i), new JLabel(""+ i));
		}
		
	}

	private JFrame getJFrame() {
		JFrame jFrame = new JFrame("A Simple Audio Player");
		jFrame.setBounds(500, 100, 340, 520);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		return jFrame;
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AudioPlayer();
			}
		});
	}
}
