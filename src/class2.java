import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class class2 {

	private JFrame frmEtsikorvaa;
	private JTextField txtKorvaa;
	private JTextField txtEtsi;

	/**
	 * Launch the application.
	 */
	public static void etsiIkkuna() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					class2 window = new class2();
					window.frmEtsikorvaa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public class2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEtsikorvaa = new JFrame();
		frmEtsikorvaa.setTitle("Etsi/Korvaa");
		frmEtsikorvaa.setBounds(700, 100, 387, 122);
		frmEtsikorvaa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEtsikorvaa.getContentPane().setLayout(new GridLayout(2, 2, 2, 2));
		
		txtEtsi = new JTextField();
		frmEtsikorvaa.getContentPane().add(txtEtsi);
		txtEtsi.setColumns(10);
		
		JButton btnEtsi = new JButton("Etsi");
		btnEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				etsi();
			}
		});
		frmEtsikorvaa.getContentPane().add(btnEtsi);
		
		txtKorvaa = new JTextField();
		txtKorvaa.setText("");
		frmEtsikorvaa.getContentPane().add(txtKorvaa);
		txtKorvaa.setColumns(10);
		
		JButton btnKorvaa = new JButton("Korvaa");
		btnKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				korvaa();
				
			}
		});
		frmEtsikorvaa.getContentPane().add(btnKorvaa);
	}
	//etsii annetun arvon tekstin seasta
	public void etsi() {
		String sisalto = Tekstieditori.editorPane.getText();
		//System.out.print(sisalto);
		sisalto = sisalto.toLowerCase();
		String haettava = txtEtsi.getText();
		haettava = haettava.toLowerCase();
		//System.out.print(haettava);
		
		//int indeksi = sisalto.indexOf("kala");
		int indeksi = sisalto.indexOf(haettava, Tekstieditori.editorPane.getSelectionEnd());
		//System.out.println("Indeksi: "+ indeksi);
		
		
		Tekstieditori.editorPane.setSelectionStart(indeksi);
		Tekstieditori.editorPane.setSelectionEnd(indeksi+haettava.length());
		Tekstieditori.editorPane.setSelectionColor(Color.YELLOW);
		//, Tekstieditori.editorPane.getSelectionEnd()
		
	}
	
	public void korvaa() {
		String sisalto = Tekstieditori.editorPane.getText();
		
		sisalto = sisalto.toLowerCase();
		String haettava = txtEtsi.getText();
		String korvaava	= txtKorvaa.getText();
		int indeksi = sisalto.indexOf(haettava);
		String korvattu = sisalto.replaceAll(haettava,korvaava);
		
		Tekstieditori.editorPane.setText(korvattu);
		Tekstieditori.editorPane.setSelectionStart(indeksi);
		
		
		
	}

}