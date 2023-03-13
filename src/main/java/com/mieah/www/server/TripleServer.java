package com.mieah.www.server;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.mieah.www.api.GreetService;
import com.mieah.www.api.greet.GreetRequest;

import static com.mieah.www.constant.TripleConstants.NACOS_ADDRESS;

public class TripleServer {
    public static void main(String[] args) {
        ReferenceConfig<GreetService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(GreetService.class);
        DubboBootstrap.getInstance().application(new ApplicationConfig("triple-server"))
                .registry(new RegistryConfig(NACOS_ADDRESS))
                .reference(referenceConfig)
                .protocol(new ProtocolConfig(CommonConstants.TRIPLE, -1))
                .start();

        GreetService greetService = referenceConfig.get();
        System.out.println(greetService.sayHello(GreetRequest.newBuilder().setName("TopView").build()).getMessage());
    }
}
