package proto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Ez az osztaly felelos a felhasznaloi feluleten levo vezerlok es egyeb
 * objektumok kirajzolasaert.
 * 
 * @author Atilla Ivanics, Alex Torok
 * @since 2014-05-02
 */
public class GuiManager {

	// Az alap frame
	private JFrame frame;

	// Feluleten levo label-ek.
	private JLabel enemylistlabel = new JLabel("Enemy List:");
	private JLabel towerlistlabel = new JLabel("Tower List:");
	private JLabel traplistlabel = new JLabel("Trap List:");

	// Enemy-kbol, Tower-ekbol, Trap-ekbol allo listak megjelenitesehez hasznalt
	// komponensek
	private final DefaultListModel<String> enemylistmodel = new DefaultListModel<String>();
	private final DefaultListModel<String> towerlistmodel = new DefaultListModel<String>();
	private final DefaultListModel<String> traplistmodel = new DefaultListModel<String>();
	private JList<String> enemylist = new JList<String>();
	private JList<String> towerlist = new JList<String>();
	private JList<String> traplist = new JList<String>();

	// Uj terkepelem hozzaadasanal hasznalt X es Y koordinata beviteli mezoje
	private JTextField xcoordfield = new JTextField(2);
	private JTextField ycoordfield = new JTextField(2);

	// Hozzaadas vagy eltavolitas funckio kivalsztasahoz hasznalt legordulolista
	private JComboBox<String> functionbox;

	// Hozzaadni, eltavolitani kivant terkepelem tipusanak kivalasztasahoz
	// hasznalt legurdolista
	private JComboBox<String> typebox;

	// Varazsko kivalasztasahoz hasznalt legordulo cimke es lista
	private JLabel gemstoneboxlabel = new JLabel("Torony varazsko tipusa:");
	private JComboBox<String> gemstonebox;

	// Legordulo listak tartalma
	String[] functionboxcontent = { "Add", "Remove" };
	String[] typeboxcontent = { "Tower", "Trap", "GemStone" };
	String[] gemstoneboxcontent = { "Dwarf elleni", "Elf elleni",
			"Hobbit elleni", "Human elleni", "Tuzelesi gyakorisag+",
			"Hatotav+" };

	// Uj terkepelem hozzaadasahoz, eltavolitasahoz hasznalt gomb
	private JButton actionbutton = new JButton("Go!");

	// Jateksebesseg modositasahoz hasznalt gombok
	private JLabel veplabel = new JLabel("VEP: ");
	private JButton playbutton = new JButton("Play");
	private boolean paused = false;
	private JButton pausebutton = new JButton("Pause");
	private JButton ffwdbutton = new JButton("FFwd");

	// Panelek, amikbol a felulet felepul
	// A teljes frame-en elterulo panel
	private JPanel mainpanel = new JPanel();
	// Vezerlok savjat tartalmazo panel
	private JPanel controlpanel = new JPanel();
	// Jateksebesseget allito gombokat tartalmazo panel
	private JPanel speedpanel = new JPanel();
	// Listakat tartalmazo panel
	private JPanel listpanel = new JPanel();
	// Listacimkeket tartalmazo panel
	private JPanel listlabelpanel = new JPanel();
	// Listakomponenseket tartalmazo panel
	private JPanel listmainpanel = new JPanel();
	// Uj terkepelem hozzaadasahoz, eltavolitasahoz hasznalt komponenseket
	// tartalmazo panel.
	private JPanel functionpanel = new JPanel();
	// Varazsko kivalasztasahoz hasznalt listat tarolo panel
	private JPanel gemstonepanel = new JPanel();
	// Vezerloket osszefogo panel
	private JPanel functionmainpanel = new JPanel();
	// Terkep panelje
	private MapPanel mappanel = new MapPanel(this);

	// GameController-re mutato referencia
	private GameController gamecontroller;
	// GameTimer-re mutato referencia
	private GameTimer gametimer;

	// Terkep merete
	int mapsizex = 0, mapsizey = 0;

