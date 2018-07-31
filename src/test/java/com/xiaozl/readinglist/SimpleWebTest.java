package com.xiaozl.readinglist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 由于springboot版本问题，无法引入，该测试类暂时无法使用
 * 暂时没法引入WebIntegrationTest
 * @SpringBootTest(classes = arrayOf(BootApplication::class), properties = arrayOf("server.port=8081"))
 * @WebAppConfiguration
 */
@SpringBootTest(classes = ReadinglistApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@WebIntegrationTest(randomPort=true)
public class SimpleWebTest {

  @Test(expected=HttpClientErrorException.class)
  public void pageNotFound() {
    try {
      RestTemplate rest = new RestTemplate();
      rest.getForObject("http://localhost:8080/bogusPage", String.class, 8080);
      fail("Should result in HTTP 404");
    } catch (HttpClientErrorException e) {
      assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
      throw e;
    }
  }
  
  @Test
  public void testRestTemplate() throws Exception {
    
    TestRestTemplate rest = new TestRestTemplate();
    String s = rest.getForObject("http://localhost:8080/bogusPage", String.class, 8000);
    System.out.println(s);
    
  }
  
}
