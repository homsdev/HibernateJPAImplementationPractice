package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.homsdev.model.helloworld.Message;

public class PersistenceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message msg = new Message();
		msg.setText("Hello!");
		System.out.println(msg.getText());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(msg);
		
		long id= 1;
		Message result= em.find(Message.class, id);

		em.getTransaction().commit();
		em.close();
		
		System.out.println(result);
		
	}

}
