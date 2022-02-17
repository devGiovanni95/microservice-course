package com.giovanni.hrpayroll.services;

import com.giovanni.hrpayroll.entities.Payment;
import com.giovanni.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    /*Um modo de pegar uma propriedade/url trazendo assim para o
     projeto é definindo uma variavel nas configurações de propriedades
     do projeto com um nome e sua respectiva URL depois disso só fazer a chamada
      da variavel utilizando o VALUE com o nome da variavel entre cifrão e chaves
    */

    @Value("${hr-worker.host}")
    private  String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    //Metodo com uma regra de negorio
    public Payment getPayment(long workerId, int days) {

        Map<String, String>uriVariables = new HashMap<>();
        uriVariables.put("id", ""+ workerId);//modo de tranformar o atributo em uma string

//        Worker worker = restTemplate.getForObject(url, responseType)
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);//para usar o ForObject e necessario criar um mapeamento de antemao

//        return new Payment("Giovanni", 200.0, days);   dados mocados
        return new Payment(worker.getName(),worker.getDailyIncome(), days);
    }

}
