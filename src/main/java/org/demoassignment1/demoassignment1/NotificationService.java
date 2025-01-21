package org.demoassignment1.demoassignment1;

import java.util.List;

public class NotificationService {
    private final NotificationRepository repository = new NotificationRepository();

    public Notification createNotification(String message, double intradayHigh,
                                           double marketCap, double volume, double btcPrice, double marketRate)  {
        Notification notification = new Notification(message, intradayHigh, marketCap, volume, btcPrice, marketRate);
        repository.saveNotification(notification);
        return notification;
    }


    public void addRecipents(String notificationId, List<String> emails) {
        for(String email : emails) {
            RecipientNotification recipientNotification = new RecipientNotification(notificationId, email);
            repository.saveRecipientNotification(recipientNotification);
        }
    }

    public void sendNotifications(String notificationId) {
        List<RecipientNotification> recipients = repository.findRecipientNotificationsByNotificationId(notificationId);

        for(RecipientNotification recipient : recipients) {
            try {
                System.out.println("Sending email to " + recipient.getEmail());
                repository.updateRecipientNotification(recipient.getId(), "SENT");
            }
            catch (Exception e) {
                repository.updateRecipientNotification(recipient.getId(), "FAILED");
            }
        }

    }

    public List<Notification> listNotifications() {
        return repository.getNotifications();
    }
}
