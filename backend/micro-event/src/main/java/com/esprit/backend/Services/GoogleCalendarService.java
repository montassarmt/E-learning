package com.esprit.backend.Services;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;

@Service
public class GoogleCalendarService {
    private static final String APPLICATION_NAME = "E-Learning Event Manager";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "src/main/resources/credentials.json";
    private static final String CALENDAR_ID = "e3316dce20a429fd2de6edbe2b7b48b086088036d5f9a90f0cf196495a378efd@group.calendar.google.com";

    private HttpRequestInitializer getCredentials() throws IOException {
        // 👉 Charge depuis le classpath
        InputStream credentialsStream = getClass().getClassLoader().getResourceAsStream("credentials.json");
        if (credentialsStream == null) {
            throw new FileNotFoundException("credentials.json not found in classpath");
        }        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream)
                .createScoped(Collections.singletonList("https://www.googleapis.com/auth/calendar.events"));
        return new HttpCredentialsAdapter(credentials);
    }

    public Event addEventToCalendar(Event event) throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        HttpRequestInitializer credential = getCredentials();

        Calendar service = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        return service.events().insert(CALENDAR_ID, event).execute();
    }

    public Event createGoogleCalendarEvent(String title, Date startDate, Date endDate, String description) {
        Event event = new Event()
                .setSummary(title)
                .setDescription(description);

        EventDateTime start = new EventDateTime()
                .setDateTime(new com.google.api.client.util.DateTime(startDate));
        event.setStart(start);

        EventDateTime end = new EventDateTime()
                .setDateTime(new com.google.api.client.util.DateTime(endDate));
        event.setEnd(end);

        return event;
    }

    public void updateGoogleCalendarEvent(String eventId, Event updatedEvent) throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        HttpRequestInitializer credential = getCredentials();

        Calendar service = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        service.events().update(CALENDAR_ID, eventId, updatedEvent).execute();
    }

    public void deleteGoogleCalendarEvent(String eventId) throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        HttpRequestInitializer credential = getCredentials();

        Calendar service = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        service.events().delete(CALENDAR_ID, eventId).execute();
    }
}
