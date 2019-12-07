package cl.egonzalezm.gestionusuario.gestionusuario.constrain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstrainValidator implements ConstraintValidator<PasswordConstrain, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean mayuscula = false;
		boolean minuscula = false;
		Integer cantidadNumeros = 0;

		char caracter;
		for (byte i = 0; i < value.length(); i++) {

			caracter = value.charAt(i);

			String passValue = String.valueOf(caracter);

			if (passValue.matches("[A-Z]")) {

				mayuscula = true;

			} else if (passValue.matches("[a-z]")) {

				minuscula = true;

			} else if (passValue.matches("[0-9]")) {
				cantidadNumeros++;

			}

		}
		return mayuscula && minuscula && cantidadNumeros >= 2;
	}

}
