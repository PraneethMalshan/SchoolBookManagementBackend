package com.schoolbooks.bookManagement.service.impl;

import com.schoolbooks.bookManagement.dto.BookDTO;
import com.schoolbooks.bookManagement.entity.Book;
import com.schoolbooks.bookManagement.repo.BookRepo;
import com.schoolbooks.bookManagement.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO,Book.class);
        if (!bookRepo.existsById(book.getBookId())){
            bookRepo.save(book);
            return book.getBookId() + " Saved Successfully! ";
        } else {
            throw new DuplicateKeyException(" Already Added ");
        }
    }
}
