package org.example.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.model.ToDoEntity;
import org.example.model.ToDoRequest;
import org.example.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * 서비스는 우리가 구현해야할 구체적인 기능들을 포함한다.
 * 필요 기능:
 * 1. 아이템추가 add
 * 2. 특정 아이템 조회 searchById
 * 3. 전체 목록 조회 searchAll
 * 4. 특정 아이템 수정 
 * 5. 특정 아이템 삭제
 * 6. 전체 목록 삭제
 * */

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository repository;

    public ToDoEntity add(ToDoRequest req){
        ToDoEntity entity = new ToDoEntity();
        entity.setTitle(req.getTitle());
        entity.setOrder(req.getOrder());
        entity.setCompleted(req.getCompleted());
        return this.repository.save(entity);
    }

    public ToDoEntity searchById(Long id){
        return this.repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<ToDoEntity> searchAll(){
        return this.repository.findAll();
    }

    public void deleteById(Long id){
        this.repository.deleteById(id);

    }

    public void deleteAll(){
        this.repository.deleteAll();
    }


    public ToDoEntity updateById(Long id, ToDoRequest req){
        ToDoEntity entity = this.searchById(id);
        if (req.getTitle() != null){
            entity.setTitle(req.getTitle());
        }
        if (req.getOrder() != null){
            entity.setOrder(req.getOrder());
        }
        if (req.getCompleted()!=null){
            entity.setCompleted(req.getCompleted());
        }
        return this.repository.save(entity);
    }
}


