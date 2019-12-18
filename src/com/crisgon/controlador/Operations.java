package com.crisgon.controlador;

import javax.swing.DefaultListModel;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import com.crisgon.modelo.Evento;

public class Operations {

	public static void insert(Object object) {
		
		ODB database = ODBFactory.open("D:\\EclipseProjects\\Neodatis\\DATABASE.db");
		
		if (database != null)
			database.store(object);
		
		database.close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static DefaultListModel selectEvento() {

		DefaultListModel defaultListModel = new DefaultListModel();
		
		ODB database = ODBFactory.open("D:\\EclipseProjects\\Neodatis\\DATABASE.db");
		
		Objects<Evento> objects = database.getObjects(Evento.class);

		while (objects.hasNext()) {
			Evento evento = objects.next();
			defaultListModel.addElement(evento);
		}
	
		database.close();
	
		return defaultListModel;
	}
	
}
