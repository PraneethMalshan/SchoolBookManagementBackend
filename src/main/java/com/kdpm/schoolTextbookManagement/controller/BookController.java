package com.kdpm.schoolTextbookManagement.controller;

import com.kdpm.schoolTextbookManagement.dto.BookDTO;
import com.kdpm.schoolTextbookManagement.dto.request.BookUpdateDTO;
import com.kdpm.schoolTextbookManagement.dto.response.BookGetResponseDTO;
import com.kdpm.schoolTextbookManagement.service.BookService;
import com.kdpm.schoolTextbookManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired  //Container එකකට දාල තීන object/bean එකක් අපේ අවශ්ය වෙලාවෙදි අපි class එකකට inject කර ගන්නෙ @Autowired කියන annotation එක use කරලා.
    private BookService bookService;


    @PostMapping(path = {"/save"})  //me method eka post/save method ekak nisaa mee annotation eka daanawa.
    public ResponseEntity<StandardResponse> saveBook(@RequestBody BookDTO bookDTO){  //frontend ekee idala  ena request eka JSON Object ekak widiyata. eeka apee project eka aethule use karanna nam class type eka bawata bind kara ganna oona.(saralawa kiyanawa nm JSON object ekaka idala DTO ekata bind/convert kara ganna oona.) (Json walin aapu object eka DTO ekee class type ekata bine kara gannawa.->BookDTO)
        String message = bookService.saveBook(bookDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success", message),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateBook(@RequestBody BookUpdateDTO bookUpdateDTO){
        String message = bookService.updateBook(bookUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getBookById(@RequestParam(value = "id") int bookId){
        List<BookGetResponseDTO> bookGetResponseDTOS = bookService.getBookById(bookId);
        return new ResponseEntity<StandardResponse>(

                new StandardResponse(200, "Found", bookGetResponseDTOS),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-book/{id}")
    public ResponseEntity<StandardResponse> deleteBook(@PathVariable(value = "id") int bookId){
        String message = bookService.deleteBook(bookId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-books")
    public ResponseEntity<StandardResponse> getAllBooks(){
        List<BookDTO> allBooks = bookService.getAllBooks();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", allBooks),
                HttpStatus.OK
        );
    }

}
