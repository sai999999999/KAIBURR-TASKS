package com.task1.task1.controller;

import com.task1.task1.model.Task;
import com.task1.task1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PutMapping(value = "/addServerDetails")
    public String saveServers(@RequestBody Task task) {
        repository.save(task);
        return "Added server with id : " + task.getId();
    }

    @GetMapping(value = "/findAllServers")
    public List<Task> getServers() {
        return repository.findAll();
    }

    @GetMapping(value = "/findAllServers/{id}")
    public Optional<Task> getServer(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteServer(@PathVariable int id) {
        repository.deleteById(id);
        return "Server deleted with id : " + id;
    }

}

