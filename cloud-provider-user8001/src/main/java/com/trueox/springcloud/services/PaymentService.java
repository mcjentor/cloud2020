package com.trueox.springcloud.services;

import com.trueox.springcloud.vo.Payment;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
