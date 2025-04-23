package stellive.yunifanpage.home.controller;

import org.json.JSONException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import stellive.yunifanpage.home.service.YoutubeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CounterController {

    private final YoutubeService youtubeService;

    public CounterController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @GetMapping("/counter")
    public String counter(Model model) throws JSONException {
        String[] video_id = {"R_RAWjqdgTs","pkypi5nXSYM"};
        String[] video_name = {"SUPADOPA", "내꺼 하는 법"};
        String[][] videoList = new String[video_id.length][2];
        String view;
        for (int i = 0; i < video_id.length; i++) {
            view = (youtubeService.getViewCount(video_id[i]));
            videoList[i][0] = video_name[i];
            videoList[i][1] = view;
        }
        model.addAttribute("video", videoList);
        return "youtubeCounter";
    }
}
