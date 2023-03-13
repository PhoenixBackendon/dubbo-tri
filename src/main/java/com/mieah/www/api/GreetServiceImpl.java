package com.mieah.www.api;

import com.mieah.www.api.greet.GreetReply;
import com.mieah.www.api.greet.GreetRequest;

public class GreetServiceImpl implements GreetService{
    @Override
    public GreetReply sayHello(GreetRequest greetRequest) {
        return GreetReply.newBuilder().setMessage(greetRequest.getName()).build();
    }
}
