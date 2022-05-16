package com.ulstu.HomeBudget;

import com.ulstu.HomeBudget.Model.category_expense;
import com.ulstu.HomeBudget.Model.expense;
import com.ulstu.HomeBudget.Model.revenue;
import com.ulstu.HomeBudget.Model.source_revenue;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ulstu.HomeBudget.Model.family_member;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class HomeBudgetApplication {
    /*
    private static EntityManager em;


    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "JavaRush" );
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void close() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "sample" );
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // 1. New или Transient (временный)
        family_member family_member = new family_member();
        /**
         * (String surname, String middle_name, String name,
         *                          int age, String email)
         */
      /*  family_member.setSurname("Фамилия");
        family_member.setMiddle_name("Отчество");
        family_member.setName("Имя");
        family_member.setAge(35);
        family_member.setEmail("@gmail.com");

       */
// 2. Managed или Persistent
       // em.persist(family_member);
// 3. Транзакция завершена, все сущности в контексте detached
    //    em.getTransaction().begin();
    //    em.getTransaction().commit();
// 4. Сущность изымаем из контекста, она становится detached
    //    em.detach(family_member);


   /*     if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();

    */

//        SpringApplication.run(HomeBudgetApplication.class, args);
/*
        System.out.println("Im not here");


        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        System.out.println("Im here");
        SessionFactory sessionFactory = new Configuration()
        */

                // .addAnnotatedClass(family_member.class)
                //  .addAnnotatedClass(category_expense.class)
                //  .addAnnotatedClass(expense.class)
                //  .addAnnotatedClass(revenue.class)
                //  .addAnnotatedClass(source_revenue.class)
       /*         .buildSessionFactory();
        sessionFactory.close();
        System.out.println("Im here");
        System.out.println("Im not here");*/

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(category_expense.class)
                .addAnnotatedClass(expense.class)
                .addAnnotatedClass(family_member.class)
                .addAnnotatedClass(revenue.class)
                .addAnnotatedClass(source_revenue.class)
                .buildSessionFactory();

        int menu = 0;
      /*  while (Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int age = s.nextInt();)*/


        sessionFactory.close();

        System.out.println("It's work");

    }
}
