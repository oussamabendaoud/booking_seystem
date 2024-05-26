package com.Booking_seystem.Booking_seystem.dao.repositories;
import com.Booking_seystem.Booking_seystem.dao.entities.Client;
import com.Booking_seystem.Booking_seystem.service.serviceImpl.ServiceClientImpl;
import com.Booking_seystem.Booking_seystem.service.Iservice.IServiceClient;
import com.Booking_seystem.Booking_seystem.dao.repositories.IClientRepo;

import org.springframework.data.jpa.repository.JpaRepository;



public interface IClientRepo extends JpaRepository<Client, Integer>{

}
