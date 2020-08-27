package api;

import bot.CIBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * todo Document type RestApi
 */
@Path("notification")
public class RestApi extends CIBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestApi.class);

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public void sendMessage() {
        sendNotification();
    }

    @GET
    @Path("/test2")
    public String test2() {
        return "This is test";
    }
}
