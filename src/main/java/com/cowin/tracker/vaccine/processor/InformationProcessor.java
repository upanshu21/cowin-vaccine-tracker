package com.cowin.tracker.vaccine.processor;

import com.cowin.tracker.vaccine.util.Constants;
import com.cowin.tracker.vaccine.validators.RequirementValidator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InformationProcessor {

    private static final Logger logger = LoggerFactory.getLogger(InformationProcessor.class);

    private final InformationBuilder informationBuilder;
    private final RequirementValidator validate;

    private final List<JSONObject> listOfSlots = new ArrayList<>();

    public InformationProcessor(InformationBuilder informationBuilder, RequirementValidator validate) {
        this.informationBuilder = informationBuilder;
        this.validate = validate;
    }

    public List<JSONObject> iterator(JSONArray centres) {
        for (int pointer = 0; pointer < centres.length(); pointer++) {
            JSONObject result = getSession(centres.getJSONObject(pointer));
            if (result.isEmpty()) {
                logger.info("searching....");
            } else {
                JSONObject finalResult = informationBuilder.processResponse(result);
                listOfSlots.add(finalResult);
            }
        }
        return listOfSlots;
    }

    public JSONObject getSession(JSONObject slots) {
        JSONArray slot = slots.getJSONArray(Constants.SLOT_SESSIONS);
        if (validate.validateSlot(slot)) {
            return slots;
        } else {
            return new JSONObject("{}");
        }
    }
}
