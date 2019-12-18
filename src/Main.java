

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.crisgon.vista.Insertar_Evento;
import com.crisgon.vista.Vista_Evento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vista_Evento frame = new Vista_Evento();
					frame.setVisible(true);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(10, 11, 414, 94);
		contentPane.add(btnConsultar);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Insertar_Evento frame = new Insertar_Evento();
					frame.setVisible(true);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnInsertar.setBounds(10, 116, 414, 94);
		contentPane.add(btnInsertar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(10, 221, 414, 29);
		contentPane.add(btnSalir);
	}
}
