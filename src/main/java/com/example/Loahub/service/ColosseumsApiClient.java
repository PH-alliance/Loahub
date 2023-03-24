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
    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAxMTI3MTUifQ.Oe1g04-1Vd3b5AGIGd4aVJuzbZr2wargshnTGhKqilDjkQ-M2OWIQO0avaCkPmuGwG5WrMuWK9Af5m5o-qNKe4shQccXMpOolMEWkTnme6so-r6I2u5G64OySCzBO7Tfe5ovpDmA0ZBgcZbTev8rWN7FdFNIgfHsU3g2Fk8r8hGIdxPMYJeFv1wFXHtvhpL7kmeTeWK3HX3M7sJZgNitJMX9gVSdavakjCdpV4o_7Rho6bPwcSmJ_Q0n4VQgUkWyvuEgjfFkAqp7JswZEXQxtspSfRZj0ST-gMR3dzlNno2JgQ-cpD7BA3oiROEgrNUP7t1DEMK6IKfG59f5khuvVg";
    private String reqURL = "https://developer-lostark.game.onstove.com/armories/characters/";


    public String readUrl(String characterName){
        String result = "";

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
            //값 출력으로 확인
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


        return result; // 두번째 사람부터는 첫번째사람의 정보에 이어서 JSON이 나옴.
    }


    public String readCharacter(String characterName){

        String result = "";

        try{
            //캐릭터이름을 url에 보내기위해 아스키코드로 인코딩
            String encodeRes = URLEncoder.encode(characterName, "UTF-8");
            //헤더를 포함한 Url 만들기
            URL url = new URL(reqURL + encodeRes + "/profiles");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();

            //값 출력으로 확인
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
        return result;
    }

    public JSONObject parseCompetitive(String result) throws ParseException{

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result); // Todo: 그런데 왜 여기에 null 들어가는가? result는 string형태로 잘 넘어온것이 확인됨
        JSONArray colArr = (JSONArray) object.get("Colosseums"); // 혹은 여기부터 널값발생지점으로 문제발생 추정

        /*
            //NullPointerException 발생 구간. colArr가 널값이라 colArr.size()를 인식할수없다. 왜 널값이 뜨는지에 대해 찾아야함.
            for(int i = 0; i<colArr.size(); i++){
                object = (JSONObject) colArr.get(i);
            }
*/
        JSONObject season3 = (JSONObject) colArr.get(3);
        JSONObject competitive = (JSONObject) season3.get("Competitive");
        //값 출력으로 확인
        System.out.println(competitive);
        return competitive;
    }


    public String parseCharacter(String result) throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result);
        String character = object.get("CharacterImage").toString();

        System.out.println(character);
        return character;
    }
}