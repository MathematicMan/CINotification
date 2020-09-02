package bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo Document type RestApi
 */
@RestController
@RequestMapping("/notification")
public class HttpController extends CIBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpController.class);

    @GetMapping("/test")
    public void sendMessage() {
        sendNotification();
    }

    @GetMapping("/test2")
    public String test2() {
        return "This is test";
    }
}
