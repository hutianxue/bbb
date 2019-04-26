package com.buba.jedis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class JedisTest {

	@Test
	public void test() throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
		JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");
		String string = jedisCluster.get("key1");
		System.out.println(string);
		jedisCluster.close();
		//集群
		/*HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.64.129", 7001));
		nodes.add(new HostAndPort("192.168.64.129", 7002));
		nodes.add(new HostAndPort("192.168.64.129", 7003));
		nodes.add(new HostAndPort("192.168.64.129", 7004));
		nodes.add(new HostAndPort("192.168.64.129", 7005));
		nodes.add(new HostAndPort("192.168.64.129", 7006));		
		JedisCluster cluster = new JedisCluster(nodes);		
		cluster.set("key1", "1000");
		String string = cluster.get("key1");
		System.out.println(string);		
		cluster.close();*/
		//创建一个jedis的对象。
		/*Jedis jedis = new Jedis("192.168.64.129", 6379);
		//调用jedis对象的方法，方法名称和redis的命令一致。
		jedis.set("key1", "jedis test");
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis。
		jedis.close();*/


	}

}
