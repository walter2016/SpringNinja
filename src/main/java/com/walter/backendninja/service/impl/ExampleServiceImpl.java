package com.walter.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;


import com.walter.backendninja.model.Person;
import com.walter.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Walter", 25));
		people.add(new Person("Alex", 30));
		people.add(new Person("Jose", 95));
		people.add(new Person("Francisco", 65));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
