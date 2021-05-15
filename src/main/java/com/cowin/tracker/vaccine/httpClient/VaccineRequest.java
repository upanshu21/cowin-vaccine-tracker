package com.cowin.tracker.vaccine.httpClient;

import com.cowin.tracker.vaccine.util.APIConstants;
import com.cowin.tracker.vaccine.util.Constants;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class VaccineRequest {

    private static final Logger logger = LoggerFactory.getLogger(VaccineRequest.class);
    private final RestTemplate restTemplate;

    public VaccineRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JSONObject findSlotsByDistrict(String districtId, String date) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(APIConstants.DISTRICT_API)
                    .queryParam(Constants.DISTRICT_ID, districtId)
                    .queryParam(Constants.DATE, date);
            HttpEntity<?> request = new HttpEntity<>(buildRequest());
            ResponseEntity<String> response = restTemplate
                    .exchange(builder
                                    .build()
                                    .encode()
                                    .toUri(),
                            HttpMethod.GET,
                            request,
                            String.class);
            logger.info("receiving status: " + response.getStatusCode());
            return new JSONObject(response.getBody());
        } catch (RestClientResponseException ex) {
            return new JSONObject("{}", ex.getStatusText());
        }
    }

    private HttpHeaders buildRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(Constants.USER_AGENT, Constants.USER_AGENT_VALUE);
        return headers;
    }
}
