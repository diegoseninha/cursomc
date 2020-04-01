package life.senna11.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(life.senna11.cursomc.services.exceptions.ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(life.senna11.cursomc.services.exceptions.ObjectNotFoundException e, HttpServletRequest requisicao){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
