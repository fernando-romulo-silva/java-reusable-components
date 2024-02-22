package org.reusablecomponent.infra.openapi.annotations.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.reusablecomponent.infra.openapi.annotations.response.error.EntityResponseError500OpenApi;
import org.reusablecomponent.infra.openapi.annotations.response.error.OpenApiEntityGetBySearchError400;
import org.reusablecomponent.infra.openapi.annotations.response.success.OpenApiEntityGet200;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
//
//
@Tag(name = "BETA", description = "This API is currently in beta state")
@Operation( //
		summary = "Get image types by criteria search", //
		description = "This method return image conversions that satisfy a certain condition" //
)
@OpenApiEntityGet200
@OpenApiEntityGetBySearchError400
@EntityResponseError500OpenApi
public @interface EntityRestGetOpenApi {

}
