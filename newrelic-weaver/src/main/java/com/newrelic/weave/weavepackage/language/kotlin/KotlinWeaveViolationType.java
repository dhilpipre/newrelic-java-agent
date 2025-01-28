package com.newrelic.weave.weavepackage.language.kotlin;

public enum KotlinWeaveViolationType {
    // @formatter:off
    CLASS_WEAVE_IS_OBJECT("@Weave classes can not be kotlin objects"),
    CLASS_WEAVE_IS_FUNCTIONAL_INTERFACE("@Weave classes can not be kotlin functional interfaces");
    // @formatter:on
    private final String message;
    
    private KotlinWeaveViolationType(String message) {
    	this.message = message;
    }
    
    public String getMessage() {
    	return message;
    }
}
