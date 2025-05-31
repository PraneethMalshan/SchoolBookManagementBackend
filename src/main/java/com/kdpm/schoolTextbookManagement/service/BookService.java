package com.kdpm.schoolTextbookManagement.service;

import com.kdpm.schoolTextbookManagement.dto.BookDTO;
import com.kdpm.schoolTextbookManagement.dto.request.BookUpdateDTO;
import com.kdpm.schoolTextbookManagement.entity.Book;

public interface BookService {

    String saveBook(BookDTO bookDTO);

    String updateBook(BookUpdateDTO bookUpdateDTO);
}
