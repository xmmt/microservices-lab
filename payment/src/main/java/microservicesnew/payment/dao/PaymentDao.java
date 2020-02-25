package microservicesnew.payment.dao;

import microservicesnew.payment.dto.PaymentDto;
import microservicesnew.payment.dto.UserDetailsDto;


public interface PaymentDao {
    PaymentDto initPayment(int orderId, UserDetailsDto userDetails);

    PaymentDto getPaymentStatus(int orderId);
}

