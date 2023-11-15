package com.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "person")
public class Person  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    @NotEmpty // for not null value
    @Size(min = 3 , max = 15, message = "name need to have only 10 characters") // for put size
    private String name;
    @NotEmpty
    @Size(min = 8, max = 10, message = "password need to have minimum 8 characters")
    private String pass;
    @NotEmpty
    @Size(min = 3, max = 10, message = "city need to have only 10 characters")
    private String city;
    @NotEmpty
    @Size(min = 5, max = 25, message = "email need to have max 25 characters")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"   //regexp means regular expression
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" , message = "plz enter valid Email! ")
    private String email ;

    @NotEmpty
    @Size(min  = 13 ,max = 13, message = "Phone No need to have max 13 characters")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" , message = "write number like this: +111 123 456 789")
    private String phoneNo;
    @NotEmpty
    @Size(min = 5, max = 15, message = "country need to have only 15 characters")
    private String country;

    @Enumerated(EnumType.STRING)
    private Role role;


}
