package org.demoassignment1.demoassignment1;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RecipientNotification {
    private String id;
    private String email;
    private String notificationId;
    private String status; // Sent, Outstanding, Failed

    public RecipientNotification(String email, String notificationId) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.notificationId = notificationId;
        this.status = "Outstanding";
    }
}
