package com.springlec.base.service.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class NUserKaKaoServiceImpl implements NUserKaKaoService {
	
	private final String client_id = "ef894ee905a0643b7844daf7341d7569";
	private final String redirect_uri = "http://localhost:8080/oauth/kakao/";
	
	@Override
	public String getToken(String code) throws Exception {
		// TODO Auto-generated method stub
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");

			sb.append("&client_id=" + client_id); // REST_API키 본인이 발급받은 key 넣어주기
			sb.append("&redirect_uri=" + redirect_uri); // REDIRECT_URI 본인이 설정한 주소 넣어주기

			sb.append("&code=" + code);
			bw.write(sb.toString());
			bw.flush();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			// gson 객체 생성
			Gson gson = new Gson();
			
			// JSON String -> Map
			Map<String, Object> jsonMap = gson.fromJson(result, new TypeToken<HashMap<String, Object>>(){}.getType());

			access_Token = jsonMap.get("access_token").toString();
			refresh_Token = jsonMap.get("refresh_token").toString();

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	@Override
	public String getUserInfo(String access_token) throws Exception {
		// TODO Auto-generated method stub
		String email = "";
		String reqURL = "https://kapi.kakao.com/v2/user/me";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_token);

			int responseCode = conn.getResponseCode();
			//System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			//System.out.println("response body : " + result);

			try {
				// gson 객체 생성
				Gson gson = new Gson();
				
				// JSON String -> Map
				Map<String, Object> jsonMap = gson.fromJson(result, new TypeToken<HashMap<String, Object>>(){}.getType());

				Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");

				email = kakao_account.get("email").toString();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return email;
	}

	@Override
	public String getAgreementInfo(String access_token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
