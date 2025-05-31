package com.kdpm.schoolTextbookManagement.service.impl;

import com.kdpm.schoolTextbookManagement.dto.BookDTO;
import com.kdpm.schoolTextbookManagement.dto.request.BookUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.BookGetResponseDTO;
import com.kdpm.schoolTextbookManagement.entity.Book;
import com.kdpm.schoolTextbookManagement.repository.BookRepository;
import com.kdpm.schoolTextbookManagement.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String saveBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        if (!bookRepository.existsById(book.getBookId())){
            bookRepository.save(book);
            return book.getBookId() + " Saved Successfully ";
        } else {
            throw  new DuplicateKeyException("Already Added!!!");
        }
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {

        if (bookRepository.existsById(bookUpdateDTO.getBookId())){
            Book book = bookRepository.getReferenceById(bookUpdateDTO.getBookId());

            book.setTitle(bookUpdateDTO.getTitle());
            book.setSubject(bookUpdateDTO.getSubject());
            book.setGrade(bookUpdateDTO.getGrade());
            book.setTotalCount(bookUpdateDTO.getTotalCount());
            book.setAvailableCount(bookUpdateDTO.getAvailableCount());
            book.setReceivedDate(bookUpdateDTO.getReceivedDate());
            book.setBookImage(bookUpdateDTO.getBookImage());

            bookRepository.save(book);
            return bookUpdateDTO.getTitle() + " Updated Successfully ";

        } else {
            throw new RuntimeException("No Data Found for that ID!!!");
        }

    }

    @Override
    public List<BookGetResponseDTO> getBookById(int bookId) {
        List<Book> books = bookRepository.findBookByBookId(bookId);
        if (!books.isEmpty()){

            List<BookGetResponseDTO> bookGetResponseDTOS = books.stream()
                    .map(book -> modelMapper.map(book, BookGetResponseDTO.class))
                    .collect(Collectors.toList());
            return bookGetResponseDTOS;
        } else {
            throw new RuntimeException("No Data Found for that ID!!!");
        }
    }
}
