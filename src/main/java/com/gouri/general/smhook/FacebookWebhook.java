package com.gouri.general.smhook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FacebookWebhook {

    @Value("${social.config.verify_token}")
    private String SECRET_TOKEN;

    public FacebookWebhook(){
    }

    public ResponseEntity<String> verifyWebhook(String mode, String verifyToken, String challenge) {
        if("subscribe".equals(mode) && SECRET_TOKEN.equals(verifyToken)){
            log.info(" Webhook verified !! ");
            return ResponseEntity.ok(challenge);
        } else{
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Verification token");
        }
    }
    public ResponseEntity<String> deleteData(){
        return ResponseEntity.ok("Data got deleted");
    }


}
