package com.kdpm.schoolTextbookManagement.service;

import com.kdpm.schoolTextbookManagement.dto.BookDTO;
import com.kdpm.schoolTextbookManagement.dto.request.BookUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.BookGetResponseDTO;
import com.kdpm.schoolTextbookManagement.entity.Book;

import java.util.List;

public interface BookService {

    String saveBook(BookDTO bookDTO);

    String updateBook(BookUpdateDTO bookUpdateDTO);

    List<BookGetResponseDTO> getBookById(int bookId);

}
