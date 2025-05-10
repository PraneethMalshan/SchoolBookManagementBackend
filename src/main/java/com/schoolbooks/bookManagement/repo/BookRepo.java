package com.schoolbooks.bookManagement.repo;

import com.schoolbooks.bookManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BookRepo extends JpaRepository<Book,Integer> {  //wam paththata danne entity ekee name eka. dakunu paththata daanne entity ekee primary key ekee type eka.

}
