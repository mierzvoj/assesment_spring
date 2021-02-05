package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

@Service
public class MessageService {


    public static Student textToStudent(Student receiver, String textMessage) {
        receiver.setMessage(textMessage);
        return receiver;
    }


}
