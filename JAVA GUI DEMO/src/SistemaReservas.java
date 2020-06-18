import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class SistemaReservas {

	private JFrame frame;
	private JTextField IDCliente_Input;
	private JTextArea txtrServicio_1;
	private JComboBox comboBox;
	private JSlider slider;
	private JList list;
	
	private String IDCliente=" ";
	private String Servicio;
	private int hora;
	private int minutos;
	private int duracion;
	private int cont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaReservas window = new SistemaReservas();
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
	public SistemaReservas() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel DLM=new DefaultListModel();
		String fileName = "Reserva.txt";
		String line = null;	
		try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
                DLM.addElement(line);
                cont++;
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "No existe archvio" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error al leer" 
                + fileName + "'");                  
        }
		

		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(400, 400, 1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrIdCliente = new JTextArea();
		txtrIdCliente.setFont(new Font("MS Gothic", Font.BOLD, 90));
		txtrIdCliente.setText("ID Cliente ");
		txtrIdCliente.setBackground(SystemColor.menu);
		txtrIdCliente.setEditable(false);
		txtrIdCliente.setBounds(38, 52, 609, 110);
		frame.getContentPane().add(txtrIdCliente);
		
		IDCliente_Input = new JTextField();
		IDCliente_Input.setText(" ");
		IDCliente_Input.setFont(new Font("Tahoma", Font.PLAIN, 70));
		IDCliente_Input.setColumns(10);
		IDCliente_Input.setBounds(48, 168, 676, 84);
		frame.getContentPane().add(IDCliente_Input);

		
		txtrServicio_1 = new JTextArea();
		txtrServicio_1.setText("Servicio");
		txtrServicio_1.setFont(new Font("MS Gothic", Font.BOLD, 95));
		txtrServicio_1.setEditable(false);
		txtrServicio_1.setBackground(SystemColor.menu);
		txtrServicio_1.setBounds(987, 48, 609, 110);
		frame.getContentPane().add(txtrServicio_1);
		
		
		JTextArea txtrHora = new JTextArea();
		txtrHora.setText("Hora ");
		txtrHora.setFont(new Font("MS Gothic", Font.BOLD, 95));
		txtrHora.setEditable(false);
		txtrHora.setBackground(SystemColor.menu);
		txtrHora.setBounds(38, 315, 224, 110);
		frame.getContentPane().add(txtrHora);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("0");
		textArea.setFont(new Font("MS Gothic", Font.BOLD, 60));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(1600, 295, 117, 64);
		frame.getContentPane().add(textArea);
		
		JSlider slider = new JSlider();
		slider.setMaximum(120);
		slider.setMajorTickSpacing(10);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String s=Integer.toString(slider.getValue());
				textArea.setText(s);
			}
		});
		slider.setPaintTicks(true);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 27));
		slider.setValue(0);
		slider.setBounds(1204, 350, 538, 64);
		frame.getContentPane().add(slider);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object select1=comboBox.getSelectedItem();
				String Entero=select1.toString();
				String corto="";
				if(Entero.length()>5){
				corto=Entero.substring(0,5);
				}
		
				if(corto.contentEquals("B-012")) {
					slider.setMaximum(75);
				}
				else if(corto.contentEquals("C-002")) {
				   slider.setMaximum(30);
				}
				else if (corto.contentEquals("V-003")) {
				  slider.setMaximum(120);	
				}
				else if (corto.contentEquals("E-011")) {
				slider.setMaximum(60);	
				}
				else if(corto.contentEquals("F-003")) {
				slider.setMaximum(120);		
				}
				else if (corto.contentEquals("C-011")) {
				slider.setMaximum(60 );
				}
				else if (corto.contentEquals("E-002")) {
				slider.setMaximum(30);	
				}
				else if(corto.contentEquals("F-002")) {
				slider.setMaximum(60);	
				}
				else if (corto.contentEquals("E-012")) {
				slider.setMaximum(60);	
				}
				else if (corto.contentEquals("E-001")) {
				slider.setMaximum(30);
				}
				else if(corto.contentEquals("B-011")) {
				slider.setMaximum(75);
				}
				else if (corto.contentEquals("T-002")) {
				slider.setMaximum(60);
				}
				else if (corto.contentEquals("B-001")) {
				slider.setMaximum(45);
				}
				else if (corto.contentEquals("T-003")) {
				slider.setMaximum(120);	
				}
				else if(corto.contentEquals("F-001")) {
				slider.setMaximum(60);	
				}
				else if (corto.contentEquals("V-001")) {
				slider.setMaximum(60);	
				}
				else if (corto.contentEquals("F-004")) {
				slider.setMaximum(120);
				}
				else if(corto.contentEquals("T-001")) {
				slider.setMaximum(60);
				}
				else if (corto.contentEquals("C-001")) {
				slider.setMaximum(30);
				}
				else if (corto.contentEquals("V-002")) {
				slider.setMaximum(60);
				}
			
			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] {
		" ",
		"B-012 Bicicleta Spinning 2",
		"C-002 Caminadora De Alto Impacto",
		"V-003 Volley Ball",
		"E-011 Escaladora De Bajo Impacto" ,
		"F-003 Fronton" ,
		"C-011 Caminadora De Alto Impacto" , 
		"E-002 Escaladora De Alto Impacto" , 
		"F-002 Fronton" , 
		"E-012 Escaladora De Alto Impacto" ,
		"E-001 Escaladora De Bajo Impacto" , 
		"B-011 Bicicleta Spinning 1" ,
		"T-002 Tenis",
		"B-001 Bicicleta Estacionaria",
		"T-003 Tenis" ,
		"F-001 Fronton" , 
		"V-001 Volley Ball",
		"F-004 Fronton" ,
		"T-001 Tenis" ,
		"C-001 Aminadora De Bajo Impacto" , 
		"V-002 Volley Ball"
		}));
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 40));
		comboBox.setBounds(987, 168, 676, 84);
		frame.getContentPane().add(comboBox);

		JTextArea txtrDuracion = new JTextArea();
		txtrDuracion.setText("Duracion");
		txtrDuracion.setFont(new Font("MS Gothic", Font.BOLD, 85));
		txtrDuracion.setEditable(false);
		txtrDuracion.setBackground(SystemColor.menu);
		txtrDuracion.setBounds(788, 334, 388, 91);
		frame.getContentPane().add(txtrDuracion);
		
				
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(":");
		textArea_1.setFont(new Font("MS Gothic", Font.BOLD, 95));
		textArea_1.setEditable(false);
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(456, 325, 46, 110);
		frame.getContentPane().add(textArea_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 467, 1768, 24);
		frame.getContentPane().add(separator);
		
		JSpinner Hora_Input = new JSpinner();
		Hora_Input.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		Hora_Input.setFont(new Font("Tahoma", Font.PLAIN, 70));
		Hora_Input.setBounds(288, 322, 162, 99);
		frame.getContentPane().add(Hora_Input);
		
		JTextArea txtrminutos = new JTextArea();
		txtrminutos.setText("(Minutos)");
		txtrminutos.setFont(new Font("MS Gothic", Font.BOLD, 40));
		txtrminutos.setEditable(false);
		txtrminutos.setBackground(SystemColor.menu);
		txtrminutos.setBounds(1510, 418, 209, 49);
		frame.getContentPane().add(txtrminutos);
		
		JSpinner Minuto_Input = new JSpinner();
		Minuto_Input.setModel(new SpinnerNumberModel(0, 0, 59, 5));
		Minuto_Input.setFont(new Font("Tahoma", Font.PLAIN, 70));
		Minuto_Input.setBounds(512, 322, 162, 99);
		frame.getContentPane().add(Minuto_Input);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(1069, 468, 56, 644);
		frame.getContentPane().add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 561, 958, 450);
		frame.getContentPane().add(scrollPane);
		
		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);
		list_1.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		list_1.setModel(DLM);
		list_1.setToolTipText("");
		
		JButton btnYes = new JButton("Hacer \r\nReservacion");
		btnYes.setBackground(SystemColor.scrollbar);
		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 55));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IDCliente=IDCliente_Input.getText();
				
				Object select=comboBox.getSelectedItem();
				Servicio=select.toString();
				
				duracion=slider.getValue();
				
				Object select2=Hora_Input.getValue();
				String sHora=select2.toString();
				hora = Integer.parseInt(sHora);	
				
				Object select3=Minuto_Input.getValue();
				String sMinutos=select3.toString();
				minutos = Integer.parseInt(sMinutos);	
				
				if(Servicio!=" ") {
						if(duracion!=0) {
						cont++;
						String total=Servicio.substring(0,5)+" "+ sHora+" "+ sMinutos+" "+duracion+" "+IDCliente;
						DLM.addElement(total);
						list_1.setModel(DLM);
						
						IDCliente_Input.setText(" ");
						Hora_Input.setValue(0);
						Minuto_Input.setValue(0);	
						slider.setValue(0);
						comboBox.setSelectedIndex(0);
						
						JOptionPane.showMessageDialog(frame, "Reservacion Exsitosa");
						
					
				        String fileout = "Reserva.txt";

				        try {
				          
				            FileWriter fileWriter = new FileWriter(fileout);

				            
				            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				            
				            for(int i=0;i<cont;i++){
				            Object ob=DLM.get(i);
				            String s=ob.toString();
				            bufferedWriter.write(s);
				            bufferedWriter.write("\n");
				            }
				           
				            bufferedWriter.close();
				        }
				        catch(IOException ex) {
				            System.out.println(
				                "Error escribiendo archvio"
				                + fileout + "'");
				    				        }
						

					}else {
						JOptionPane.showMessageDialog(frame,"Establezca una duracion","Error",JOptionPane.WARNING_MESSAGE);
				}
				}
				else {
					JOptionPane.showMessageDialog(frame,"Servicio en blanco","Error",JOptionPane.WARNING_MESSAGE);
				
				}
				
				
			}
		});
		btnYes.setBounds(1164, 683, 520, 212);
		frame.getContentPane().add(btnYes);
		
		JTextArea txtrReservaciones = new JTextArea();
		txtrReservaciones.setText("Reservaciones");
		txtrReservaciones.setFont(new Font("MS Gothic", Font.BOLD, 75));
		txtrReservaciones.setEditable(false);
		txtrReservaciones.setBackground(SystemColor.menu);
		txtrReservaciones.setBounds(38, 483, 574, 91);
		frame.getContentPane().add(txtrReservaciones);
		
		

		



		

		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
