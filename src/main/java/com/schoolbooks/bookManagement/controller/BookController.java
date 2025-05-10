package com.schoolbooks.bookManagement.controller;

import com.schoolbooks.bookManagement.dto.BookDTO;
import com.schoolbooks.bookManagement.service.BookService;
import com.schoolbooks.bookManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //Mee annotation eken thamayi meeka controller ekak kiyala define karanne. meyaagen thamayi client server architecture eka naththam REST API hadanna puluwan hakiyaawa labenne mee annotation eken. ee kiyanne meeken thamayi request ekak yawala response ekak ganna puluwan hakiyawa labenne.
@RequestMapping("/api/v1/book")
@CrossOrigin(origins = "http://localhost:3000")   //Frontend එකකින් Backend එකකට  request  එකක් දා නකො ට ඒ frontend එකේ තීන link එක තමා  backend එකට ඇවිල්ල ගහන්නෙ. හිතන්න Backend  එකෙන් data leak  වුනො ත් security process වලට මේක කවුරු හරි  දැ න ගත්තො ත් Backend එකට request  ගහන්න පුලුවන්. එතකොට Security  එක පිලිබද ප්රශ්නයක්නෙ.. එතකො ට @CrossOrigin එකෙන් කියන්න පුලුවන් මෙන්න මේ  link එකෙන් එන ඒව විතරක් ගන්න කියල.    ඒ කියන්නෙ අදා ල frontend එ එකෙන් විතරල් ආවො ත් Controller එක ඇතුලට දා න්න කියල.
public class BookController {

    @Autowired  //Container එකකට දාල තීන object/bean එකක් අපේ අවශ්ය වෙලාවෙදි අපි class එකකට inject කර ගන්නෙ @Autowired කියන annotation එක use කරලා.
    private BookService bookService;

    @PostMapping(path = {"/save"})  //me method eka post/save method ekak nisaa mee annotation eka daanawa.
    public ResponseEntity<StandardResponse> saveBook(@RequestBody BookDTO bookDTO){  //frontend ekee idala  ena request eka JSON Object ekak widiyata. eeka apee project eka aethule use karanna nam class type eka bawata bind kara ganna oona.(saralawa kiyanawa nm JSON object ekaka idala DTO ekata bind/convert kara ganna oona.) (Json walin aapu object eka DTO ekee class type ekata bine kara gannawa.->BookDTO)
        String message = bookService.saveBook(bookDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success",message),
                HttpStatus.CREATED
        );
    }

}

//post - save
//get - search
//put - update
//delete - delete

//1. JSON widhiyata ena request ekak kohomadha api spring project eka aethule ape class type ekata bind kara ganne? @RequestBody annotation eken.