	/**
	 * GUI-t kezelo osztaly kostruktora; felepiti a GUI-t, inicializalja a
	 * tagvaltozokat.
	 * 
	 * @param gamecontroller
	 *            A jatekteret tartalmazo GameController
	 */
	public GuiManager(GameController gamecontroller, GameTimer gametimer) {

		this.gamecontroller = gamecontroller;

		this.gametimer = gametimer;

		initGui();

		setActionListeners();
	}

	/**
	 * a mappanel lekeresehez hasznalt metodus, a terkep frissitese miatt ra
	 * szukseg
	 */
	public MapPanel getMapPanel() {
		return mappanel;
	}

	/**
	 * Tilesize inicializalas
	 */
	private void initTileSize() {
		mapsizex = ((int) gamecontroller.getMap().getSize().getX() + 1);
		mapsizey = ((int) gamecontroller.getMap().getSize().getY() + 1);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		width *= 0.85;
		width -= Constants.GUI_CONTROLLER_W;
		Constants.GUI_TILE_SIZE = (int) width / mapsizex;

		height *= 0.85;
		if ((int) height / mapsizey < Constants.GUI_TILE_SIZE) {
			Constants.GUI_TILE_SIZE = (int) height / mapsizey;
		}

		mapsizex *= Constants.GUI_TILE_SIZE;
		mapsizey *= Constants.GUI_TILE_SIZE;
	}

	/**
	 * GUI inicializalasa
	 */
	private void initGui() {

		initTileSize();

		final JFrame frame = new JFrame("Super TD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(mappanel, BorderLayout.CENTER);
		mainpanel.add(controlpanel, BorderLayout.EAST);

		mappanel.setSize(mapsizex, mapsizey);
		controlpanel.setLayout(new BorderLayout());
		controlpanel.add(speedpanel, BorderLayout.NORTH);
		controlpanel.add(listpanel, BorderLayout.CENTER);
		controlpanel.add(functionmainpanel, BorderLayout.SOUTH);
		speedpanel.add(veplabel, BoxLayout.X_AXIS);
		speedpanel.add(pausebutton, BoxLayout.X_AXIS);
		speedpanel.add(ffwdbutton, BoxLayout.X_AXIS);
		speedpanel.add(playbutton, BoxLayout.X_AXIS);
		enemylist.setModel(enemylistmodel);
		towerlist.setModel(towerlistmodel);
		traplist.setModel(traplistmodel);
		enemylist.setEnabled(false);
		towerlist.setEnabled(false);
		traplist.setEnabled(false);
		functionbox = new JComboBox<String>(functionboxcontent);
		typebox = new JComboBox<String>(typeboxcontent);
		gemstonebox = new JComboBox<String>(gemstoneboxcontent);

		listpanel.setLayout(new BorderLayout());
		listpanel.add(listlabelpanel, BorderLayout.NORTH);
		listpanel.add(listmainpanel, BorderLayout.CENTER);
		listlabelpanel.setLayout(new GridLayout(1, 3));
		listlabelpanel.add(towerlistlabel);
		listlabelpanel.add(traplistlabel);
		listlabelpanel.add(enemylistlabel);
		listmainpanel.setLayout(new GridLayout(1, 3));
		listmainpanel.add(towerlist);
		listmainpanel.add(traplist);
		listmainpanel.add(enemylist);
		gemstonepanel.add(gemstoneboxlabel);
		gemstonebox.setEnabled(false);
		gemstonepanel.add(gemstonebox);
		functionpanel.add(functionbox);
		functionpanel.add(typebox);
		functionpanel.add(xcoordfield);
		functionpanel.add(ycoordfield);
		functionpanel.add(actionbutton);
		functionmainpanel.setLayout(new BorderLayout());
		functionmainpanel.add(functionpanel, BorderLayout.NORTH);
		functionmainpanel.add(gemstonepanel, BorderLayout.SOUTH);

		controlpanel.setPreferredSize(new Dimension(Constants.GUI_CONTROLLER_W,
				mapsizey));
		frame.getContentPane().add(mainpanel);
		frame.setResizable(false);
		frame.getContentPane().setPreferredSize(
				new Dimension(Constants.GUI_CONTROLLER_W + mapsizex, mapsizey));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// ESC gombra kilep
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel");
		frame.getRootPane().getActionMap().put("Cancel", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		refreshVEPLabel();
	}

	/**
	 * Vezerlokhoz tartozo esemenykezelok inicializalasa
	 */
	private void setActionListeners() {
		functionbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changedSelectedFunction();
			}
		});

