package in.anuja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.anuja.dao.QuizDao;
import in.anuja.model.Question;

@Controller
public class QuizEntryFormController {

	@Autowired
	QuizDao quizDao;
	@GetMapping("/add-question")
	public String quizAddQuestionForm(Model model)
	{
		Question question=new Question();
		List<Question> list=quizDao.getAllQuestions();
		model.addAttribute("list", list);
		model.addAttribute("question", question);
		return "add-question";
	}
	
	@PostMapping("/add-question")
	public String quizAddQuestionFormSubmit(@ModelAttribute("question")Question question,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "add-question";
		}
		quizDao.saveQuestion(question);
		return "add-question";
	}
}
