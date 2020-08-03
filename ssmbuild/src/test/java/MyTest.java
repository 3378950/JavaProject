import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Books;
import service.BookService;
import service.BookServiceImpl;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService  bookService = (BookService) context.getBean("BookServiceImpl");
        int i = bookService.deleteBookById(7);
        System.out.println(i);

    }
}
