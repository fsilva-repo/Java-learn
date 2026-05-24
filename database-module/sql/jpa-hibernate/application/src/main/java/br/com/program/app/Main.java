package br.com.program.app;

import br.com.program.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client();
        c1.setName("Marcos Moneiro");
        c1.setEmail("carlosm@mail.com");
        c1.setPhone(21977324083L);

        Client c2 = new Client();
        c2.setName("Sergio Barone");
        c2.setEmail("baronesegio@mail.com");
        c2.setPhone(2196732258L);

        Client c3 = new Client();
        c3.setName("Francine Araujo");
        c3.setEmail("francineara@mail.com");
        c3.setPhone(21968372084L);
        /**
         * O EntityManagerFactory é responsável por criar instâncias de EntityManager.
         * Ele atua como uma fábrica que gerencia o ciclo de vida dos EntityManagers em
         * uma aplicação.
         * É projetado para ser criado uma única vez durante o inicialização da
         * aplicação
         * Pode ser compartilhado entre múltiplas threads de forma segura
         * Deve ser mantido como um singleton na aplicação
         * Consome mais memória e tempo de inicialização
         * Contém configurações de persistência, mapeamentos de entidades, conexões com
         * banco de dados
         * Por isso não deve ser criado repetidament.
         * 
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jpa");
        EntityManager em = emf.createEntityManager();

        // ***** INSERINDO DADOS NO BANCO COM O TRANSITION E O PERSIST ***** //

        // em.getTransaction().begin();
        // em.persist(c1);
        // em.persist(c2);
        // em.persist(c3);
        // em.getTransaction().commit();

        // ***** OBTENDO OS DADOS COMO FIND ***** //
        Client client1 = em.find(Client.class, 4);
        System.out.println(client1.toString());
        em.close();
        emf.close();


    }
}













