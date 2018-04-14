package polinom;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;


public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField p1;
	private JTextField p2;
	private JTextField a;
	private JTextField d1;
	private JTextField d2;
	private JTextField ii1;
	private JTextField ii2;
	private JTextField s;
	private JTextField i;
	private JTextField r;
	private JTextField imp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		setFont(new Font("Monospaced", Font.PLAIN, 13));
		setTitle("BOGDAN POPA - CALCULATOR POLINOAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 596);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		p1 = new JTextField();
		p1.setBounds(63, 10, 132, 22);
		contentPane.add(p1);
		p1.setColumns(10);
			
		p2 = new JTextField();
		p2.setBounds(288, 10, 132, 22);
		contentPane.add(p2);
		p2.setColumns(10);
		
		a = new JTextField();
		a.setEditable(false);
		a.setBounds(191, 190, 158, 25);
		contentPane.add(a);
		a.setColumns(10);
		
		d1 = new JTextField();
		d1.setEditable(false);
		d1.setBounds(73, 70, 122, 22);
		contentPane.add(d1);
		d1.setColumns(10);
		
		d2 = new JTextField();
		d2.setEditable(false);
		d2.setBounds(298, 70, 122, 22);
		contentPane.add(d2);
		d2.setColumns(10);
		
		ii1 = new JTextField();
		ii1.setEditable(false);
		ii1.setBounds(89, 127, 106, 22);
		contentPane.add(ii1);
		ii1.setColumns(10);
		
		ii2 = new JTextField();
		ii2.setEditable(false);
		ii2.setBounds(314, 127, 106, 22);
		contentPane.add(ii2);
		ii2.setColumns(10);
		
		s = new JTextField();
		s.setEditable(false);
		s.setBounds(191, 257, 158, 22);
		contentPane.add(s);
		s.setColumns(10);
		
		i = new JTextField();
		i.setEditable(false);
		i.setBounds(191, 330, 158, 22);
		contentPane.add(i);
		i.setColumns(10);
		
		imp = new JTextField();
		imp.setBounds(115, 400, 116, 22);
		contentPane.add(imp);
		imp.setColumns(10);
		
		r = new JTextField();
		r.setEditable(false);
		r.setBounds(304, 400, 116, 22);
		contentPane.add(r);
		r.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setBackground(Color.BLACK);
		btnCalculate.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnCalculate.setBounds(162, 462, 116, 25);
		contentPane.add(btnCalculate);
		
		btnCalculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ArrayList<Polinom> rezimpartire = new ArrayList<Polinom>() ;
				Polinom pol1 = new Polinom();
				Polinom pol2 = new Polinom();
				Polinom rez = new Polinom();
				Operatie operatie = new Operatie();

				pol1.pol = p1.getText();
				pol2.pol = p2.getText();
				
				operatie.spargePolinom(pol1);
				operatie.spargePolinom(pol2);

				rez = operatie.adunare(pol1, pol2);
				rez.pol = rez.printPolinom();
				a.setText(rez.pol);	
			
				rez = operatie.scadere(pol1, pol2);
				rez.pol = rez.printPolinom();
				s.setText(rez.pol);	
				
				rez = operatie.inmultire(pol1, pol2);
				rez.pol = rez.printPolinom();
				i.setText(rez.pol);	
				
				rez = operatie.integrare(pol1);
				rez.pol = rez.printPolinom();
				ii1.setText(rez.pol);	
				
				rez = operatie.integrare(pol2);
				rez.pol = rez.printPolinom();
				ii2.setText(rez.pol);
				
				rez = operatie.derivare(pol1);
				rez.pol = rez.printPolinom();
				d1.setText(rez.pol);
				
				rez = operatie.derivare(pol2);
				rez.pol = rez.printPolinom();
				d2.setText(rez.pol);
				
				rezimpartire=operatie.impartire(pol1, pol2);
				rez.pol = rezimpartire.get(1).printPolinom(); // cat
				imp.setText(rez.pol);
				System.out.println(rez.pol);
				rez.pol = rezimpartire.get(0).printPolinom(); // rest
				r.setText(rez.pol);
				System.out.println(rez.pol);
			}
		});
		
		JTextArea txtrP = new JTextArea();
		txtrP.setEditable(false);
		txtrP.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrP.setBackground(Color.BLACK);
		txtrP.setForeground(Color.WHITE);
		txtrP.setText("P1(x)=");
		txtrP.setBounds(12, 10, 52, 22);
		contentPane.add(txtrP);
		
		JTextArea txtrP_1 = new JTextArea();
		txtrP_1.setEditable(false);
		txtrP_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrP_1.setForeground(Color.WHITE);
		txtrP_1.setBackground(Color.BLACK);
		txtrP_1.setText("P2(x)=");
		txtrP_1.setBounds(235, 10, 66, 22);
		contentPane.add(txtrP_1);
			
		JTextArea txtrPx = new JTextArea();
		txtrPx.setEditable(false);
		txtrPx.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPx.setText("P1(x)'=");
		txtrPx.setForeground(Color.WHITE);
		txtrPx.setBackground(Color.BLACK);
		txtrPx.setBounds(12, 70, 66, 22);
		contentPane.add(txtrPx);
		
		JTextArea txtrSPxdx = new JTextArea();
		txtrSPxdx.setEditable(false);
		txtrSPxdx.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrSPxdx.setText("SP1(x)dx=");
		txtrSPxdx.setForeground(Color.WHITE);
		txtrSPxdx.setBackground(Color.BLACK);
		txtrSPxdx.setBounds(12, 127, 92, 22);
		contentPane.add(txtrSPxdx);
		
		JTextArea txtrPp = new JTextArea();
		txtrPp.setEditable(false);
		txtrPp.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPp.setText("P1(x)+P2(x)=");
		txtrPp.setForeground(Color.WHITE);
		txtrPp.setBackground(Color.BLACK);
		txtrPp.setBounds(89, 191, 116, 22);
		contentPane.add(txtrPp);
		
		JTextArea txtrPxpx = new JTextArea();
		txtrPxpx.setEditable(false);
		txtrPxpx.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPxpx.setText("P1(x)/P2(x)=");
		txtrPxpx.setForeground(Color.WHITE);
		txtrPxpx.setBackground(Color.BLACK);
		txtrPxpx.setBounds(12, 400, 108, 22);
		contentPane.add(txtrPxpx);
		
		JTextArea txtrPp_2 = new JTextArea();
		txtrPp_2.setEditable(false);
		txtrPp_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPp_2.setText("P1(x)*P2(x)=");
		txtrPp_2.setForeground(Color.WHITE);
		txtrPp_2.setBackground(Color.BLACK);
		txtrPp_2.setBounds(89, 330, 108, 22);
		contentPane.add(txtrPp_2);
		
		JTextArea txtrPp_1 = new JTextArea();
		txtrPp_1.setEditable(false);
		txtrPp_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPp_1.setText("P1(x)-P2(x)=");
		txtrPp_1.setForeground(Color.WHITE);
		txtrPp_1.setBackground(Color.BLACK);
		txtrPp_1.setBounds(89, 257, 116, 22);
		contentPane.add(txtrPp_1);
		
		JTextArea txtrPx_1 = new JTextArea();
		txtrPx_1.setEditable(false);
		txtrPx_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPx_1.setText("P2(x)'=");
		txtrPx_1.setForeground(Color.WHITE);
		txtrPx_1.setBackground(Color.BLACK);
		txtrPx_1.setBounds(235, 70, 75, 22);
		contentPane.add(txtrPx_1);
		
		JTextArea txtrSpxdx = new JTextArea();
		txtrSpxdx.setEditable(false);
		txtrSpxdx.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrSpxdx.setText("SP2(x)dx=");
		txtrSpxdx.setForeground(Color.WHITE);
		txtrSpxdx.setBackground(Color.BLACK);
		txtrSpxdx.setBounds(235, 127, 92, 22);
		contentPane.add(txtrSpxdx);
		
		JTextArea txtrxNux = new JTextArea();
		txtrxNux.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrxNux.setText("1. In loc de +x foloseste +1x ");
		txtrxNux.setBackground(Color.RED);
		txtrxNux.setBounds(87, 500, 262, 22);
		contentPane.add(txtrxNux);
		
		JTextArea txtrCandO = new JTextArea();
		txtrCandO.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrCandO.setText("2. Casuta goala <= rezultat 0");
		txtrCandO.setBackground(Color.RED);
		txtrCandO.setBounds(89, 522, 238, 22);
		contentPane.add(txtrCandO);
		
		JTextArea txtrRx = new JTextArea();
		txtrRx.setForeground(Color.WHITE);
		txtrRx.setText("R(x)=");
		txtrRx.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrRx.setBackground(Color.BLACK);
		txtrRx.setBounds(260, 400, 52, 22);
		contentPane.add(txtrRx);
		
	}
}