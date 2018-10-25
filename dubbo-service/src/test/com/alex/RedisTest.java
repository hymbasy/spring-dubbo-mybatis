package com.alex;

import com.alex.model.Student;
import com.alex.service.MsgSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RedisTest {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private MsgSendService sendService;

    @Test
    public void test() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("name", "测试的名字");
        jedis.close();
    }

    @Test
    public void sendMessage() {
        Student student = new Student();
        student.setUserId(1);
        student.setGrade("高一");
        student.setSubject("数学");
        sendService.sendMessage(student);
    }
}
