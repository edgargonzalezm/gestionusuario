package cl.egonzalezm.gestionusuario.gestionusuario.constrain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { PasswordConstrainValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstrain {

	String message() default "Debe contener una por lo menos una mayuscula, letras y dos numeros";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	boolean value() default true;
}
