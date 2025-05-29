package com.kdpm.schoolTextbookManagement.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String fullName;
    private String role;
}
