package in.codetech.angulareducloud.portal.service;

import in.codetech.angulareducloud.portal.model.Category;
import in.codetech.angulareducloud.portal.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface QuizService {
    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

    public List<Quiz> getQuizzesOfCategory(Category category);

    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
