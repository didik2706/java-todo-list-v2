package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while(true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("x. Exit");

            String input = InputUtil.input("Choose menu");
            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Menu not found");
            }
        }
    }

    public void addTodoList() {
        System.out.println("Add Todo List");

        String todo = InputUtil.input("Todo (press x to cancel)");
        if (todo.equals("x")) {
            showTodoList();
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("Remove Todo List");

        String number = InputUtil.input("Input Todo ID (press z to cancel)");
        if (number.equals("x")) {
            showTodoList();
        } else {
            todoListService.removeTodoList(Integer.parseInt(number));
        }
    }
}
