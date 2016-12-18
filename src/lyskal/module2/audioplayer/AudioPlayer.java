package lyskal.module2.audioplayer;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Hashtable;

//Класс для создания интерфейса аудиоплейера.
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
	JSlider _balanceSlider = new JSlider(-5, 5);
	JSlider _volumeSlider = new JSlider(0, 10, 0);
	
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
		JPanel jPanel = new JPanel();
		jFrame.add(jPanel);
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
		jPanel.add(_bassLabel);
		jPanel.add(_bassSlider);
		jPanel.add(_midrangeLabel);
		jPanel.add(_midrangeSlider);
		jPanel.add(_trebleLabel);
		jPanel.add(_trebleSlider);
		jPanel.add(_balanceLabel);
		jPanel.add(_balanceSlider);
		jPanel.add(_volumeLabel);
		jPanel.add(_volumeSlider);
		jPanel.add(_defaultsButton);
		jPanel.add(_presetOneButton);
		jPanel.add(_presetTwoButton);
		jPanel.add(_storeButton);
		jPanel.add(new JLabel(""));
		jPanel.add(_infoLabel);
		jPanel.revalidate();
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
		_bassSlider.setValue(presets.getBass());
		_midrangeSlider.setValue(presets.getMidrange());
		_trebleSlider.setValue(presets.getTreble());
		_balanceSlider.setValue(presets.getBalance());
		_volumeSlider.setValue(presets.getVolume());
	}

	protected void storePreset(final Presets presets) {
		presets.setBass(_bassSlider.getValue());
		presets.setMidrange(_midrangeSlider.getValue());
		presets.setTreble(_trebleSlider.getValue());
		presets.setBalance(_balanceSlider.getValue());
		presets.setVolume(_volumeSlider.getValue());
	}

	private void setupRButton() {
		//Добавление кнопок к группе.
		ButtonGroup bg = new ButtonGroup();
		bg.add(_defaultsButton);
		bg.add(_presetOneButton);
		bg.add(_presetTwoButton);
		//Выбор кнопки Defaults.
		_defaultsButton.setSelected(true);
	}

	private void setupLabels() {
		//Установка размеров меток
		Dimension labSize = new Dimension(60, 25);
		_trebleLabel.setPreferredSize(labSize);
		_midrangeLabel.setPreferredSize(labSize);
		_bassLabel.setPreferredSize(labSize);
		_volumeLabel.setPreferredSize(labSize);
		_balanceLabel.setPreferredSize(labSize);
		//Создание информационной метки и установка её размеров
		_infoLabel.setPreferredSize(new Dimension(110, 100));
		//Заполнение _infoLabel информацией, соответствующей
		//установкам по умолчанию.
		showSettings();
	}

	private void setupPresets() {
		_presets = new Presets[3];
		_presets[0] = new Presets(0, 0, 0, 0, 0);
		_presets[1] = new Presets(2, -4, 7, 0, 4);
		_presets[2] = new Presets(3, 3, -2, 1, 7);
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
			table.put(new Integer(i), new JLabel("" + i));
		}
		for (int i = 2; i <= 10; i+=2) {
			table.put(new Integer(i), new JLabel("-" + i));
		}
		_trebleSlider.setLabelTable(table);
		_midrangeSlider.setLabelTable(table);
		_bassSlider.setLabelTable(table);
		//Создание меток для линейного регулятора Balance.
		table = new Hashtable<>();
		table.put(new Integer(0), new JLabel("Center"));
		table.put(new Integer(-5), new JLabel("L"));
		table.put(new Integer(5), new JLabel("R"));
		_balanceSlider.setLabelTable(table);
		//Создание стандартных числоых меток для
		//линейного регулятора Volume.
		_volumeSlider.setLabelTable(_volumeSlider.createStandardLabels(1));
		//Разрешение отображения маркеров.
		_bassSlider.setPaintTicks(true);
		_midrangeSlider.setPaintTicks(true);
		_trebleSlider.setPaintTicks(true);
		_volumeSlider.setPaintTicks(true);
		_balanceSlider.setPaintTicks(true);
		//Разрешение отображения меток
		_bassSlider.setPaintLabels(true);
		_midrangeSlider.setPaintLabels(true);
		_trebleSlider.setPaintLabels(true);
		_volumeSlider.setPaintLabels(true);
		_balanceSlider.setPaintLabels(true);
		//Перемещение к ближайшему маркеру
		_bassSlider.setSnapToTicks(true);
		_midrangeSlider.setSnapToTicks(true);
		_trebleSlider.setSnapToTicks(true);
		_volumeSlider.setSnapToTicks(true);
		_balanceSlider.setSnapToTicks(true);
		//Установка предпочтительных размеров линейных регуляторов
		Dimension sliderSize = new Dimension(240, 60);
		_bassSlider.setPreferredSize(sliderSize);
		_midrangeSlider.setPreferredSize(sliderSize);
		_trebleSlider.setPreferredSize(sliderSize);
		_volumeSlider.setPreferredSize(sliderSize);
		_balanceSlider.setPreferredSize(sliderSize);
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
