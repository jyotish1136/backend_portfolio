package com.jyotish.portfolio.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contact")
@Data
public class Contact {
    private String name;
    private String email;
    private String message;
}

