package org.cheesecake.xrage.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String firstname;
    private String lastname;
    private String creationDate;
    private String birthday;
    private boolean isAdmin;
}
