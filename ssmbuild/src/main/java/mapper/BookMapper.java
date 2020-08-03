package mapper;


import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.util.List;

public interface BookMapper {
    int addBook(Books book);

    int deleteBookById(@Param("bookId") int id);

    int updateBook(Books book);

    Books queryBookById(@Param("bookId") int id);

    List<Books> queryAllBooks();

    Books queryBookByName(@Param("bookName")String bookName);
}
