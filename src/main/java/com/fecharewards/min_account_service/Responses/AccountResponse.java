package com.fecharewards.min_account_service.Responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fecharewards.min_account_service.domains.Account;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class AccountResponse {


     String payername;
     int points;

    @JsonFormat(pattern = "MM/dd hh:mm a")
     LocalDateTime date;

    String username;


     public AccountResponse(Account account){
         payername=account.getPayer().getName();
          username=account.getUser().getName();
         date=account.getTransaction_date();


         points=account.getPoint();

     }



}
