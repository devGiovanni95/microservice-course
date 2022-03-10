package com.giovanni.hrworker.resource;

import com.giovanni.hrworker.entities.Worker;
import com.giovanni.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope//atualizar em tempo de execuçao qualquer mudança do arquivo de configuração
@RestController
@RequestMapping(value="/workers")
public class WorkerResource {


    //Para escrever coisas no logger
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    //paratestar  buscar e acessar uma variavel de configuracao la no git
    @Value("${test.config}")
       private String testConfig;


    //ter acesso as portas que estao sendo utilizadas
    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();//pra nao ter corpo na resposta
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

       // Simulando uma Exception na requisicao e testando pra ver se a requisição chama o metodo alternativo
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//outra tentativa de teste
//        int x = 1;
//        if (x == 1) throw new RuntimeException("Test");

        logger.info("Port = " + env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
