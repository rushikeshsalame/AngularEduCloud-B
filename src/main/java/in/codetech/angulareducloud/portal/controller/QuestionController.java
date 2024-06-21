package in.codetech.angulareducloud.portal.controller;

import in.codetech.angulareducloud.portal.model.Question;
import in.codetech.angulareducloud.portal.model.Quiz;
import in.codetech.angulareducloud.portal.service.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping("/save")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question addQuestion =questionService.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(addQuestion);
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        Question updateQuestion = questionService.updateQuestion(question);
        return ResponseEntity.ok(updateQuestion);
    }

    @GetMapping("/get")
    public ResponseEntity<Set<Question>> getQuestions(){
        Set<Question> questions = questionService.getQuestions();
        return ResponseEntity.ok(questions);
    }
    @GetMapping("/get/{quesId}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long questionId){
        Question question = questionService.getQuestion(questionId);
        if(question!=null){
            return ResponseEntity.ok(question);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/quiz/{QuizId}")
    public ResponseEntity<Set<Question>> getQuestionOfQuiz(@PathVariable Long quizId){
            return null;
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable Long questionId){
        questionService.deleteQuestion(questionId);
        return ResponseEntity.noContent().build();
    }
}
