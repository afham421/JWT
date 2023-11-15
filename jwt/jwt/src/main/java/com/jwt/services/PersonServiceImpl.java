package com.jwt.services;

import com.jwt.Repository.PersonDao;
import com.jwt.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service  //// @Component you can use this also
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl {


	@Autowired
	private PersonDao personDao;


	public List<Person> getAllPerson() {
		List<Person> all = personDao.findAll();
		return all;
	}


	public Optional<Person> getPerson(int personid) {
		return personDao.findById(personid);
	}


	public Person addPerson(Person person) {

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		LocalDateTime dateTime = LocalDateTime.now();
//		String date = dateTime.format(formatter);
//		person.setInsertDate(date);

		Person save = personDao.save(person);
		return save;
	}


	public Person updatPerson(Person person) {
		personDao.save(person);

		return person;
	}


	public void deletPerson(Person person) {

		personDao.delete(person);
	}



}
