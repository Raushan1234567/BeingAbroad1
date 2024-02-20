package com.beingabroad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Institute {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @NotBlank
 @Size(min = 5, max = 20)
 private String name;

 @NotBlank
 @Size(min = 5, max = 100)
 private String location;

 @NotBlank

 @Pattern(regexp = "\\d{10}", message = "Contact info must be a 10-digit phone number")
 private String contactInfo;


}

