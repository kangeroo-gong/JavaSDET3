package test_app.wework.testcase;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import test_app.wework.page.TodoPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoPageTest extends BaseTest{

    private TodoPage todoPage;

    @BeforeEach
    void setUp() {
        todoPage=mainPage.toTodoPage();
    }

    @AfterEach
    void tearDown(){
        todoPage.androidBack();
    }

    @Test
    @Order(1)
    void addTodo() {
        assertTrue(todoPage.addTodo("title").getTodo().contains("title"));
    }

    @Test
    @Order(2)
    void getTodo() {
        assert(todoPage.getTodo().size()==1);
    }

    @Test
    @Order(3)
    void doneTodo() {
        assertEquals(todoPage.doneTodo().getTodo().size(),0);
    }
}