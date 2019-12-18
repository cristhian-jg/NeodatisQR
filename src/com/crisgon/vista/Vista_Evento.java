package com.crisgon.vista;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.crisgon.controlador.Operations;
import com.crisgon.modelo.Evento;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista_Evento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private JLabel lblTablaEventos;
	private JButton btnSalir;

	public Vista_Evento() {
		setBackground(UIManager.getColor("Button.background"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 514, 283);
		contentPane.add(scrollPane);

		table = new JTable();
		defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Lugar", "Fecha", "Aforo", "Tipo", "URL" });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lugar", "Fecha", "Aforo", "Tipo", "URL"
			}
		));
		scrollPane.setViewportView(table);
		generarTabla();

		lblTablaEventos = new JLabel("TABLA EVENTOS");
		lblTablaEventos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTablaEventos.setBounds(206, 11, 136, 14);
		contentPane.add(lblTablaEventos);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(10, 327, 514, 23);
		contentPane.add(btnSalir);
	}

	public void generarTabla() {

		@SuppressWarnings("rawtypes")
		DefaultListModel defaultListModel = Operations.selectEvento();
		for (int i = 0; i < defaultListModel.size(); i++) {
			Evento evento = (Evento) defaultListModel.getElementAt(i);
			Object[] eventos = { evento.getLugar(), evento.getFecha(), evento.getAforo(), evento.getTipo(),
					evento.getUrl(), evento.getCodigoQR() };
			defaultTableModel.addRow(eventos);
		}
		table.setModel(defaultTableModel);
	}
}
