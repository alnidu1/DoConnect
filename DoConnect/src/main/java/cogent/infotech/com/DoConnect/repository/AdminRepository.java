package cogent.infotech.com.DoConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.DoConnect.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
