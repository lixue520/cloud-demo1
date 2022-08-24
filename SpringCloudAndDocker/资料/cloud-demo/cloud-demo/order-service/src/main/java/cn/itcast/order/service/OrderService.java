package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;
    //A.微服务远程调用方式
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.利用 RestTemplate发送http请求，查询用户
        String url = "http://localhost:8082/user/"+order.getUserId();
        //将json结果序列化成user对象（User.class）
        User user = restTemplate.getForObject(url,User.class);
        //3 数据封装
        order.setUser(user);
        // 4.返回
        return order;
    }
}
