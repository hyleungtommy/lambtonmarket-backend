package ca.lambtoncollege.JavaEEProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import  org.apache.commons.codec.binary.Base64;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class MarketPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Size(min = 2, max = 40)
	private String name;
	
	private String description;
	
	
	
	@NotNull
	@Min(value = 1)
	private Double price;

	
	@Lob
	private byte[] image;
	
	public String getEncodedImage() {
		if(image != null) {
			System.out.println(Base64.encodeBase64String(image));
		}
		return (
				image != null? 
						Base64.encodeBase64String(image) : 
							"");
	}
}
