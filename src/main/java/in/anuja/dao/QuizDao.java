package in.anuja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import in.anuja.model.Question;

@Repository
@Transactional
public class QuizDao {

	
	@Autowired 
	EntityManager entityManager ;
	
	public void saveQuestion(Question question)
	{
		entityManager.persist(question);
	}

	public List<Question> getAllQuestions() {
		
		return entityManager.createQuery(" from Question",Question.class).getResultList();
	}
	
}
