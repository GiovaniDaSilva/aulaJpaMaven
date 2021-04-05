package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Giovani da Silva", "giovani@gmail.com");
		Pessoa p2 = new Pessoa(null, "Dayana Raymundo", "dayana@gmail.com");
		Pessoa p3 = new Pessoa(null, "Roni da Silva", "roni@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {

			//Inseri no banco
			 em.persist(p1);
			 em.persist(p2);
			 em.persist(p3);

			 //Recupera do banco
			Pessoa p = em.find(Pessoa.class, 1);
			
			//Remove do banco
			em.remove(p);

			System.out.println(p);

			System.out.println("Pronto");

		} finally {
			em.getTransaction().commit();
			em.close();
			emf.close();
		}

	}

}
