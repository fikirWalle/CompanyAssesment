package com.fecharewards.min_account_service.controllers;

import com.fecharewards.min_account_service.Responses.AccountResponse;
import com.fecharewards.min_account_service.domains.Account;
import com.fecharewards.min_account_service.service.AccountService;
import com.fecharewards.min_account_service.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {


      @Autowired
      AccountService accountservice;

     @PostMapping("/{userid}/{payerid}")
     public ResponseEntity<ApiResponse<AccountResponse>> AddPoints(@RequestBody() Account account,
                                                                    @PathVariable int userid,
                                                                    @PathVariable int payerid) {
         ApiResponse<AccountResponse> response = new ApiResponse<>();
         try {
             AccountResponse created = accountservice.addpoint(account,userid,payerid);
             response.setStatus(200);
             response.setData(created);
             response.setMessage("successfully add points to the user");
         } catch (Exception e) {
             response.setMessage(e.getMessage());
             response.setStatus(500);
         }
         return ResponseEntity.ok(response);
     }


      }

