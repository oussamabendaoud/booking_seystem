package com.Booking_seystem.Booking_seystem.service.Iservice;

import java.util.List;

import org.springframework.data.domain.Page;
import com.Booking_seystem.Booking_seystem.dao.entities.Client;



public interface IServiceClient {
	public void ajouterCl(Client c);
	public void suppCl(Integer id);
	public void modifierCl(Client c);
	public Client chercherCl(Integer id);
	//public List<Client> listerCl();
	public Page<Client> listerCl(int numPage);

}
