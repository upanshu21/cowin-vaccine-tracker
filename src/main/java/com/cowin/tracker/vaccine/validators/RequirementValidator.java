package com.cowin.tracker.vaccine.validators;

import com.cowin.tracker.vaccine.util.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequirementValidator {

    private static final Logger logger = LoggerFactory.getLogger(RequirementValidator.class);

    @Value("${cowin.age}")
    private int requiredAge;

    public boolean validateSlot(JSONArray session) {
        if (session.isEmpty()) {
            logger.debug("Empty session for for slot");
            return false;
        } else {
            JSONObject firstSession = session.getJSONObject(0);
            return isForRequiredAge(firstSession);
        }
    }

    public boolean isForRequiredAge(JSONObject jsonObject) {
        int ageResponse = jsonObject.getInt(Constants.SLOT_AGE);
        return ageResponse == requiredAge;
    }
}
