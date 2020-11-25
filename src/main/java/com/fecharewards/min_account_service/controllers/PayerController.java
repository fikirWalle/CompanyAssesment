package com.fecharewards.min_account_service.controllers;

import com.fecharewards.min_account_service.Responses.PayerResponse;
import com.fecharewards.min_account_service.domains.Payer;
import com.fecharewards.min_account_service.service.PayerService;
import com.fecharewards.min_account_service.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payer")
public class PayerController {





    @Autowired
    PayerService payerservice;

    @PatchMapping ("/{payerid}")
    public ResponseEntity<ApiResponse<PayerResponse>> deductPoints(@RequestBody Payer payer,

                                                                   @PathVariable int payerid) {
        ApiResponse<PayerResponse> response = new ApiResponse<>();
        try {
            PayerResponse created = payerservice.deductPointst(payer,payerid);
            response.setStatus(200);
            response.setData(created);
            response.setMessage("successfully deduct" +payer.getPoint() +" Now ");
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{payerid}")
    public ResponseEntity<ApiResponse<Payer>> getPayerTotalAmount(@PathVariable int payerid) {
        ApiResponse<Payer> response = new ApiResponse<>();
        try {
            Payer created = payerservice.getAmout(payerid);
            response.setStatus(200);
            response.setData(created);
            response.setMessage("your current Balance is  ");
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Payer>>> getPayerAllPayers() {
        ApiResponse<List<Payer>> response = new ApiResponse<>();
        try {
           List<Payer> Payers= payerservice.getAllPayerAmout();
            response.setStatus(200);
            response.setData(Payers);
            response.setMessage("all Payeres List  ");
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(500);
        }
        return ResponseEntity.ok(response);
    }
}
