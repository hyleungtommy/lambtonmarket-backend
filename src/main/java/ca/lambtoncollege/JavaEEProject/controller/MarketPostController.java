package ca.lambtoncollege.JavaEEProject.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ca.lambtoncollege.JavaEEProject.Services.MarketPostRepo;
import ca.lambtoncollege.JavaEEProject.model.MarketPost;

@Controller
public class MarketPostController {
	
	@Autowired
	MarketPostRepo marketPostRepo;
	
	@PostMapping("/createpost")
	public String createPost(@Valid MarketPost toSave, BindingResult bindingResult,@RequestParam("imageFile") MultipartFile file, Model model) {
		if(bindingResult.hasErrors()) {
			return "userinput";
		}else {
			if(file != null) {
				try {
					byte[] imgByte = convertToBytes(file);
					toSave.setImage(imgByte);
					marketPostRepo.save(toSave);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}else {
				marketPostRepo.save(toSave);
			}
			
			return "saved";
		}
	}

	
	private byte[] convertToBytes(MultipartFile file) throws IOException {
        byte[] byteObjects = new byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()) {
            byteObjects[i++] = b;
        }
        return byteObjects;
    }
	
	@GetMapping("/allposts")
	public String listAllPosts(Model model) {
		model.addAttribute("marketposts", this.marketPostRepo.findAll());
		return "marketpostlist";
	}
	
	@GetMapping("/createpost")
	public String getUserInput(Model model) {
		model.addAttribute("marketPost", new MarketPost());
		return "userinput";
	}

}
