package com.example.demoTask.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTask.exception.ResourceNotFoundException;
import com.example.demoTask.model.Task;
import com.example.demoTask.repository.TaskRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;

  // get all tasks
  @GetMapping("/tasks")
  public List<Task> getAllTasks(){
    return taskRepository.findAll();
  }

  // create task rest api
  @PostMapping("/tasks")
  public Task createTask(@RequestBody Task employee) {
    return taskRepository.save(employee);
  }

  // get task by id rest api
  @GetMapping("/tasks/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable Long id){
    Task employee = taskRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No task exists with id :" + id));
    return ResponseEntity.ok(employee);
  }

  // update task rest api

  @PutMapping("/tasks/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
    Task employee = taskRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id :" + id));

    employee.setTitle(taskDetails.getTitle());
    employee.setDescription(taskDetails.getDescription());
    employee.setComplete(taskDetails.isCompleted());

    Task updatedTask = taskRepository.save(employee);
    return ResponseEntity.ok(updatedTask);
  }

  // delete task rest api
  @DeleteMapping("/tasks/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id){
    Task task = taskRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id :" + id));

    taskRepository.delete(task);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}