package com.hellodemo.hellodemo;

import com.hellodemo.hellodemo.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
public class HelloDemoApplication {


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Value("${age}")
    private String age;
    @Value("${password}")
    private String password;
    @Value("${header}")
    private String header;

    @Autowired
    private UserDao userDao;




    @GetMapping("teacher")
    public  Object getTeacher(@Param("id") String id){
        System.out.println("我是客户端1~~~~~");
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        Teacher teacher = new Teacher();
        Map<String,Object> map = userDao.getUser(id);
        teacher.setId((int)map.get("id"));
        teacher.setAge(this.age);
        teacher.setHeader(this.header);
        teacher.setName((String)map.get("name"));
        teacher.setPassword(this.password);
        return teacher;
    }



    public class Teacher implements Serializable {
        private String name;
        private String age;
        private String password;
        private String header;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloDemoApplication.class, args);
    }

}
