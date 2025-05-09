package com.schoolbooks.bookManagement.dto;

import com.schoolbooks.bookManagement.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class BookDTO {

//    Layers athara data passkaranne meeken. controller ekata data enne meken. frontend eketh mee wagee ekak thiinna oona.
    private long id;
    private String bookName;
    private int totalQuantity;
    private int remainingQuantity;
}
