package com.xiaozl.readinglist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest // 通过springboot加载上下文
public class ReadingListRepositoryTest {

  @Autowired
  private ReadingListRepository repo;
  
  @Test
  @Transactional
  public void saveABook() throws Exception {
    assertEquals(0, repo.findAll().size());
    
    Book book = new Book();
    book.setTitle("TITLE");
    book.setDescription("DESCRIPTION");
    book.setAuthor("AUTHOR");
    book.setIsbn("1234567890");
    book.setReader("reader");    
    Book saved = repo.save(book);

    List<Book> founds = repo.findByReader(saved.getReader());
    Book found = founds.get(0);
    assertEquals(saved.getId(), found.getId());
    assertEquals("TITLE", found.getTitle());
    assertEquals("DESCRIPTION", found.getDescription());
    assertEquals("AUTHOR", found.getAuthor());
    assertEquals("1234567890", found.getIsbn());
    assertEquals("reader", found.getReader());
  }
  
}
