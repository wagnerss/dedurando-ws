package br.com.dedurando.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.dedurando.business.BusinessException;

public class BLL<T> {
	
	private static Validator validator;
	
	public BLL(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	public void validate(T entity) throws BusinessException{
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
		String errors = "";
		if(constraintViolations.size() > 0){
			for(ConstraintViolation<T> c : constraintViolations){
				errors += c.getMessage() + "\n";
			}
			throw new BusinessException(errors);
		}
		
	}
}
