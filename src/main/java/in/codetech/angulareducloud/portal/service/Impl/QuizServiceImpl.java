package in.codetech.angulareducloud.portal.service.Impl;

import in.codetech.angulareducloud.portal.model.Category;
import in.codetech.angulareducloud.portal.model.Quiz;
import in.codetech.angulareducloud.portal.repository.QuizRepository;
import in.codetech.angulareducloud.portal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {

        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {

        return this.quizRepository.findById(quizId).orElse(null);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return null ;
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return null;
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return null;
    }
}
