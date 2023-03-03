package com.example.Loahub.service;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RequiredArgsConstructor
@Service
public class ColosseumsApiClient {
   /*"%EA%B9%9C%EC%B0%8D%EC%81%98%EB%9D%A0";*/
    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAxMTI3MTUifQ.Oe1g04-1Vd3b5AGIGd4aVJuzbZr2wargshnTGhKqilDjkQ-M2OWIQO0avaCkPmuGwG5WrMuWK9Af5m5o-qNKe4shQccXMpOolMEWkTnme6so-r6I2u5G64OySCzBO7Tfe5ovpDmA0ZBgcZbTev8rWN7FdFNIgfHsU3g2Fk8r8hGIdxPMYJeFv1wFXHtvhpL7kmeTeWK3HX3M7sJZgNitJMX9gVSdavakjCdpV4o_7Rho6bPwcSmJ_Q0n4VQgUkWyvuEgjfFkAqp7JswZEXQxtspSfRZj0ST-gMR3dzlNno2JgQ-cpD7BA3oiROEgrNUP7t1DEMK6IKfG59f5khuvVg";
    private String reqURL = "https://developer-lostark.game.onstove.com/armories/characters/";

    private String result ="";
    public String readUrl(String characterName){

        try{
            //캐릭터이름을 url에 보내기위해 아스키코드로 인코딩
            String encodeRes = URLEncoder.encode(characterName, "UTF-8");
            //헤더를 포함한 Url 만들기
            URL url = new URL(reqURL + encodeRes + "/colosseums");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻어온 JSON타입 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";

            while((line = br.readLine()) != null){
                result += line;
            }
           // System.out.println("response body : " + result);

            br.close();

        } catch  (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public JSONObject parseJSON(String result) throws ParseException{

            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result);
            JSONArray colArr = (JSONArray) object.get("Colosseums");
            //colArr 값 확인

        /*
            //NullPointerException 발생 구간. colArr가 널값이라 colArr.size()를 인식할수없다. 왜 널값이 뜨는지에 대해 찾아야함.
            for(int i = 0; i<colArr.size(); i++){
                object = (JSONObject) colArr.get(i);
            }
*/
            JSONObject season3 = (JSONObject) colArr.get(3);
            JSONObject competitive = (JSONObject) season3.get("Competitive");
            System.out.println(competitive);
        return competitive;
    }
}