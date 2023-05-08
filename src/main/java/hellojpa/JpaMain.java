package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // jpa 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }

            tx.commit(); // 정상적일땐 commit
        } catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        em.close();
        emf.close();
    }
}
