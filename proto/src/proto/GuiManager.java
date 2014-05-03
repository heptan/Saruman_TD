package proto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	
	//Varazsko kivalasztasahoz hasznalt legordulo cimke es lista
	private JLabel gemstoneboxlabel = new JLabel("Varazsko tipusa:");
	private JComboBox<String> gemstonebox;

	// Legordulo listak tartalma
	String[] functionboxcontent = { "Add", "Remove" };
	String[] typeboxcontent = { "Tower", "Trap", "GemStone" };
	String[] gemstoneboxcontent = { "Dwarf elleni", "Elf elleni", "Hobbit elleni", "Human elleni","Tuzelesi gyakorisag+","Hatotav+"};

	// Uj terkepelem hozzaadasahoz, eltavolitasahoz hasznalt gomb
	private JButton actionbutton = new JButton("Go!");

	// Jateksebesseg modositasahoz hasznalt gombok
	private JButton playbutton = new JButton("Play");
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
	//Varazsko kivalasztasahoz hasznalt listat tarolo panel
	private JPanel gemstonepanel = new JPanel();
	//Vezerloket osszefogo panel
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
	 * GUI inicializalasa
	 */
	private void initGui() {

		mapsizex = ((int) gamecontroller.getMap().getSize().getX() + 1)
				* Constants.GUI_TILE_SIZE;
		mapsizey = ((int) gamecontroller.getMap().getSize().getY() + 1)
				* Constants.GUI_TILE_SIZE;

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
		functionmainpanel.add(functionpanel,BorderLayout.NORTH);
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
				newelement += "(" + (int)e.getPosition().getX() + "," + (int)e.getPosition().getY() + ")|" + e.getHealth();
				enemylistmodel.addElement(newelement);
			}
			enemylist.validate();
		}
		
		List<Tower> towers = gamecontroller.getMap().getTowerList();
		if (towers != null) {
			towerlistmodel.removeAllElements();

			for (Tower t : towers) {
				String newelement = "(" + (int)t.getPosition().getX() + "," + (int)t.getPosition().getY() + ")|" + (int)t.getRange();
				towerlistmodel.addElement(newelement);
			}
			towerlist.validate();
		}
		
		List<Trap> traps = gamecontroller.getMap().getTrapList();
		if (traps != null) {
			traplistmodel.removeAllElements();

			for (Trap t : traps) {
				String newelement = "(" + (int)t.getPosition().getX() + "," + (int)t.getPosition().getY() + ")|" + (int)t.getEndTime();
				traplistmodel.addElement(newelement);
			}
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
	public void redrawMap(Graphics g) {
		gamecontroller.getMap().draw(g);
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
		if(!isValidCoordinates()) {
			return;
		}
		
		int functionindex = functionbox.getSelectedIndex();
		int typeindex = typebox.getSelectedIndex();
		int posx = Integer.parseInt(xcoordfield.getText());
		int posy = Integer.parseInt(ycoordfield.getText());
		
		//Uj terkepelem hozzaadas
		if(functionindex == 0) {
			//Torony
			if(typeindex == 0) {
				addTower(posx, posy);
			}
			//Akadaly
			else if(typeindex == 1) {
				addTrap(posx, posy);
			}
			//Varazsko
			else if(typeindex == 2) {
				addGemStone(gemstonebox.getSelectedIndex(),posx,posy);
			}
			else {
				JOptionPane.showMessageDialog(frame, "Itt van valami bibi, a kivalasztott type index ervenytelen!");
			}
		}
		//Meglevo terkepelem eltavolitas
		else if(functionindex == 1) {
			removeTower(posx, posy);
		}
		else {
			JOptionPane.showMessageDialog(frame, "Itt van valami bibi, a kivalasztott function index ervenytelen!");
		}
	}

	/**
	 * Play gombra kattintas
	 */
	private void clickedPlayButton() {
		//JOptionPane.showMessageDialog(frame, "Na majd ez lesz egyszer a play!");
		this.gametimer.setNormalSpeed();
	}

	/**
	 * Pause gombra kattintas
	 */
	private void clickedPauseButton() {
		JOptionPane.showMessageDialog(frame, "Nem erunk ra szunetet tartani!");
	}

	/**
	 * FFDW gombra kattintas
	 */
	private void clickedFfwdButton() {
		JOptionPane.showMessageDialog(frame, "Csak ne olyan gyorsan!");
	}
	
	/**
	 * Megadott X, Y koordinataertekek ellenorzese
	 */
	private boolean isValidCoordinates() {
		int posx, posy;
		try {
			posx = Integer.parseInt(xcoordfield.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "A megadott 'X' koordinata nem egesz tipus!");
			return false;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Valami gond van a megadott 'X' koordinata kornyeken!");
			return false;
		}
		
		try {
			posy = Integer.parseInt(ycoordfield.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "A megadott 'Y' koordinata nem egesz tipus!");
			return false;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Valami gond van a megadott 'Y' koordinata kornyeken!");
			return false;
		}
		
		if(posx > gamecontroller.getMap().getSize().getX()) {
			JOptionPane.showMessageDialog(frame, "Az 'X' koordinata a terkepen kivulre esik!");
			return false;
		}
		
		if(posy > gamecontroller.getMap().getSize().getY()) {
			JOptionPane.showMessageDialog(frame, "Az 'Y' koordinata a terkepen kivulre esik!");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Uj torony hozzaadasa
	 */
	private void addTower(double posx, double posy) {
		Map map = gamecontroller.getMap();
		
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Road.class) {
			JOptionPane.showMessageDialog(frame,"Uton nem helyeztheto el torony!");
			return;
		}
		
		Field field = (Field)map.getTile(posx, posy);
		if(field.getTower() != null) {
			JOptionPane.showMessageDialog(frame,"A mezon mar van torony!");
			return;
		}
		
		field.setTower();
		
		refreshLists();
	}
	
	/**
	 * Meglevo torony torlese
	 */
	public void removeTower(double posx, double posy) {
		Map map = gamecontroller.getMap();
		Tile tile = (map.getTile(posx,posy));
		
		if(tile.getClass() == Road.class) {
			JOptionPane.showMessageDialog(frame,"Uton alapbol nem lehet torony, igy nem nagyon lehet azt onnet eltavolitani!");
			return;
		}
		
		Field field = (Field)map.getTile(posx, posy);
		if(field.getTower() == null) {
			JOptionPane.showMessageDialog(frame,"A mezon nincs meg torony, nem lehet mit eltavolitani!");
			return;
		}
		
		field.resetTower();
		
		refreshLists();
	}
	
	/**
	 * Uj csapda hozzaadasa
	 */
	public void addTrap(double posx, double posy) {
		
		Map map = gamecontroller.getMap();
		
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Field.class) {
			JOptionPane.showMessageDialog(frame,"Mezon nem helyeztheto el akadaly!");
			return;
		}
		
		Road road = (Road)map.getTile(posx, posy);
		if(road.getTrap() != null) {
			JOptionPane.showMessageDialog(frame,"Az uton mar van akadaly!");
			return;
		}
		
		road.setTrap();
		
		refreshLists();
	}
	
	/**
	 * Uj varazsko hozzaadasa
	 */
	public void addGemStone(int type, double posx, double posy) {
		
		Map map = gamecontroller.getMap();
		
		Tile tile = (map.getTile(posx,posy));
		if(tile.getClass() == Field.class) {
			Field field = (Field)tile;
			if(field.getTower() == null) {
				JOptionPane.showMessageDialog(frame,"A mezon nincs torony, nem lehet mit varazskovezni!");
				return;
			}
			
			switch(type) {
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
		}
		else {
			Road road = (Road)tile;
			if(road.getTrap() == null) {
				JOptionPane.showMessageDialog(frame,"Az uton nincs akadaly, nem lehet mit varazskovezni!");
				return;
			}
			
			road.addPlusTime();
		}
		
		refreshLists();
	}

}
