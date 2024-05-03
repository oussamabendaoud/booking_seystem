
public class MyController {
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class MyController {

	    @GetMapping("/index")
	    public String hello(Model model) {
	        model.addAttribute("title", "Bonjour");
	        model.addAttribute("message", "Bienvenue sur notre application !");
	        return "index"; // le nom du fichier HTML Thymeleaf (sans l'extension)
	    }
	}

}
