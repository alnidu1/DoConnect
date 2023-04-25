package cogent.infotech.com.DoConnect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.com.DoConnect.entity.Admin;
import cogent.infotech.com.DoConnect.service.AdminServiceImpl;



@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	
	 @PostMapping("register")
	 public ResponseEntity<Admin> create(@RequestBody Admin admin) {
		Admin createdAdmin = adminService.createAdmin(admin);
	     return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
	 }
	@GetMapping("")
	  public List<Admin> readAll() {
	        return adminService.readAllAdmin();
	  }
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Admin> updateMovie(@PathVariable int id, @RequestBody Admin admin) {
	        Optional<Admin> updatedadmin =adminService.findById(id)
	                .map(existingMovie -> adminService.updateAdmin(id, admin));
	        return updatedadmin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
	        Optional<Admin> admin = adminService.findById(id);
	        if (admin.isPresent()) {
	            adminService.deleteAdmin(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}