		typebox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changedSelectedType();
			}
		});

		actionbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedGoButton();
			}
		});

		playbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedPlayButton();
			}
		});

		pausebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedPauseButton();
			}
		});

		ffwdbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedFfwdButton();
			}
		});
	}

	/**
	 * Tower, Trap, Enemy listakat frissito, aktualizalo metodus
	 */
	public void refreshLists() {
		List<Enemy> enemies = gamecontroller.getEnemyList();
		if (enemies != null) {
			enemylistmodel.removeAllElements();

			List<String> enemylistlabel = new ArrayList<String>();

			for (Enemy e : enemies) {
				String newelement = "";
				if (e.getClass() == Dwarf.class) {
					newelement = "|DWARF|";
				} else if (e.getClass() == Elf.class) {
					newelement = "|ELF|";
				} else if (e.getClass() == Hobbit.class) {
					newelement = "|HOBBIT|";
				} else if (e.getClass() == Human.class) {
					newelement = "|HUMAN|";
				}
				newelement += "(" + (int) e.getPosition().getX() + ","
						+ (int) e.getPosition().getY() + ")|" + e.getHealth();
				enemylistlabel.add(newelement);
			}
			Collections.sort(enemylistlabel);
			for (String actlabel : enemylistlabel) {
				enemylistmodel.addElement(actlabel);
			}
			enemylist.validate();
		} else {
			enemylistmodel.removeAllElements();
			enemylist.validate();
		}

		List<Tower> towers = gamecontroller.getMap().getTowerList();
		if (towers != null) {
			towerlistmodel.removeAllElements();

			for (Tower t : towers) {
				String newelement = "(" + (int) t.getPosition().getX() + ","
						+ (int) t.getPosition().getY() + ")|"
						+ (int) t.getRange();
				towerlistmodel.addElement(newelement);
			}
			towerlist.validate();
		} else {
			towerlistmodel.removeAllElements();
			towerlist.validate();
		}

		List<Trap> traps = gamecontroller.getMap().getTrapList();
		if (traps != null) {
			traplistmodel.removeAllElements();

			for (Trap t : traps) {
				String newelement = "(" + (int) t.getPosition().getX() + ","
						+ (int) t.getPosition().getY() + ")|"
						+ (int) t.getEndTime();
				traplistmodel.addElement(newelement);
			}
			traplist.validate();
		} else {
			traplistmodel.removeAllElements();
			traplist.validate();
		}
	}

	/**
	 * GameController getter
	 * 
	 * @return A jatekteret tartalmazo GameController objektum
	 */
	public GameController getGameController() {
		return this.gamecontroller;
	}

	/**
	 * Ezzel a metodussal tortenik a terkep ujrarajzolasa
	 */
	public void redrawAll(Graphics g) {
		// Palyaelemek rajzolasa
		List<Tile> tileList = gamecontroller.getMap().getTileList();
		for (Tile t : tileList) {
			// ez itt a trapeket es towereket is kirajzolja, ha vannak
			t.draw(g);
			Tower tower = t.getTower();
			if (tower != null) {
				List<GemStone> gemStoneList = tower.getGemStoneList();
				if (gemStoneList != null && gemStoneList.size() != 0) {
					for (GemStone gem : gemStoneList) {
						gem.draw(g);
					}
				}
			}
		}

		// az ellensegek kirajzolasa
		List<Enemy> enemyList = gamecontroller.getEnemyList();
		for (Enemy e : enemyList) {
			e.draw(g);
		}

		// racs kirajzolasa
		gamecontroller.getMap().draw(g);
	}

	public void itsOver() {
		if (gamecontroller.getWin()) {
			JOptionPane.showMessageDialog(frame, "On nyert!", "Nyert!", 0);
			return;
		}
		if (gamecontroller.getGameOver()) {
			JOptionPane.showMessageDialog(frame, "On vesztett!", "Vesztes!", 0);
			return;
		}
	}

	/**
	 * Megvaltozott a kivalasztott funkcio
	 */
	private void changedSelectedFunction() {
		if (functionbox.getSelectedIndex() == 0) {
			typebox.setEnabled(true);
		} else {
			typebox.setEnabled(false);
		}
	}

	/**
	 * Megvaltozott a kivalasztott tipus
	 */
	private void changedSelectedType() {
		if (typebox.getSelectedIndex() == 2) {
			gemstonebox.setEnabled(true);
		} else {
			gemstonebox.setEnabled(false);
		}
	}

	/**
	 * Go! gombra kattintas
	 */
	private void clickedGoButton() {
		if (!isValidCoordinates()) {
			return;
		}

		int functionindex = functionbox.getSelectedIndex();
		int typeindex = typebox.getSelectedIndex();
		int posx = Integer.parseInt(xcoordfield.getText());
		int posy = Integer.parseInt(ycoordfield.getText());

		// Uj terkepelem hozzaadas
		if (functionindex == 0) {
			// Torony
			if (typeindex == 0) {
				addTower(posx, posy);
			}
			// Akadaly
			else if (typeindex == 1) {
				addTrap(posx, posy);
			}
			// Varazsko
			else if (typeindex == 2) {
				addGemStone(gemstonebox.getSelectedIndex(), posx, posy);
			} else {
				JOptionPane
						.showMessageDialog(
								frame,
								"Itt van valami bibi, a kivalasztott type index ervenytelen!",
								"Hiba", 0);
			}
		}
		// Meglevo terkepelem eltavolitas
		else if (functionindex == 1) {
			removeTower(posx, posy);
		} else {
			JOptionPane
					.showMessageDialog(
							frame,
							"Itt van valami bibi, a kivalasztott function index ervenytelen!",
							"Hiba", 0);
		}
	}

	/**
	 * Play gombra kattintas
	 */
	private void clickedPlayButton() {
		// JOptionPane.showMessageDialog(frame,
		// "Na majd ez lesz egyszer a play!");
		this.gametimer.setNormalSpeed();
	}

	/**
	 * Pause gombra kattintas
	 */
	private void clickedPauseButton() {
		if (paused) {
			this.gametimer.resume();
			paused = false;
		} else {
			this.gametimer.pause();
			paused = true;
		}
	}

	/**
	 * FFDW gombra kattintas
	 */
	private void clickedFfwdButton() {
		// JOptionPane.showMessageDialog(frame, "Csak ne olyan gyorsan!");
		this.gametimer.setFastForward();
	}

	/**
	 * Megadott X, Y koordinataertekek ellenorzese
	 */
	private boolean isValidCoordinates() {
		int posx, posy;
		try {
			posx = Integer.parseInt(xcoordfield.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame,
					"A megadott 'X' koordinata nem egesz tipus!", "Hiba", 0);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
					"Valami gond van a megadott 'X' koordinata kornyeken!",
					"Hiba", 0);
			return false;
		}

		try {
			posy = Integer.parseInt(ycoordfield.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame,
					"A megadott 'Y' koordinata nem egesz tipus!", "Hiba", 0);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
					"Valami gond van a megadott 'Y' koordinata kornyeken!",
					"Hiba", 0);
			return false;
		}

		if (posx > gamecontroller.getMap().getSize().getX()) {
			JOptionPane.showMessageDialog(frame,
					"Az 'X' koordinata a terkepen kivulre esik!", "Hiba", 0);
			return false;
		}

		if (posy > gamecontroller.getMap().getSize().getY()) {
			JOptionPane.showMessageDialog(frame,
					"Az 'Y' koordinata a terkepen kivulre esik!", "Hiba", 0);
			return false;
		}

		return true;
	}

	/**
	 * Uj torony hozzaadasa
	 */
	private void addTower(double posx, double posy) {
		if (gamecontroller.getMana() < 20) {
			JOptionPane.showMessageDialog(frame,
					"A torony lerakasahoz legalabb 20 VEP kell.", "Hiba", 0);
			return;
		}
		Map map = gamecontroller.getMap();

		Tile tile = (map.getTile(posx, posy));
		if (tile.getClass() == Road.class) {
			JOptionPane.showMessageDialog(frame,
					"Uton nem helyeztheto el torony!", "Hiba", 0);
			return;
		}

		Field field = (Field) map.getTile(posx, posy);
		if (field.getTower() != null) {
			JOptionPane.showMessageDialog(frame, "A mezon mar van torony!",
					"Hiba", 0);
			return;
		}
		gamecontroller.modifyMana(-20);
		field.setTower();

		refreshVEPLabel();
		refreshLists();

		mappanel.repaint();
	}

	/**
	 * Meglevo torony torlese
	 */
	public void removeTower(double posx, double posy) {
		Map map = gamecontroller.getMap();
		Tile tile = (map.getTile(posx, posy));

		if (tile.getClass() == Road.class) {
			JOptionPane
					.showMessageDialog(
							frame,
							"Uton alapbol nem lehet torony, igy nem nagyon lehet azt onnet eltavolitani!",
							"Hiba", 0);
			return;
		}

		Field field = (Field) map.getTile(posx, posy);
		if (field.getTower() == null) {
			JOptionPane.showMessageDialog(frame,
					"A mezon nincs meg torony, nem lehet mit eltavolitani!",
					"Hiba", 0);
			return;
		}

		field.resetTower();

		refreshLists();

		mappanel.repaint();
	}

	/**
	 * Uj csapda hozzaadasa
	 */
	public void addTrap(double posx, double posy) {
		if (gamecontroller.getMana() < 10) {
			JOptionPane.showMessageDialog(frame,
					"Akadaly lerakasahoz legalavv 10 VEP kell!", "Hiba", 0);
			return;
		}
		Map map = gamecontroller.getMap();

		Tile tile = (map.getTile(posx, posy));
		if (tile.getClass() == Field.class) {
			JOptionPane.showMessageDialog(frame,
					"Mezon nem helyeztheto el akadaly!", "Hiba", 0);
			return;
		}

		Road road = (Road) map.getTile(posx, posy);
		if (road.getTrap() != null) {
			JOptionPane.showMessageDialog(frame, "Az uton mar van akadaly!",
					"Hiba", 0);
			return;
		}
		gamecontroller.modifyMana(-10);
		road.setTrap();

		refreshVEPLabel();
		refreshLists();

		mappanel.repaint();

	}

	/**
	 * Uj varazsko hozzaadasa
	 */
	public void addGemStone(int type, double posx, double posy) {
		if (gamecontroller.getMana() < 10) {
			JOptionPane.showMessageDialog(frame,
					"Varazsko hozzaadasahoz legalabb 10 VEP kell!", "Hiba", 0);
			return;
		}
		Map map = gamecontroller.getMap();

		Tile tile = (map.getTile(posx, posy));
		if (tile.getClass() == Field.class) {
			Field field = (Field) tile;
			if (field.getTower() == null) {
				JOptionPane.showMessageDialog(frame,
						"A mezon nincs torony, nem lehet mit varazskovezni!",
						"Hiba", 0);
				return;
			}

			if (field.getTower().getGemStoneList().size() >= 4) {
				JOptionPane.showMessageDialog(frame,
						"Erre a toronyra nem teheto tobb varazsko!", "Hiba", 0);
				return;
			}

			switch (type) {
			case 0:
				field.addAntiDwarf();
				break;
			case 1:
				field.addAntiElf();
				break;
			case 2:
				field.addAntiHobbit();
				break;
			case 3:
				field.addAntiHuman();
				break;
			case 4:
				field.addPlusFrequency();
				break;
			case 5:
				field.addPlusRange();
				break;
			}
		} else {
			Road road = (Road) tile;
			if (road.getTrap() == null) {
				JOptionPane.showMessageDialog(frame,
						"Az uton nincs akadaly, nem lehet mit varazskovezni!",
						"Hiba", 0);
				return;
			}

			if (road.getTrap().isGemStoned()) {
				JOptionPane.showMessageDialog(frame,
						"Ezen az akadalyon mar van varazsko!", "Hiba", 0);
				return;
			}
			road.addPlusTime();
		}
		gamecontroller.modifyMana(-10);

		refreshVEPLabel();
		refreshLists();

		mappanel.repaint();
	}

	public void refreshVEPLabel() {
		veplabel.setText("VEP: " + gamecontroller.getMana());
	}
}
