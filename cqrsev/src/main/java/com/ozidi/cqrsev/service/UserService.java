package com.ozidi.cqrsev.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozidi.cqrsev.domains.Address;
import com.ozidi.cqrsev.domains.Contact;
import com.ozidi.cqrsev.domains.User;
import com.ozidi.cqrsev.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(Long userId, String firstName, String lastName) {
		User user = new User(userId, firstName, lastName);
		userRepository.save(user);
	}

	public void updateUser(Long userId, Set<Contact> contacts, Set<Address> addresses) {
		Optional<User> userFound = userRepository.findById(userId);
		userFound.get().setContacts(contacts);
		userFound.get().setAddresses(addresses);
		userRepository.save(userFound.get());
	}

	public Set<Contact> getContactByType(Long userId, String contactType) {
		Optional<User> userFound = userRepository.findById(userId);
		Set<Contact> contacts = userFound.get().getContacts();
		return contacts.stream().filter(c -> c.getType().equals(contactType)).collect(Collectors.toSet());

	}

	public Set<Address> getContactByRegion(Long userId, String state) {
		Optional<User> userFound = userRepository.findById(userId);
		Set<Address> addresses = userFound.get().getAddresses();
		return addresses.stream().filter(a -> a.getState().equals(state)).collect(Collectors.toSet());
	}
}
