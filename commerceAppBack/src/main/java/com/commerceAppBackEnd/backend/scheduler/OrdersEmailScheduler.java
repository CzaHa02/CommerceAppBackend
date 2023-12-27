package com.commerceAppBackEnd.backend.scheduler;

import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.service.DbService;
import com.commerceAppBackEnd.backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrdersEmailScheduler {
    @Autowired
    private EmailService emailService;

    @Autowired
    private DbService orderService;

    @Scheduled(cron = "0 0 6 * * ?")
    public void sendDailyOrderList(){
        List<Order>orders=orderService.getAllOrders();

        if (!orders.isEmpty()){
            String recipient = "EMAIL ODBIORCY";
            String subject="order list for: "+ LocalDate.now();
            StringBuilder content= new StringBuilder("Order list: ");

            for (Order order :orders){
                content.append(order.toString()).append("\n");
            }
            emailService.sendOrderList(recipient,subject,content.toString());
        }
    }

}
