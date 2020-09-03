package bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/notification")
public class HttpController extends CILongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpController.class);

    @GetMapping("/test")
    public void sendMessage(@RequestParam Map<String, String> params) {
        var buildNumber = params.get("buildNumber");
        var buildStatus = params.get("buildStatus");
        var buildLink = params.get("buildLink");
        var failedStage = params.get("failedStage");
        sendNotification(buildStatus, buildNumber, buildLink, failedStage);
    }

    @GetMapping("/test2")
    public String test2(@RequestParam Map<String, String> params) {
        var buildNumber = params.get("buildNumber");
        var buildStatus = params.get("buildStatus");
        return "buildNumber=" + buildNumber + " buildStatus=" + buildStatus;
        //        if (buildStatus.equals("Success")) {
//            return "Build №"+ buildNumber + " is " + buildStatus;
//        } else {
//            return "Build №"+ buildNumber + " is " + buildStatus;
//        }
    }
}
