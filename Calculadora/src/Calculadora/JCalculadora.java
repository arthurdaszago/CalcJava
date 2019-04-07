package Calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tfResult;
	
	Metodos ca = new Metodos();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 212, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalculadora = new JLabel("Calculadora");
		lblCalculadora.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCalculadora.setBounds(25, 5, 202, 33);
		contentPane.add(lblCalculadora);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 1");
		lblNmero.setBounds(10, 90, 66, 14);
		contentPane.add(lblNmero);
		
		JLabel lblNmero_1 = new JLabel("N\u00FAmero 2");
		lblNmero_1.setBounds(10, 132, 66, 14);
		contentPane.add(lblNmero_1);
		
		tf1 = new JTextField();
		tf1.setBounds(86, 88, 86, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(86, 129, 86, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JComboBox cbOperacoes = new JComboBox();
		cbOperacoes.setModel(new DefaultComboBoxModel(new String[] {"Soma", "Subtra\u00E7\u00E3o", "Multiplica\u00E7\u00E3o", "Divis\u00E3o", "Potencia\u00E7\u00E3o", "Radicia\u00E7\u00E3o"}));
		cbOperacoes.setBounds(10, 48, 162, 20);
		contentPane.add(cbOperacoes);
		
		JButton jbResultado = new JButton("=");
		jbResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double num1;
				double num2;
				num1=Double.parseDouble(tf1.getText());
				num2=Double.parseDouble(tf2.getText());
				ca.setNum1(num1);
				ca.setNum2(num2);
				
				if(cbOperacoes.getSelectedIndex()==0) {
					tfResult.setText(""+ca.soma());
				}else if(cbOperacoes.getSelectedIndex()==1) {
					tfResult.setText(""+ca.subtracao());
				}else if(cbOperacoes.getSelectedIndex()==2) {
					tfResult.setText(""+ca.multiplicacao());
				}else if(cbOperacoes.getSelectedIndex()==3) {
					tfResult.setText(""+ca.divisão());
				}else if(cbOperacoes.getSelectedIndex()==4) {
					tfResult.setText(""+ca.potenciacao());
				}else if(cbOperacoes.getSelectedIndex()==5) {
					tfResult.setText(""+ca.radiciacao());
				}
			}
		});
		jbResultado.setBounds(10, 170, 46, 23);
		contentPane.add(jbResultado);
		
		tfResult = new JTextField();
		tfResult.setEditable(false);
		tfResult.setBounds(66, 170, 106, 20);
		contentPane.add(tfResult);
		tfResult.setColumns(10);
	}
}
