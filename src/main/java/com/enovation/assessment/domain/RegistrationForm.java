package com.enovation.assessment.domain;


import com.enovation.assessment.web.rest.validation.PasswordMatches;
import com.enovation.assessment.web.rest.validation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@PasswordMatches
@Data
public class RegistrationForm {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @ValidPassword
    private String password;

    @NotEmpty
    private String passwordRepeated;
}
