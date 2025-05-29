package com.kdpm.schoolTextbookManagement.repository;

import com.kdpm.schoolTextbookManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository  //Repository ekak kiyala pennanna
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Integer> {    //wam paththata danne entity ekee name eka. dakunu paththata daanne entity ekee primary key ekee type eka.

}
