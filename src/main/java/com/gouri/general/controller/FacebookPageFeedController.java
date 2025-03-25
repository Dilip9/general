package com.gouri.general.controller;

import com.gouri.general.smhook.FacebookWebhook;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class FacebookPageFeedController {

    private final FacebookWebhook facebookWebhook;

    public FacebookPageFeedController(FacebookWebhook face) {
        facebookWebhook = face;
    }

     @GetMapping("/webhook")
     public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
                                                @RequestParam("hub.verify_token") String verifyToken,
                                                @RequestParam("hub.challenge") String challenge) {
         return facebookWebhook.verifyWebhook(mode, verifyToken, challenge);

     }
    @DeleteMapping("/webhook/delete")
    public ResponseEntity<String> verifyWebhook() {
        return facebookWebhook.deleteData();

    }

}
