package com.cowin.tracker.vaccine.processor;

import com.cowin.tracker.vaccine.util.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SlotFilter {

    private static final Logger logger = LoggerFactory.getLogger(SlotFilter.class);
    private final InformationProcessor processor;

    public SlotFilter(InformationProcessor processor) {
        this.processor = processor;
    }

    public void getSlotInformation(JSONObject response) {
        if (response.isEmpty()) {
            logger.info("no centres found");
        } else {
            JSONArray centres = response.getJSONArray(Constants.SLOT_CENTRES);
            List<JSONObject> a = processor.iterator(centres);
            System.out.println(a);
        }
    }
}
