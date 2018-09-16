package com.spring.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstApplicationTests {

	@Test
	public void contextLoads() {
	}
	public static void main(String[]args){
		int CPU_COUNT = Runtime.getRuntime().availableProcessors();
		System.out.println("CPU数为"+Runtime.getRuntime().availableProcessors()/2);
		System.out.println("核心线程数"+Math.max(4, Math.min(CPU_COUNT - 1, 5)));
	}

}
