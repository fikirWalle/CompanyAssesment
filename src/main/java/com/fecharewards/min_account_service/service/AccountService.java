package com.fecharewards.min_account_service.service;

import com.fecharewards.min_account_service.Responses.AccountResponse;
import com.fecharewards.min_account_service.domains.Account;
import com.fecharewards.min_account_service.domains.Payer;
import com.fecharewards.min_account_service.domains.User;
import com.fecharewards.min_account_service.repositories.AccountRepository;

import com.fecharewards.min_account_service.repositories.PayerRepository;
import com.fecharewards.min_account_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userrepository;

    @Autowired
    PayerRepository payerrepository;

    public AccountResponse addpoint(Account account, int userid, int payerid) throws Exception{

        User existeduser=userrepository.findById(userid).orElse(null);
        Payer existedpayer=payerrepository.findById(payerid).orElse(null);
        if(existeduser==null||existedpayer==null){

            throw new Exception("you are trying to add points to unknown Account");
        }


         int existedpoint=existedpayer.getPoint();

        int totalpont= existedpoint + account.getPoint();
        if(totalpont < 0){
            throw new Exception("you can not pay for the user");
        }
        existedpayer.setPoint(totalpont);

        account.setUser(existeduser);
        account.setPayer(existedpayer);

        LocalDateTime transctionTime = LocalDateTime.now();
        account.setTransaction_date(transctionTime);

        return new AccountResponse(accountRepository.save(account));

    }


}
