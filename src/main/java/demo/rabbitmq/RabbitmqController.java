package demo.rabbitmq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitmqController {

    @Autowired
    Sender sender;

    @Autowired
    Receiver receiver;


    @GetMapping("/queues")
    public void queues() throws Exception {
        String hello = "HELLO";
        sender.run(hello);
    }


    @GetMapping("/retrieve")
    public ResponseEntity<?> retrieve(){
        return new ResponseEntity<>(receiver.getLatch(), HttpStatus.OK);
    }




}
