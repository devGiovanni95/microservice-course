package com.giovanni.hrpayroll.services;

import com.giovanni.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    //Metodo com uma regra de negorio
    public Payment getPayment(long workerId, int days) {
        return new Payment("Giovanni", 200.0, days);
    }

}
