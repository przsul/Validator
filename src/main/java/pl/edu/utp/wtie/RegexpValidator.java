package pl.edu.utp.wtie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class RegexpValidator implements Validator {
	
	boolean valid;
	Field brand;
	Annotation annotation;
	Regexp regexp;
	
	public RegexpValidator() {
		try {
			brand = Car.class.getDeclaredField("brand");
			annotation = brand.getAnnotation(Regexp.class);
			regexp = (Regexp)annotation;
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void validate(String value) {

		if(annotation != null)
			if(Pattern.compile(regexp.pattern()).matcher(value).matches())
				this.valid = true;
			else
				this.valid = false;
	}

	@Override
	public String getMessage() {
		return regexp.message();
	}

	@Override
	public boolean isValid() {
		return this.valid;
	}
}
