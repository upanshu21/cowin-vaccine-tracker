package com.cowin.tracker.vaccine.processor;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class InformationBuilder {

    JSONObject filteredResponse = new JSONObject();

    public JSONObject processResponse(JSONObject response) {
        filteredResponse.put("Address:", response.get("address"));
        filteredResponse.put("Name of Center:", response.get("name"));
        filteredResponse.put("session information:", response.getJSONArray("sessions"));
        return filteredResponse;
    }

}
