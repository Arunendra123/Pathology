package DBManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Base.PathProperties;
import ExcelManager.PathItems;

public class ConnectToDB_H {
	public static Session sn;
	Configuration config;
	SessionFactory sf;
	
	public void createConnection() {
		config=new Configuration().configure().addAnnotatedClass(PathItems.class);
		PathProperties pp=new PathProperties();
		config.setProperty("hibernate.connection.driver_class", pp.getDBDriver());
		config.setProperty("hibernate.connection.url",pp.getDBUrl());
		config.setProperty("hibernate.connection.username", pp.getDBUserName());
		config.setProperty("hibernate.connection.password", pp.getDBPassword());
		config.setProperty("hibernate.dialect", pp.getDBDialect());
		sf=config.buildSessionFactory();
		sn=sf.openSession();
	}
	public Session getSession() {
		return sn;
	}
	public void close() {
		sn.close();
		sf.close();
	}
}
