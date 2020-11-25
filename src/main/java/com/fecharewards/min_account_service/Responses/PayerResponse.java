package com.fecharewards.min_account_service.Responses;

import com.fecharewards.min_account_service.domains.Payer;
import lombok.Data;

@Data
public class PayerResponse {

      String payername;


      public PayerResponse(Payer payer){

          payername=payer.getName();



      }

}
