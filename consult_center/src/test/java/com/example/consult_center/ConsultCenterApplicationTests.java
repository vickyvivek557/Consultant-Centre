package com.example.consult_center;

import com.example.consult_center.Enum.Gender;
import com.example.consult_center.Enum.SessonStatus;
import com.example.consult_center.dto.inputDTO.ClientInput;
import com.example.consult_center.dto.outputDTO.ClientOutput;
import com.example.consult_center.model.ClientEntity;
import com.example.consult_center.repository.ClientRepository;
import com.example.consult_center.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsultCenterApplicationTests {

	@Autowired
	ClientServiceImpl clientService;

	@Autowired
	ClientRepository clientRepository;

	@Test
	public void registerClientTest(){
		ClientInput client = ClientInput.builder()
				.name("Client1")
				.age(24)
				.email("vk@gmail.com")
				.gender(Gender.MALE)
				.build();
		clientService.registerClient(client);
		ClientEntity expectedOutput = ClientEntity.builder()
				.name("Client1")
				.age(24)
				.email("vk@gmail.com")
				.gender(Gender.MALE)
				.build();

		ClientEntity actualOutput = clientRepository
				.findByEmail("vk@gmail,com");

		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getEmail(), actualOutput.getEmail());
		Assertions.assertEquals(expectedOutput.getGender(), actualOutput.getGender());
	}

	@Test
	void contextLoads() {
	}

}
