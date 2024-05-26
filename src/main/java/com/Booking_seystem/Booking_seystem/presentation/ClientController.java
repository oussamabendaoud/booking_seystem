package com.Booking_seystem.Booking_seystem.presentation;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import com.Booking_seystem.Booking_seystem.dao.entities.Client;
import com.Booking_seystem.Booking_seystem.dao.entities.FileUploadUtil;
import com.Booking_seystem.Booking_seystem.service.serviceImpl.ServiceClientImpl;
import com.Booking_seystem.Booking_seystem.dao.repositories.IClientRepo;
import com.Booking_seystem.Booking_seystem.service.Iservice.IServiceClient;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;



import jakarta.validation.Valid;
import lombok.AllArgsConstructor;



@Controller
@AllArgsConstructor
public class ClientController {
	private final IServiceClient sc;


	@GetMapping("/listerCl")
	public String getListCl(Model model, @RequestParam(defaultValue = "0") int numPage) {
	    Page<Client> list = sc.listerCl(numPage);
	    int pageCourante = numPage;
	    int totalPages = list.getTotalPages();
	    //int nextPage = (pageCourante + 1 < totalPages) ? pageCourante + 1 : pageCourante;
	    model.addAttribute("listCl", list);
	    model.addAttribute("pageCourante", pageCourante);
	    model.addAttribute("totalPages", totalPages);
	    //model.addAttribute("nextPage", nextPage);
	    return "index";
	}
	
	
	@GetMapping("/formAdd")
	public String getFormAdd(Model model) {
		model.addAttribute("client", new Client());
		return "formulaireADD";
	}

	@PostMapping("/insertClient")
	public String postInsertClient(@Valid Client client, BindingResult br, Model model,
	                               @RequestParam("image") MultipartFile multipartFile) {
	    if (br.hasErrors()) {
	        return "formulaireADD";
	    } else {
	        try {
	            // Sauvegarder le fichier s'il est présent
	            if (!multipartFile.isEmpty()) {
	                String fileName = multipartFile.getOriginalFilename();
	                client.setPhotos(fileName);
	                String uploadDir = "product-photos/"; // Répertoire de téléchargement des images
	                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	            }
	            // Ajouter le client
	            sc.ajouterCl(client);
	            return "redirect:/listerCl";
	        } catch (IOException e) {
	            // Gérer les erreurs d'entrée/sortie
	            e.printStackTrace(); // Ou logger l'erreur
	            return "error-page"; // Rediriger vers une page d'erreur
	        }
	    }
	}

	
	@GetMapping("/updateClient")
	public String getUpdateClientForm(@RequestParam("id") Integer id, Model model) {
		Client client = sc.chercherCl(id);
		model.addAttribute("client", client);
		return "formulaireUPDATE"; 
	}

	@PostMapping("/updateClient")
	public String postUpdateClient(Client c) {
		sc.modifierCl(c);
		return "redirect:/listerCl";
	}
	
	
	

	@GetMapping("/deleteClient")
	public String deleteClient(@RequestParam("id") Integer id) {
		sc.suppCl(id);
		return "redirect:/listerCl";
	}
	
	
	

}
