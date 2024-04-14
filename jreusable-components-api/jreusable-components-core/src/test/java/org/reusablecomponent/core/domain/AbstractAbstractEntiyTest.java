package org.reusablecomponent.core.domain;

import java.util.Locale;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

abstract class AbstractAbstractEntiyTest {
    
    public final static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    
    public Validator validator;
    
    public static boolean updateValue(final Object object, final String fieldName, final Object fieldValue) {

	Class<?> clazz = object.getClass();

	while (clazz != null) {

	    try {

		var field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(object, fieldValue);
		return true;

	    } catch (final NoSuchFieldException ex) {
		clazz = clazz.getSuperclass();
	    } catch (final Exception ex) {
		throw new IllegalStateException(ex);
	    }
	}

	return false;
    }
    
    @BeforeEach
    void setUp() {
	Locale.setDefault(Locale.ENGLISH); // expecting english error messages
	validator = validatorFactory.getValidator();
    }
    
    @AfterAll
    void tearDown() {
	validatorFactory.close();
    }
}
