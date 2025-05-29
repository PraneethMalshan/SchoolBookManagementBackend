package com.kdpm.schoolTextbookManagement.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
