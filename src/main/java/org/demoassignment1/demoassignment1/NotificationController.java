package org.demoassignment1.demoassignment1;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService = new NotificationService();


    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification.getMessage(),
                notification.getIntradayHigh(), notification.getMarketCap(),
                notification.getVolume(), notification.getBtcPrice(), notification.getMarketRate());
    }

    @PostMapping("/{notificationId}/recipients")
    public String addRecipients(@PathVariable String notificationId, @RequestBody List<String> emails) {
        notificationService.addRecipents(notificationId, emails);
        return "Recipients added";
    }


    @PostMapping("/{notificationId}/send")
    public String sendNotification(@PathVariable String notificationId) {
        notificationService.sendNotifications(notificationId);
        return "Notification sent";
    }

    @GetMapping
    public List<Notification> getNotifications() {
        return notificationService.listNotifications();
    }

}
