package org.demoassignment1.demoassignment1;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private final List<Notification> notifications = new ArrayList<>();
    private final List<RecipientNotification> recipientNotifications = new ArrayList<>();

    private void saveNotification(Notification notification) {
        notifications.add(notification);
    }

    private void saveRecipientNotification(RecipientNotification recipientNotification) {
        recipientNotifications.add(recipientNotification);
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public List<RecipientNotification> findRecipientNotificationsByNotificationId(String notificationId) {
        return recipientNotifications.stream().filter(recipientNotification ->
                recipientNotification.getNotificationId().
                        equals(notificationId)).collect(Collectors.toList());
    }

    public void updateRecipientNotification(String id, String status) {
        recipientNotifications.stream().
                filter(recipientNotification ->recipientNotification.getId().
                        equals(id)).findFirst().
                ifPresent(recipientNotification -> recipientNotification.setStatus(status));
    }


}
