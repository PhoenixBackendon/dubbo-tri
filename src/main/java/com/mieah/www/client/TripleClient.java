package com.mieah.www.client;


import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.mieah.www.api.GreetService;
import com.mieah.www.api.GreetServiceImpl;

import static com.mieah.www.constant.TripleConstants.NACOS_ADDRESS;

public class TripleClient {
    public static void main(String[] args) {
        ServiceConfig<GreetService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(GreetService.class);
        serviceConfig.setRef(new GreetServiceImpl());

        DubboBootstrap.getInstance()
                .application(new ApplicationConfig("mieah-triple-client"))
                .registry(new RegistryConfig(NACOS_ADDRESS))
                .protocol(new ProtocolConfig(CommonConstants.TRIPLE, -1))
                .service(serviceConfig)
                .start()
                .await();
    }
}
