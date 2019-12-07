package cl.egonzalezm.gestionusuario.gestionusuario.controller;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import cl.egonzalezm.gestionusuario.gestionusuario.domain.ErrorDetail;

@ControllerAdvice(assignableTypes = UsuarioController.class)
public class UsuaruiControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<ErrorDetail> handleUserNotFoundException(MethodArgumentNotValidException ex,
			WebRequest request) {
		String messageError = "";
		for (FieldError iterable_element : ex.getBindingResult().getFieldErrors()) {

			messageError += "[" + iterable_element.getField() + " : " + iterable_element.getDefaultMessage() + "]";
		}
		ErrorDetail errorDetails = new ErrorDetail(new Date(), messageError, request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ErrorDetail> handleUserNotFoundException(ConstraintViolationException ex,
			WebRequest request) {
		String messageError = "El correo ya se encuentra registrado";

		ErrorDetail errorDetails = new ErrorDetail(new Date(), messageError, request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
