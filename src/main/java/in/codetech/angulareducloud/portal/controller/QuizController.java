package in.codetech.angulareducloud.portal.controller;

import in.codetech.angulareducloud.portal.model.Quiz;
import in.codetech.angulareducloud.portal.service.Impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizServiceImpl quizService;

    @PostMapping("/save")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz addedQuiz = quizService.addQuiz(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedQuiz);
    }
    @PutMapping("/update")
    public  ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        Quiz updatedQuiz = quizService.updateQuiz(quiz);
        return ResponseEntity.ok(updatedQuiz);
    }

    @GetMapping("/get")
    public ResponseEntity<Set<Quiz>> getQuizzes(){
        Set<Quiz> quizzes = quizService.getQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long quizId){
        Quiz quiz = quizService.getQuiz(quizId);
        return ResponseEntity.ok(quiz);
    }

    @DeleteMapping("/{quizId}")
    public  ResponseEntity<Void> deleteQuiz(@PathVariable Long quizId){
        quizService.deleteQuiz(quizId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
