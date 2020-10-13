package bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.Map;

@RestController
@RequestMapping("/notification")
public class HttpController extends CILongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpController.class);
    private ResponseService responseService;

    HttpController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/buildStage")
    public void sendBuildStageMessage(@RequestParam Map<String, String> params) throws MalformedURLException {
        var buildNumber = params.get("buildNumber");
        var buildStatus = params.get("buildStatus");
        var buildLink = params.get("buildLink");
        var failedStage = params.get("failedStage");
        var jobName = params.get("jobName");
        if (buildStatus.isBlank()) {
            responseService.paramIsMissing(buildStatus);
        }
        if (buildNumber.isBlank()) {
            responseService.paramIsMissing(buildNumber);
        }
        if (jobName.isBlank()) {
            responseService.paramIsMissing(jobName);
        } else {
            sendNotification(jobName, buildStatus, buildNumber, buildLink, failedStage);
        }
    }

    @GetMapping("/deployStage")
    public void sendDeployStageMessage(@RequestParam Map<String, String> params) {
        var buildNumber = params.get("buildNumber");
        var buildStatus = params.get("buildStatus");
        var buildLink = params.get("buildLink");
        var failedStage = params.get("failedStage");
    }

    @GetMapping("/releaseStage")
    public void sendReleaseStageMessage(@RequestParam Map<String, String> params) {

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
