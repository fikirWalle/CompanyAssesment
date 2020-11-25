package com.fecharewards.min_account_service.service;

import com.fecharewards.min_account_service.Responses.PayerResponse;
import com.fecharewards.min_account_service.domains.Payer;
import com.fecharewards.min_account_service.repositories.PayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayerService {


    @Autowired
    PayerRepository payerrepository;

    public PayerResponse deductPointst(Payer payer, int payerid) throws Exception{

          Payer existedpayer=payerrepository.findById(payerid).orElse(null);

           if(existedpayer==null){

               throw new Exception("the payer not Found");

           }
           if(payer==null) {

               throw  new Exception("the data should be filled");
           }
           int payerpoint=existedpayer.getPoint();




                int incomingpoint=payer.getPoint();
                if(incomingpoint>0){
                    throw new Exception("your can only deduct points");
                }

           int currentpoint=payerpoint+incomingpoint;


        if(currentpoint< 0){

            throw new Exception("your account could be negative try again");
        }

                existedpayer.setPoint(currentpoint);
              payerrepository.save(existedpayer);

        return new PayerResponse(payerrepository.save(existedpayer));

    }

    public Payer getAmout(int payerid) throws Exception{

        Payer existedpayer=payerrepository.findById(payerid).orElse(null);

        if(existedpayer==null){

            throw new Exception("the payer not Found");

        }

        return   existedpayer;

    }

    public List<Payer> getAllPayerAmout() throws Exception{


       List<Payer>allpayer=payerrepository.findAll();
       if(allpayer==null){
           throw new Exception("payers not Registered Yet");
       }


        return  allpayer;

    }

}
