package ru.netology.javacore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class TodosTests {
    String taskA = "A";
    String taskB = "B";
    Todos todos;

    @BeforeEach
    void initEach() {
        todos = new Todos();
    }

    @Test
    void successCreateTodosClassTest() {
        assertThat(todos, is(notNullValue()));
        assertThat(todos.todoList, is(notNullValue()));
    }

    @Test
    void addTaskTest() {
        todos.addTask(taskA);
        assertThat(taskA, equalTo(todos.todoList.get(0)));
    }

    @Test
    void removeTaskTest() {
        todos.todoList.add(taskA);
        todos.removeTask(taskA);
        assertThat(todos.todoList, is(empty()));
    }

    @Test
    void getAllTasksTest() {
        todos.todoList.add(taskB);
        todos.todoList.add(taskA);
        assertThat(todos.todoList, contains(taskB, taskA));
        assertThat(todos.getAllTasks(), equalTo(taskA + " " + taskB + " "));
    }
}