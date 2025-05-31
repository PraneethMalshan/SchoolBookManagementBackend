package com.kdpm.schoolTextbookManagement.repository;

import com.kdpm.schoolTextbookManagement.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //Repository ekak kiyala pennanna
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Integer> { //wam paththata danne entity ekee name eka. dakunu paththata daanne entity ekee primary key ekee type eka.

    List<Book> findBookByBookId(int bookId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.bookId =:bookId")
    void deleteBookByBookId(@Param("bookId") int bookId);

}
