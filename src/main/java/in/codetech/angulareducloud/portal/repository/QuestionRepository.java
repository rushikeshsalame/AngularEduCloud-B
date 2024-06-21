package in.codetech.angulareducloud.portal.repository;

import in.codetech.angulareducloud.portal.model.Question;
import in.codetech.angulareducloud.portal.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

}
