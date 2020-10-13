package cinotification.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * todo Document type ResponseService
 */
@Component
public class ResponseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseService.class);

    protected String paramIsMissing(final String paramName) {
        return "Param '" + paramName + "' is missing";
    }
}
