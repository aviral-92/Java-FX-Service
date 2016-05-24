package com.db;

import org.springframework.web.client.RestTemplate;

public class Dbtest {

	public void test() {

		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject("http://localhost:8081/getDataSource", String.class);
		restTemplate.getForObject("http://localhost:8081/createDatabase", String.class);
	}

	public static void main(String[] args) {
		Dbtest dbtest = new Dbtest();
		dbtest.test();
	}
}
