package com.jpa.ex1hello.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            //비영속
            Member member = new Member();
            member.setId(100);
            member.setName("HelloJPA");

            //영속 - 이때는 DB에 저장되지않는다
            System.out.println("--- before ---");
            em.persist(member);
            System.out.println("--- after ---");

            Member findMember1 = em.find(Member.class, 101);
            Member findMember2 = em.find(Member.class, 101);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
