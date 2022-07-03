package com.example.user.service;

import com.example.user.entity.Users;
import com.example.user.repository.UserRepository;
import com.example.user.vo.Department;
import com.example.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users users){
        return userRepository.save(users);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users users = userRepository.getById(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ users.getDepartmentId(), Department.class);
        vo.setUsers(users);
        vo.setDepartment(department);
        log.info("****** vo {}", vo);
        return vo;
    }
}
