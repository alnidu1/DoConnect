package cogent.infotech.com.DoConnect.service;

import java.util.List;
import java.util.Optional;

import cogent.infotech.com.DoConnect.entity.Admin;

public interface AdminService {
	
	//C
	//R
	//U
	//D
	
	Admin createAdmin(Admin admin);
	List<Admin> readAllAdmin();
	Admin updateAdmin(int id, Admin admin);
	void deleteAdmin(int id);
	
	//other below
	
	Optional<Admin> findById(int id);
	

}
