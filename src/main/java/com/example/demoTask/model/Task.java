package com.example.demoTask.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "completed")
  private boolean completed;

  public Task() {

  }

  public Task(String title, String description, boolean completed) {
    super();
    this.title = title;
    this.description = description;
    this.completed = completed;
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public boolean isCompleted() {
    return completed;
  }
  public void setComplete(boolean completed) {
    this.completed = completed;
  }
}
