package com.example.Loahub.controller.api;

import com.example.Loahub.service.ColosseumsApiClient;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/loahub")
public class ColosseumApiController {
    private final ColosseumsApiClient colosseumsApiClient;

    @GetMapping("/pvp")
    public String searchForm(HttpServletRequest httpServletRequest, Model model) throws IOException  {   
        String nickname = httpServletRequest.getParameter("nickname");
        String reqURL = "https://developer-lostark.game.onstove.com/armories/characters/";
        // 레헬 토큰 사용중
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAxMTI3MTUifQ.Oe1g04-1Vd3b5AGIGd4aVJuzbZr2wargshnTGhKqilDjkQ-M2OWIQO0avaCkPmuGwG5WrMuWK9Af5m5o-qNKe4shQccXMpOolMEWkTnme6so-r6I2u5G64OySCzBO7Tfe5ovpDmA0ZBgcZbTev8rWN7FdFNIgfHsU3g2Fk8r8hGIdxPMYJeFv1wFXHtvhpL7kmeTeWK3HX3M7sJZgNitJMX9gVSdavakjCdpV4o_7Rho6bPwcSmJ_Q0n4VQgUkWyvuEgjfFkAqp7JswZEXQxtspSfRZj0ST-gMR3dzlNno2JgQ-cpD7BA3oiROEgrNUP7t1DEMK6IKfG59f5khuvVg";
        String incodeName = URLEncoder.encode(nickname, "UTF-8");
        
        
        URL url = new URL(reqURL + incodeName + "/colosseums");
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setRequestProperty("Authorization", "Bearer " + token);
        int responseCode=conn.getResponseCode();
        System.out.println("responseCode: " + responseCode);

        try{
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            while(br.ready()){
                sb.append(br.readLine());
                
            }
        model.addAttribute("seasonName", sb.charAt(1761));
        }catch(Exception e){
            e.printStackTrace();
        }

       
        
        model.addAttribute("nickname", nickname);
        
        
    return "searchDisplay";
}
   


        
    
}


