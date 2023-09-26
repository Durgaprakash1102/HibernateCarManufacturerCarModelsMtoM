package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import Hibernate.entity.*;

public class Main {

	public static void main(String[] args) {
		
		//creating the objects for StandardServiceRegistry,Metadata,SessionFactory and Session
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		//creating a transaction
		Transaction t=session.beginTransaction();
		try {
			CarManufacturer cm=new CarManufacturer();
			cm.setManufacturingId(11);
			cm.setManufacturerName("Ford");
			
			CarManufacturer cm1=new CarManufacturer();
			cm1.setManufacturingId(22);
			cm1.setManufacturerName("Hyundai");
			
			CarModels m=new CarModels();
			m.setModelId(123);
			m.setModelName("Quest");
			
			CarModels m1=new CarModels();
			m1.setModelId(456);
			m1.setModelName("Accent");
			
			CarModels m2=new CarModels();
			m2.setModelId(789);
			m2.setModelName("Focus");
			
			cm.getModels().add(m);
			cm.getModels().add(m1);
			cm.getModels().add(m2);
			
			cm1.getModels().add(m);
			cm1.getModels().add(m1);
			cm1.getModels().add(m2);
			
			session.save(m);
			session.save(m1);
			session.save(m2);
			
			session.save(cm);
			session.save(cm1);
			
			t.commit();
			
		}finally {
			sfactory.close();
			session.close();
		}
	}

}
