import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WDIN {

	private JFrame frame;
	private JTextField Input;
	
	private String palabra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WDIN window = new WDIN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WDIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 561, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnWhatDoesIva = new JTextPane();
		txtpnWhatDoesIva.setEditable(false);
		txtpnWhatDoesIva.setBackground(SystemColor.menu);
		txtpnWhatDoesIva.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtpnWhatDoesIva.setText("What does Iva need?");
		txtpnWhatDoesIva.setBounds(17, 19, 503, 86);
		frame.getContentPane().add(txtpnWhatDoesIva);
		
		Input = new JTextField();
		Input.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
            	palabra=Input.getText();
				if(palabra.equals("Boyfriend")||palabra.equals("a boyfriend")||palabra.equals("boyfriend")) {
					JOptionPane.showMessageDialog(frame, "Correct");
					frame.getContentPane().setBackground(new Color(0, 128, 0));
					txtpnWhatDoesIva.setBackground(new Color(0, 128, 0));
				}else {
					JOptionPane.showMessageDialog(frame,"Incorrect","Error",JOptionPane.WARNING_MESSAGE);
					frame.getContentPane().setBackground(new Color(165, 42, 42));
					txtpnWhatDoesIva.setBackground(new Color(165, 42, 42));
				}
            }});
		Input.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Input.setBounds(85, 124, 342, 60);
		frame.getContentPane().add(Input);
		Input.setColumns(10);
		
		JButton btnSubmmit = new JButton("Submit ");
		btnSubmmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				palabra=Input.getText();
				if(palabra.equals("Boyfriend")||palabra.equals("a boyfriend")||palabra.equals("boyfriend")) {
					JOptionPane.showMessageDialog(frame, "Correct");
					frame.getContentPane().setBackground(new Color(0, 128, 0));
					txtpnWhatDoesIva.setBackground(new Color(0, 128, 0));
				}else {
					JOptionPane.showMessageDialog(frame,"Incorrect","Error",JOptionPane.WARNING_MESSAGE);
					frame.getContentPane().setBackground(new Color(165, 42, 42));
					txtpnWhatDoesIva.setBackground(new Color(165, 42, 42));
				}
			} 
		});
		btnSubmmit.setBounds(171, 236, 157, 46);
		frame.getContentPane().add(btnSubmmit);
	}
}
