import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Tekstieditori extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	static JEditorPane editorPane = new JEditorPane();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tekstieditori frame = new Tekstieditori();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tekstieditori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				avaa();
				
			}
		});
		
		JMenuItem mntmUusi = new JMenuItem("Uusi");
		mntmUusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uusiTiedosto();
				
			}
		});
		mntmUusi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmUusi.setIcon(new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mnTiedosto.add(mntmUusi);
		mntmAvaa.setIcon(new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);
		
		JMenuItem mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				tallenna();
				
			}
		});
		mntmTallenna.setIcon(new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmTallenna);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmLopeta);
		
		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);
		
		JMenuItem mntmEtsi = new JMenuItem("Etsi...");
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				class2.etsiIkkuna();
				//////////
				
				
			}
		});
		
		JMenuItem mntmLeikkaa = new JMenuItem("Leikkaa");
		mntmLeikkaa.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Cut.png")));
		mntmLeikkaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mntmLeikkaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				editorPane.cut();
				
			}
		});
		mnMuokkaa.add(mntmLeikkaa);
		
		JMenuItem mntmKopioi = new JMenuItem("Kopioi");
		mntmKopioi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmKopioi.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		mntmKopioi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editorPane.copy();
				
			}
		});
		mnMuokkaa.add(mntmKopioi);
		
		JMenuItem mntmLiita = new JMenuItem("Liit\u00E4");
		mntmLiita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmLiita.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		mntmLiita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				editorPane.paste();
			}
		});
		mnMuokkaa.add(mntmLiita);
		mnMuokkaa.add(mntmEtsi);
		
		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				class2.etsiIkkuna();
			}
		});
		mnMuokkaa.add(mntmKorvaa);
		
		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);
		
		// Kuuntelija "Tietoja ohjelmasta" valinnalle. Näyttää message -dialogin teksteineen ja lisää siihen kuvan 
		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tietoja();
				
			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnUusi = new JButton("");
		btnUusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uusiTiedosto();
				
			}
		});
		btnUusi.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		toolBar.add(btnUusi);
		
		JButton btnAvaa = new JButton("");
		btnAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				avaa();
				
			}
		});
		btnAvaa.setIcon(new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		toolBar.add(btnAvaa);
		
		JButton btnTallenna = new JButton("");
		btnTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tallenna();
				
			}
		});
		btnTallenna.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		toolBar.add(btnTallenna);
		
		JButton btnLeikkaa = new JButton("");
		btnLeikkaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//leikkaa
				editorPane.cut();
				
			}
		});
		btnLeikkaa.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Cut-Black.png")));
		toolBar.add(btnLeikkaa);
		
		JButton btnKopioi = new JButton("");
		btnKopioi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kopio
				editorPane.copy();
				
			}
		});
		btnKopioi.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		toolBar.add(btnKopioi);
		
		JButton btnLiita = new JButton("");
		btnLiita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//liitä
				editorPane.paste();
				
			}
		});
		btnLiita.setIcon(new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		toolBar.add(btnLiita);
		
		editorPane.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		contentPane.add(editorPane, BorderLayout.CENTER);
	}
	
		//Luodaan tyhjä tiedosto
		public void uusiTiedosto() {
			
			
			Scanner lukija = null;
			File blankFile = new File("src//blank.txt");
			String rivi = "";
			
			
			try{
				lukija = new Scanner(blankFile);
				while(lukija.hasNextLine()) {
					rivi += lukija.nextLine()+"\n";
					System.out.println(rivi);
				}
			} catch (FileNotFoundException p ) {
				System.out.println("Virhe ladattaessa uutta tiedostoa!");
			}
			editorPane.setText(rivi);
		
	}
		// Avaa tiedoston
		public void avaa() {
			JFileChooser valintaikkuna = new JFileChooser();
			valintaikkuna.showOpenDialog(null);
			valintaikkuna.setApproveButtonText("Avaa tiedosto");
			valintaikkuna.setDialogTitle("Tiedoston valinta");
			
			Scanner lukija = null;
			String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
			//File tiedosto = new File("src//testi.txt");
			File tiedosto = new File(uusiTiedosto);
			String rivi = "";
			
			
			try{
				lukija = new Scanner(tiedosto);
				while(lukija.hasNextLine()) {
					rivi += lukija.nextLine()+"\n";
					System.out.println(rivi);
				}
			} catch (FileNotFoundException p ) {
				System.out.println("Tiedostoa ei löydy..");
			}
			editorPane.setText(rivi);
		
		}
	
		//Tallennetaan tiedosto
		public void tallenna() {
			JFileChooser valintaikkuna = new JFileChooser();
			valintaikkuna.showSaveDialog(null);
			String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
			
			//System.out.println("Kirjoitettava tiedosto: "+uusiTiedosto);
			
			
			try {
				PrintWriter writer = new PrintWriter(uusiTiedosto);
				//PrintWriter writer = new PrintWriter("testi.txt");
				String sisalto = editorPane.getText();
				
				writer.println(sisalto);
				writer.flush();
				writer.close();
			} catch (Exception e1) {
				System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
				e1.printStackTrace();
			}
			
		}
		
		
		//Tietoja ohjelmasta
		public void tietoja() {
			ImageIcon icon = new ImageIcon("res/images/IMG_0258.jpg");
			JOptionPane.showMessageDialog(null,
				    "Hi!\nI'm the creator.. (!)\n"
				    + "..of this software.\n"
				    + "This software is as fabulous as \n"
				    + "this chair I'm going to buy\n"
				    + "when I'm the trve DEVELOPER!\n"
				    + "\n"
				    + "(But I'm not there yet, because\n"
				    + "I couldn't include the picture\n"
				    + "into the JAR file)"
				    ,
				    "Tietoja ohjelmasta",
				    JOptionPane.PLAIN_MESSAGE,icon);
		}
		

}
