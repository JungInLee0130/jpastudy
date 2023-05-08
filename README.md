# jpastudy

## 05.08
### Member.class(Dto)
- @Entity
- @Table(name = "USER")
- @Id
- @Column(name = "username")

### JpaMain
- Jpa의 모든 동작은 트랜잭션 내에서. 커밋까지는 스프링이 자동으로 해줌
- 삽입
- Member member = new Member();
- member.setId(1L)
- member.setName("HelloA");
-> 커밋시 자동으로 테이블안에 넣어줌
- 멤버 조회
- Member findMember = em.find(Member.class, 1L)
- 멤버 삭제
- em.remove(findMember)
- 멤버 수정
- findMember.setName("helloC")
- em.createQuery를 통해 쿼리문을 직접 작성할수도있음
