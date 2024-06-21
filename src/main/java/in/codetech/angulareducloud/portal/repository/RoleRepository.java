package in.codetech.angulareducloud.portal.repository;

import in.codetech.angulareducloud.portal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
