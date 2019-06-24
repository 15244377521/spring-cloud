package com.hellodemopeer;

import com.hellodemopeer.dao.GetUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RefreshScope
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
public class HellodemopeerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellodemopeerApplication.class, args);
    }

    @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;
    @Value("${password}")
    private String password;
    @Value("${header}")
    private String header;

    @Autowired
    private GetUserDao userDao;

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

@GetMapping("teacher")
    public Object getTeacher(@RequestParam("id")String id){
    System.out.println("我是客户端2===============");
    Random r = new Random();
    try {
        Thread.sleep(r.nextInt(200));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Teacher t = new Teacher();
    Map<String,Object> map = userDao.getUser(id);
    t.setAge(this.age);
    t.setHeader(this.header);
    t.setId((int)map.get("id"));
    t.setName((String)map.get("name"));
    t.setPassword(this.password);
    return t;
    }

    public class Teacher implements Serializable {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        private int id;
        private String name;
        private String age;
        private String password;
        private String header;
    }

}
