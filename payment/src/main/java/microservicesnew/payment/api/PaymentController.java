package microservicesnew.payment.api;

import microservicesnew.payment.dto.PaymentDto;
import microservicesnew.payment.dto.UserDetailsDto;
import microservicesnew.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("payments")
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/{orderId}")
    public ResponseEntity<PaymentDto> initPayment(@PathVariable("orderId") int orderId, @RequestBody UserDetailsDto userDetailsDto) {
        return ResponseEntity.ok(paymentService.initPayment(orderId, userDetailsDto));
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<PaymentDto> getPaymentStatus(@PathVariable("orderId") int id) {
        PaymentDto paymentDto = paymentService.getPaymentStatus(id);
        if (paymentDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paymentDto);
    }
}
