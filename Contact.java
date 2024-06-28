package project1.cs320.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record Contact(
		@NotBlank(message = "Field cannot be left blank")
		@Size(max = 10, message = "Entry cannot exceed {max} characters")
		String contactID,
		
		@NotBlank(message = "Field cannot be left blank")
		@Size(max = 10, message = "Entry cannot exceed {max} characters")
		String firstName,
		
		@NotBlank(message = "Field cannot be left blank")
		@Size(max = 10, message = "Entry cannot exceed {max} characters")
		String lastName,
		
		@NotBlank(message = "Field cannot be left blank")
		@Pattern(regexp = "\\d{10}", message = "Entry must be exactly 10 characters")
		String phone,
		
		@NotBlank(message = "Field cannot be left blank")
		@Size(max = 30, message = "Entry cannot exceed {max} characters")
		String address
) {}
