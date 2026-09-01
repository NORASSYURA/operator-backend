package org.example.operatorbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "book_off_requests")
@Data
public class BookOffRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long operatorId;
    private LocalDate requestedDate;
    private String reason;
    private String status = "PENDING";
}

