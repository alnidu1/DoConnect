package cogent.infotech.com.DoConnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.DoConnect.entity.Admin;
import cogent.infotech.com.DoConnect.repository.AdminRepository;

@Service
public class AdminServiceImpl  implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	@Override
	public List<Admin> readAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		admin.setId(id);
		return adminRepo.save(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		adminRepo.deleteById(id);
		
	}
	
	@Override
	public Optional<Admin> findById(int id) {
		// TODO Auto-generated method stub
		return adminRepo.findById(id);
	}


}
