package in.codetech.angulareducloud.portal.service.Impl;

import in.codetech.angulareducloud.portal.model.Question;
import in.codetech.angulareducloud.portal.model.Quiz;
import in.codetech.angulareducloud.portal.repository.QuestionRepository;
import in.codetech.angulareducloud.portal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz( ) {
       // return new HashSet<>(questionRepository.findAll());
        return null;
    }

    @Override
    public void deleteQuestion(Long quesId) {
        questionRepository.deleteById(quesId);
    }

    @Override
    public Question get(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }
}
