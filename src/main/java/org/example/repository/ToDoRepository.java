package org.example.repository;

import org.example.model.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {

}

/**
 *우리는 디비에 이 투두엔티티만 저장을 하면 된다.
 * 투두 리스폰스, 투두 리퀘스트는 응답을 주고받는 모델이기 때문에 여기서 굳이 디비에 저장할 필욘 없다.
 * 그래서 현재 프로젝트에서는 투두레파지토리 하나만 만들 것이다.
 *
 * 이 녀석은 Jpa레파지토리를 상속하기 때문에, 우리는 정의하지 않았지만, 여러 부모 메소드들을 가져다 쓸 수 있다.
 * 예: crudRepository에 담긴 것들..
 *
 *  * 첫번째 인자 : 엔티티 타입.
 *  * 두번째 인자 : 아이디의 데이터 타입.
 * */
