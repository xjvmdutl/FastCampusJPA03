package com.fastcampus.jpa.FastCampusJPA03.repository;

import com.fastcampus.jpa.FastCampusJPA03.domain.Book;
import com.fastcampus.jpa.FastCampusJPA03.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void crudTest(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        //bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);
        System.out.println(">>>>" + bookReviewInfoRepository.findAll());
    }

    @Test
    public void crudTest2(){
        givenBookReviewInfo();

        //Sequence 같은경우 공용으로 사용하기 때문에 Book의 ID 값은 증가된 값으로 실행된다.
        Book result = bookReviewInfoRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();
        System.out.println(">>> " + result);

        BookReviewInfo result2 = bookRepository.findById(1L).orElseThrow(RuntimeException::new).getBookReviewInfo();
        System.out.println(">>> "+ result2);
    }

    private Book givenBook(){
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
        //book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);
        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }

}