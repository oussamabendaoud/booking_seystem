package com.Booking_seystem.Booking_seystem.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Booking_seystem.Booking_seystem.dao.entities.Client;
import com.Booking_seystem.Booking_seystem.service.serviceImpl.ServiceClientImpl;
import com.Booking_seystem.Booking_seystem.service.Iservice.IServiceClient;
import com.Booking_seystem.Booking_seystem.dao.repositories.IClientRepo;

import lombok.AllArgsConstructor;





@Service
@AllArgsConstructor
@Transactional
public class ServiceClientImpl implements IServiceClient{
	private final IClientRepo cr;

	@Override
	public void ajouterCl(Client c) {
		cr.save(c);

	}

	@Override
	public void suppCl(Integer id) {
		Optional<Client> c=cr.findById(id);
		if(c.isEmpty())
			throw new RuntimeException("client not found");
		else
			cr.deleteById(id);

	}

	@Override
	public void modifierCl(Client c) {
		cr.save(c);

	}

	@Override
	public Client chercherCl(Integer id) {
		Optional<Client> c=cr.findById(id);
		if(c.isEmpty())
			throw new RuntimeException("client not found");
		else
			return c.get();
	}

	@Override
	public Page<Client> listerCl(int numPage) {

		return cr.findAll(PageRequest.of(numPage, 2));
	}

}
