package bookshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.Role;
import bookshop.model.RoleName;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{
	Optional<Role> findByName(RoleName roleName);
}
