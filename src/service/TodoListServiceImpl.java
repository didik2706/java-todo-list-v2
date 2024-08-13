package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("==== TODO LIST ====");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);

        System.out.println("todo successfully added");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean isSuccess = todoListRepository.remove(number);
        if (isSuccess) {
            System.out.println("todo successfully removed");
        } else {
            System.out.println("todo failed removed");
        }
    }
}
