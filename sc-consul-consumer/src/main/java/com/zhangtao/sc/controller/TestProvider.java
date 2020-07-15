package com.zhangtao.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestProvider {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @RequestMapping("bcall")
    public String balancerCall(){
        //随机获取一个服务
        ServiceInstance instance = loadBalancerClient.choose("providerName");
        //获取服务的资源得治
        String url = instance.getUri().toString() + "test";
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url, String.class);
        System.out.println("return s is "+s );
        return s;
    }


    /**
     * 获取服务列表
     * @return
     */
    @RequestMapping("services")
    public List<String> getServices(){

        List<String> services = discoveryClient.getServices();
        return  services;

    }

    @RequestMapping("getservice")
    public  List<ServiceInstance>  getservice(){

        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        return provider;
    }

    @RequestMapping("call")
    public String  call(){

        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        if(provider!=null && provider.size()>0){
            RestTemplate template = new RestTemplate();
            ServiceInstance instance = provider.get(0);

            String forObject = template.getForObject(instance.getUri().toString() + "/test", String.class);
            return forObject;
        }
        return "no service";

    }
}
