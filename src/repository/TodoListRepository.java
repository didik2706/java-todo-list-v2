package repository;

import entity.Todolist;

public interface TodoListRepository {
    // get all todo list
    Todolist[] getAll();
    // add todo list
    void add(Todolist todolist);
    // remove todo list
    boolean remove(Integer number);
}
