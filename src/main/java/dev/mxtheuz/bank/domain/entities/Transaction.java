package dev.mxtheuz.bank.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transactions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private double amount;

    private String receiverId;
    private String senderId;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;
}
