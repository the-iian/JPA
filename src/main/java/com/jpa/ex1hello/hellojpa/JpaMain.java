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

            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // 영속성 컨텍스트 저장

            Member member = new Member();
            member.setUsername("member1");
            // member.setTeamId(team.getId()); member1을 TeamA에 소속시키기 (연관관계 없는 객체)
            member.changeTeam(team); // JPA가 알아서 팀에서 PK값을 꺼내오고 FK값에 insert할때 FK값을 사용한다 (연관관계 사용)
            em.persist(member);

            // team.getMembers().add(member);

            //1차캐시가 아닌 DB 쿼리 확인하는법
            em.flush(); // 강제호출
            em.clear(); // 영속성 컨텍스트 초기화 (DB 쿼리 호출)

            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
