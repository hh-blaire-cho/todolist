package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.ToDoEntity;
import org.example.model.ToDoRequest;
import org.example.model.ToDoResponse;
import org.example.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/")
public class ToDoController {
    private final ToDoService service;

    @PostMapping
    public ResponseEntity<ToDoResponse> create(@RequestBody ToDoRequest req) {
        System.out.println("CREATE");
        if (ObjectUtils.isEmpty(req.getTitle())) {
            return ResponseEntity.badRequest().build();
        }
        if (ObjectUtils.isEmpty(req.getOrder())) {
            req.setOrder(0L);
        }
        if (ObjectUtils.isEmpty(req.getCompleted())) {
            req.setCompleted(false);
        }
        ToDoEntity result = this.service.add(req);
        return ResponseEntity.ok(new ToDoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<ToDoResponse> readOne(@PathVariable Long id) {
        log.info("READ ONE");
        ToDoEntity result = this.service.searchById(id);
        return ResponseEntity.ok(new ToDoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<ToDoResponse>> readAll() {
        log.info("READ ALL");
        List<ToDoEntity> results = this.service.searchAll();
        List<ToDoResponse> responses = results.stream().map(ToDoResponse::new).toList();
        return ResponseEntity.ok(responses);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ToDoResponse> update(@PathVariable Long id,
        @RequestBody ToDoRequest req) {
        log.info("UPDATE");
        ToDoEntity result = service.updateById(id, req);
        return ResponseEntity.ok(new ToDoResponse(result));
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        log.info("DELETE ALL");
        service.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE");
        service.deleteById(id); //void
        return ResponseEntity.ok().build();
    }
}



