package com.inturn.biz.web.controller;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.11
 * @see RestAPI를 통해 회원가입 및 수정에서 Select 선택값에 따른 학교정보, 자격증정보, 기업정보등을 Open API에서
 *      가져와 전달해주는 Controller
 */
@RestController
public class APIController {

	/**
	 * 
	 * @param sch1은  학교유형 고등학교의 경우에는 특성화고인지 일반고인지 같은 학교유형
	 * 		  gubun은 학교구분으로 고등학교인지 대학교인지, region은 지역이 어디인지
	 * @return 이 변수들을 학교 OpenAPI를 사용하여 Json형태로 학교이름을 가져와 다시 전달해준다.
	 */
	@RequestMapping(value = "/getSchoolList/{gubun}/{region}/{sch1}", method = RequestMethod.POST)
	public ResponseEntity<List<String>> getSchoolList(@PathVariable("gubun") String gubun,
			@PathVariable("region") String region, @PathVariable("sch1") String sch1) {
		ResponseEntity<List<String>> resEntity = null;
		try {
			List<String> list = new ArrayList<>();
			URL url = new URL("http://www.career.go.kr/cnet/openapi/getOpenApi?"
					+ "apiKey=7380fd93410c2a5571f013bbd976d24a"
					+ "&svcType=api&svcCode=SCHOOL&contentType=json"
					+ "&gubun="+gubun+"&region="+region+"&sch1="+sch1+"&perPage=10000");
			InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			JSONObject object = (JSONObject) JSONValue.parse(isr);
			JSONObject object2 = (JSONObject) object.get("dataSearch");
			JSONArray bodyArray = (JSONArray) object2.get("content");

			for (int i = 0; i < bodyArray.size(); i++) {
				JSONObject data = (JSONObject) bodyArray.get(i);
				list.add(data.get("schoolName").toString());
			}
			System.out.println(list);
			resEntity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
}
