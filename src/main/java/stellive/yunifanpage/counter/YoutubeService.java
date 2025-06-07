package stellive.yunifanpage.counter;

import lombok.Getter;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
@Getter
public class YoutubeService {

    private final String API_KEY = "AIzaSyA9uxGMa8IPlvsw3JFp7vL5UaLzQAJIWag"; // <- 발급받은 API 키 입력

    public String getViewCount(String videoId) throws JSONException {
        String url = "https://www.googleapis.com/youtube/v3/videos"
                + "?part=statistics"
                + "&id=" + videoId
                + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        String viewCount;
        viewCount = json
                .getJSONArray("items")
                .getJSONObject(0)
                .getJSONObject("statistics")
                .getString("viewCount");

        return viewCount;
    }
}