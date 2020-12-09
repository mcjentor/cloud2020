package com.trueox.springcloud.controller;

import com.trueox.springcloud.services.PaymentService;
import com.trueox.springcloud.vo.CommonResult;
import com.trueox.springcloud.vo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("成功添加数据，插入结果："+ result);
        if(result >0)
        {
            return new CommonResult(200,"数据插入成功",result);
        }else {
            return new CommonResult(200,"数据插入失败",result);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("成功查询数据:" + payment);
        if(payment !=null)
        {
            return new CommonResult(200,"成功找到相应数据记录",payment);
        }else {
            return new CommonResult(200,"查无数据",payment);
        }

    }
}
