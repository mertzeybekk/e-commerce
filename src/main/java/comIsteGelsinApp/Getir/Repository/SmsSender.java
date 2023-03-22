package comIsteGelsinApp.Getir.Repository;

import comIsteGelsinApp.Getir.Dto.Request.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
