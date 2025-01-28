package com.newrelic.weave.weavepackage.language.kotlin;

import com.google.common.base.MoreObjects;
import com.newrelic.weave.violation.WeaveViolation;
import com.newrelic.weave.violation.WeaveViolationType;

public class KotlinWeaveViolation extends WeaveViolation {

    private static final WeaveViolationType TYPE = WeaveViolationType.LANGUAGE_ADAPTER_VIOLATION;

    private final String weaveClass;
    private final String violationMessage;
    private final KotlinWeaveViolationType violationType;
    
    public KotlinWeaveViolation(String weaveClass, KotlinWeaveViolationType violationType) {
    	this(weaveClass, violationType, null);
    }

    public KotlinWeaveViolation(String weaveClass, KotlinWeaveViolationType violationType, String violationMessage) {
    	super(TYPE, weaveClass);
    	this.weaveClass = weaveClass;
    	this.violationMessage = violationMessage;
    	this.violationType = violationType;
    	
    }

	@Override
	public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues().add("violationType", violationType).add("weaveClass",
                weaveClass).add("violationType", violationType).add("violationMessage", violationMessage).toString();
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		KotlinWeaveViolation other = (KotlinWeaveViolation)o;
        return (violationType == other.violationType)
                && (weaveClass == null ? other.weaveClass == null : weaveClass.equals(other.weaveClass))
                && (violationMessage == null ? other.violationMessage == null : violationMessage.equals(other.violationMessage));
	}
    
    
}
