package com.mgp.usermanager.service.impl.UserServiceImpl;

import com.mgp.usermanager.beans.User;
import com.mgp.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)@Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Override
    public List<User> getUserInfo(String name) {
        List<User> userList2 = new ArrayList<>();
        String serverName = "usermanager";  //再框架里面可以访问，外面不行
        String url = "http://"+serverName+":8077/user/mgp";
        List<User> userList = restTemplate.getForObject(url, List.class);
        if(userList.size()==4){
            userList2.add(userList.get(0));
            return userList2;
        }
        return userList2;
    }
}
