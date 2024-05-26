package com.Booking_seystem.Booking_seystem.dao.entities;
import com.Booking_seystem.Booking_seystem.dao.entities.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Size(min=2,max=15)
	private String nom ;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String adresse ;
	
	@Column(nullable = true, length = 64)
	private String photos;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
        return "/product-photos/" + photos;
    }


}
