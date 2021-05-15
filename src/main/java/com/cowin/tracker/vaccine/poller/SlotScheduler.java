package com.cowin.tracker.vaccine.poller;

import com.cowin.tracker.vaccine.config.TimeStamp;
import com.cowin.tracker.vaccine.httpClient.VaccineRequest;
import com.cowin.tracker.vaccine.processor.SlotFilter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SlotScheduler {

    private final VaccineRequest vaccineRequest;
    private final SlotFilter slotFilter;
    private final TimeStamp date;
    @Value("${cowin.district.id}")
    private String id;

    public SlotScheduler(VaccineRequest vaccineRequest, SlotFilter slotFilter, TimeStamp date) {
        this.vaccineRequest = vaccineRequest;
        this.slotFilter = slotFilter;
        this.date = date;
    }

    @Scheduled(fixedRate = 100000)
    public void pollSLotsForVaccination() {
        JSONObject response = vaccineRequest.findSlotsByDistrict(id, date.getTime());
        slotFilter.getSlotInformation(response);
    }
}
