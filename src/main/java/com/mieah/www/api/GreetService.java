package com.mieah.www.api;

import com.mieah.www.api.greet.GreetReply;
import com.mieah.www.api.greet.GreetRequest;

public interface GreetService {

    GreetReply sayHello(GreetRequest greetRequest);
}
