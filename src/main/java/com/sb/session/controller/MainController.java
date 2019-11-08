package com.sb.session.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class MainController {

    @GetMapping("/")
    public String getCookie(HttpSession session) {
        String sessionKey = session.getId();
        String userId = (String) session.getAttribute("ID");
        log.info("get userId = {}", session.getAttribute("ID"));
        if (userId == null) {
            session.setAttribute("ID", "김성범");
            userId = (String) session.getAttribute("ID");
            log.info("set userId = {}", userId);
        }
        System.out.println(userId);
        System.out.println(sessionKey);

        return sessionKey + "<br>" + userId;

//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders header = new HttpHeaders();
//        header.add(header.COOKIE, "SESSION="+ sessionKey);
//        HttpEntity<String> requestEntity = new HttpEntity<>(null, header);


//        ResponseEntity<String> cookieValue = restTemplate.exchange("http://localhost:80/request", HttpMethod.GET ,requestEntity ,String.class);
//        return "server1_sessionKey : "+session.getId()+"<br>server2_sessionKey : "+cookieValue.getBody();

    }

}
