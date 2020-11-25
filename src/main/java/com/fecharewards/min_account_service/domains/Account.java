package com.fecharewards.min_account_service.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
public class Account {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "MM/dd hh:mm a")
    private LocalDateTime transaction_date;

    @NotNull
    private int point;


   @OneToOne
   private User user;

   @OneToOne
   private Payer payer;


}
