package com.crisgon.vista;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.crisgon.controlador.Operations;
import com.crisgon.controlador.QRGenerator;
import com.crisgon.modelo.Evento;
import com.crisgon.modelo.Tipo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insertar_Evento extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField tfLugar;
	private JTextField tfFecha;
	private JTextField tfAforo;
	private JTextField tfUrl;

	private JLabel lblImage;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Insertar_Evento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		datePicker.setBounds(0, 19, 100, -19);
		 
		contentPane.add(datePicker);
		
		tfLugar = new JTextField();
		tfLugar.setColumns(10);
		tfLugar.setBounds(100, 40, 182, 22);
		contentPane.add(tfLugar);

		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(100, 75, 182, 22);
		contentPane.add(tfFecha);

		tfAforo = new JTextField();
		tfAforo.setColumns(10);
		tfAforo.setBounds(100, 110, 182, 22);
		contentPane.add(tfAforo);

		tfUrl = new JTextField();
		tfUrl.setColumns(10);
		tfUrl.setBounds(100, 180, 182, 22);
		contentPane.add(tfUrl);

		JComboBox cbTipo = new JComboBox();
		cbTipo.setToolTipText("");
		cbTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		cbTipo.setBounds(100, 145, 182, 22);
		contentPane.add(cbTipo);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(32, 43, 36, 16);
		contentPane.add(lblLugar);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(32, 78, 36, 16);
		contentPane.add(lblFecha);

		JLabel lblAforo = new JLabel("Aforo");
		lblAforo.setBounds(32, 113, 31, 16);
		contentPane.add(lblAforo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(32, 148, 47, 16);
		contentPane.add(lblTipo);

		JLabel lblURL = new JLabel("URL");
		lblURL.setBounds(32, 183, 47, 16);
		contentPane.add(lblURL);

		lblImage = new JLabel("Image");
		lblImage.setBounds(305, 43, 100, 100);
		contentPane.add(lblImage);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(305, 215, 101, 25);
		contentPane.add(btnSalir);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StringBuilder sb = new StringBuilder();
				QRGenerator qrGenerator = new QRGenerator();

				String rutaFoto = "./QRCode.png";
				
				String lugar = tfLugar.getText();
				String fecha = tfFecha.getText();
				int aforo = Integer.parseInt(tfAforo.getText());
				Tipo tipo = (Tipo) cbTipo.getSelectedItem();
				String url = tfUrl.getText();
				
				sb.append("\n").append(fecha)
				.append("\n").append(aforo)
				.append("\n").append(tipo)
				.append("\n").append(url);
				
				qrGenerator.generateQRCodeImage(sb.toString(), 100, 100, rutaFoto);
				ImageIcon image = new ImageIcon(rutaFoto);
				lblImage.setIcon(image);
				
				byte[] codigoQR = qrGenerator.getQRCodeImage(sb.toString(), 100, 100);

				Operations.insert(new Evento(lugar, fecha, aforo, tipo, url, codigoQR));

			}
		});
		btnGuardar.setBounds(32, 215, 250, 25);
		contentPane.add(btnGuardar);

		JLabel lblEventos = new JLabel("INSERTAR EVENTO");
		lblEventos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEventos.setBounds(142, 11, 157, 16);
		contentPane.add(lblEventos);
	}

}
