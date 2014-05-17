package proto;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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

	// Enemykbol, Towerekbol, Trapekbol allo listak megjelenitesehez hasznalt
	// komponensek
	private final DefaultListModel<String> enemylistmodel = new DefaultListModel<String>();
	private final DefaultListModel<String> towerlistmodel = new DefaultListModel<String>();
	private final DefaultListModel<String> traplistmodel = new DefaultListModel<String>();
	private JList<String> enemylist = new JList<String>();
	private JList<String> towerlist = new JList<String>();
	private JList<String> traplist = new JList<String>();

	// Uj terkepelem hozzaadasanal hasznalt X es Y koordinata beviteli mezoje
	private JTextField posx = new JTextField(2);
	private JTextField posy = new JTextField(2);

	// Hozzaadas vagy eltavolitas funckio kivalsztasahoz hasznalt legordulolista
	private JComboBox<String> action;

	// Hozzaadni, eltavolitani kivant terkepelem tipusanak kivalasztasahoz
	// hasznalt legurdolista
	private JComboBox<String> type;

	// Varazsko kivalasztasahoz hasznalt legordulo cimke es lista
	private JLabel gemstoneboxlabel = new JLabel("Varazsko tipusa:");
	private JComboBox<String> gemstonebox;

	// Legordulo listak tartalma
	String[] functionboxcontent = { "Add", "Remove" };
	String[] typeboxcontent = { "Tower", "Trap", "GemStone" };
	String[] gemstoneboxcontent = { "Dwarf elleni", "Elf elleni",
			"Hobbit elleni", "Human elleni", "Tuzelesi gyakorisag+",
			"Hatotav+", "Hatoido+" };

	// Uj terkepelem hozzaadasahoz, eltavolitasahoz hasznalt gomb
	private JButton actionbutton = new JButton("Go!");

	// Jateksebesseg modositasahoz hasznalt gombok
	private JLabel veplabel = new JLabel("VEP: ");
	private JButton playbutton = new JButton("Play");
	private JButton stopbutton = new JButton("Pause");
	private JButton speedplusbutton = new JButton("FFwd");

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
	// tartalmazo panel
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
	private SpeedStatus actspeedstatus;

	private Dimension windowsize;

	private enum SpeedStatus {
		NORMAL, FAST, PAUSED
	}

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
		actspeedstatus = SpeedStatus.PAUSED;
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
		speedpanel.add(stopbutton, BoxLayout.X_AXIS);
		speedpanel.add(speedplusbutton, BoxLayout.X_AXIS);
		speedpanel.add(playbutton, BoxLayout.X_AXIS);
		enemylist.setModel(enemylistmodel);
		towerlist.setModel(towerlistmodel);
		traplist.setModel(traplistmodel);
		action = new JComboBox<String>(functionboxcontent);
		type = new JComboBox<String>(typeboxcontent);
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
		gemstonepanel.add(gemstonebox);
		gemstonebox.setEnabled(false);
		functionpanel.add(action);
		functionpanel.add(type);
		functionpanel.add(posx);
		functionpanel.add(posy);
		functionpanel.add(actionbutton);
		actionbutton.setEnabled(false);
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

		windowsize = frame.getSize();

		// ESC gombra kilep
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC");
		frame.getRootPane().getActionMap().put("ESC", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		//G gombra Go!
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_G, 0), "GO");
		frame.getRootPane().getActionMap().put("GO", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				clickedGoButton();
			}
		});

		refreshVEPLabel();
	}

	/**
	 * Vezerlokhoz tartozo esemenykezelok inicializalasa
	 */
	private void setActionListeners() {
		action.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changedSelectedFunction();
			}
		});

		type.addActionListener(new ActionListener() {
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

		stopbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedPauseButton();
			}
		});

		speedplusbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedFfwdButton();
			}
		});

		DocumentListener coorlistener = new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				try {
					int x = Integer.parseInt(posx.getText());
					int y = Integer.parseInt(posy.getText());
					if (gamecontroller.getMap().getTile((double) x, (double) y)
							.getClass() == Road.class) {
						gemstonebox.setSelectedIndex(6);
						return;
					} else {
						gemstonebox.setSelectedIndex(0);
						return;
					}
				} catch (Exception e) {
					gemstonebox.setSelectedIndex(0);
				}
			}
		};

		posx.getDocument().addDocumentListener(coorlistener);
		posy.getDocument().addDocumentListener(coorlistener);
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
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, (int) gamecontroller.getMap().getSize().getX()
				* Constants.GUI_TILE_SIZE + Constants.GUI_TILE_SIZE,
				(int) gamecontroller.getMap().getSize().getY()
						* Constants.GUI_TILE_SIZE + Constants.GUI_TILE_SIZE);

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
			gametimer.pause();
			JOptionPane.showMessageDialog(frame, "On nyert!", "Jatek vege",
					JOptionPane.INFORMATION_MESSAGE);
			gamecontroller.win();
			System.exit(0);
			return;
		}
		if (gamecontroller.getGameOver()) {
			gametimer.pause();
			JOptionPane.showMessageDialog(frame, "On vesztett!", "Jatek vege",
					JOptionPane.INFORMATION_MESSAGE);
			gamecontroller.gameOver();
			System.exit(0);
			return;
		}
	}

	/**
	 * Megvaltozott a kivalasztott funkcio
	 */
	private void changedSelectedFunction() {
		if (action.getSelectedIndex() == 0) {
			type.setEnabled(true);
			gemstonebox.setEnabled(true);
		} else {
			type.setSelectedIndex(0);
			gemstonebox.setEnabled(false);
			type.setEnabled(false);
		}
	}

	/**
	 * Megvaltozott a kivalasztott tipus
	 */
	private void changedSelectedType() {

		if (type.getSelectedIndex() == 2) {
			gemstonebox.setEnabled(true);
		} else {
			gemstonebox.setEnabled(false);
		}
		try {
			int x = Integer.parseInt(posx.getText());
			int y = Integer.parseInt(posy.getText());
			if (gamecontroller.getMap().getTile((double) x, (double) y)
					.getClass() == Road.class) {
				gemstonebox.setSelectedIndex(6);
				return;
			} else {
				gemstonebox.setSelectedIndex(0);
				return;
			}
		} catch (NumberFormatException e) {
			gemstonebox.setSelectedIndex(0);
		}
	}

	/**
	 * Go! gombra kattintas
	 */
	private void clickedGoButton() {
		if (!isValidCoordinates()) {
			return;
		}

		int functionindex = action.getSelectedIndex();
		int typeindex = type.getSelectedIndex();
		int xcoord = Integer.parseInt(posx.getText());
		int ycoord = Integer.parseInt(posy.getText());

		// Uj terkepelem hozzaadas
		if (functionindex == 0) {
			// Torony
			if (typeindex == 0) {
				addTower(xcoord, ycoord);
			}
			// Akadaly
			else if (typeindex == 1) {
				addTrap(xcoord, ycoord);
			}
			// Varazsko
			else if (typeindex == 2) {
				addGemStone(gemstonebox.getSelectedIndex(), xcoord, ycoord);
			} else {
				JOptionPane
						.showMessageDialog(
								frame,
								"Itt van valami bibi, a kivalasztott type index ervenytelen!",
								"Hiba", JOptionPane.ERROR_MESSAGE);
			}
		}
		// Meglevo terkepelem eltavolitas
		else if (functionindex == 1) {
			removeTower(xcoord, ycoord);
		} else {
			JOptionPane
					.showMessageDialog(
							frame,
							"Itt van valami bibi, a kivalasztott function index ervenytelen!",
							"Hiba", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Play gombra kattintas
	 */
	private void clickedPlayButton() {
		if (actspeedstatus == SpeedStatus.PAUSED) {
			this.gametimer.setNormalSpeed();
			actionbutton.setEnabled(true);
		} else if (actspeedstatus == SpeedStatus.FAST) {
			this.gametimer.pause();
			this.gametimer.setNormalSpeed();
		}
		actspeedstatus = SpeedStatus.NORMAL;
	}

	/**
	 * Pause gombra kattintas
	 */
	private void clickedPauseButton() {
		if (actspeedstatus == SpeedStatus.NORMAL
				|| actspeedstatus == SpeedStatus.FAST) {
			this.gametimer.pause();
			actspeedstatus = SpeedStatus.PAUSED;
			actionbutton.setEnabled(false);
		}
	}

	/**
	 * FFDW gombra kattintas
	 */
	private void clickedFfwdButton() {
		if (actspeedstatus == SpeedStatus.PAUSED) {
			this.gametimer.setFastForward();
			actionbutton.setEnabled(true);
		} else if (actspeedstatus == SpeedStatus.NORMAL) {
			this.gametimer.pause();
			this.gametimer.setFastForward();
		}
		actspeedstatus = SpeedStatus.FAST;
	}

	/**
	 * Megadott X, Y koordinataertekek ellenorzese
	 */
	private boolean isValidCoordinates() {
		int xcoord, ycoord;
		try {
			xcoord = Integer.parseInt(posx.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame,
					"A megadott 'X' koordinata nem egesz szam!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
					"Valami gond van a megadott 'X' koordinata kornyeken!",
					"Hiba", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			ycoord = Integer.parseInt(posy.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame,
					"A megadott 'Y' koordinata nem egesz szam!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
					"Valami gond van a megadott 'Y' koordinata kornyeken!",
					"Hiba", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (xcoord > gamecontroller.getMap().getSize().getX()) {
			JOptionPane.showMessageDialog(frame,
					"Az 'X' koordinata a terkepen kivulre esik!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (ycoord > gamecontroller.getMap().getSize().getY()) {
			JOptionPane.showMessageDialog(frame,
					"Az 'Y' koordinata a terkepen kivulre esik!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	/**
	 * Uj torony hozzaadasa
	 */
	private void addTower(double xcoord, double ycoord) {
		if (gamecontroller.getMana() < 20) {
			JOptionPane.showMessageDialog(frame,
					"A torony lerakasahoz legalabb 20 VEP kell.", "Figyelem!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		Map map = gamecontroller.getMap();

		Tile tile = (map.getTile(xcoord, ycoord));
		if (tile.getClass() == Road.class) {
			JOptionPane.showMessageDialog(frame,
					"Uton nem helyeztheto el torony!", "Figyelem!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		Field field = (Field) map.getTile(xcoord, ycoord);
		if (field.getTower() != null) {
			JOptionPane.showMessageDialog(frame, "A mezon mar van torony!",
					"Figyelem!", JOptionPane.WARNING_MESSAGE);
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
	public void removeTower(double xcoord, double ycoord) {
		Map map = gamecontroller.getMap();
		Tile tile = (map.getTile(xcoord, ycoord));

		if (tile.getClass() == Road.class) {
			JOptionPane
					.showMessageDialog(
							frame,
							"Uton alapbol nem lehet torony, igy nem nagyon lehet azt onnet eltavolitani!",
							"Figyelem!", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Field field = (Field) map.getTile(xcoord, ycoord);
		if (field.getTower() == null) {
			JOptionPane.showMessageDialog(frame,
					"A mezon nincs meg torony, nem lehet mit eltavolitani!",
					"Figyelem!", JOptionPane.WARNING_MESSAGE);
			return;
		}

		field.resetTower();

		refreshLists();

		mappanel.repaint();
	}

	/**
	 * Uj csapda hozzaadasa
	 */
	public void addTrap(double xcoord, double ycoord) {
		if (gamecontroller.getMana() < 10) {
			JOptionPane.showMessageDialog(frame,
					"Akadaly lerakasahoz legalavv 10 VEP kell!", "Figyelem!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		Map map = gamecontroller.getMap();

		Tile tile = (map.getTile(xcoord, ycoord));
		if (tile.getClass() == Field.class) {
			JOptionPane.showMessageDialog(frame,
					"Mezon nem helyeztheto el akadaly!", "Figyelem!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		Road road = (Road) map.getTile(xcoord, ycoord);
		if (road.getTrap() != null) {
			JOptionPane.showMessageDialog(frame, "Az uton mar van akadaly!",
					"Figyelem!", JOptionPane.WARNING_MESSAGE);
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
	public void addGemStone(int type, double xcoord, double ycoord) {
		if (gamecontroller.getMana() < 10) {
			JOptionPane.showMessageDialog(frame,
					"Varazsko hozzaadasahoz legalabb 10 VEP kell!",
					"Figyelem!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Map map = gamecontroller.getMap();

		Tile tile = (map.getTile(xcoord, ycoord));
		if (tile.getClass() == Field.class) {
			Field field = (Field) tile;
			if (field.getTower() == null) {
				JOptionPane.showMessageDialog(frame,
						"A mezon nincs torony, nem lehet mit varazskovezni!",
						"Figyelem!", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (field.getTower().getGemStoneList().size() >= 4) {
				JOptionPane.showMessageDialog(frame,
						"Erre a toronyra nem teheto tobb varazsko!",
						"Figyelem!", JOptionPane.WARNING_MESSAGE);
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
						"Figyelem!", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (road.getTrap().isGemStoned()) {
				JOptionPane.showMessageDialog(frame,
						"Ezen az akadalyon mar van varazsko!", "Figyelem!",
						JOptionPane.WARNING_MESSAGE);
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

	/**
	 * Ablak meretenek lekeredzesehez
	 * 
	 * @return Ablak aktualis merete Dimension objektumkent
	 */
	public Dimension getFrameSize() {
		return windowsize;
	}

}
