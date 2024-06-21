package in.codetech.angulareducloud.portal.service;

import in.codetech.angulareducloud.portal.model.Question;
import in.codetech.angulareducloud.portal.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz( );

    public void deleteQuestion(Long quesId);

    public Question get(Long questionId);
}
