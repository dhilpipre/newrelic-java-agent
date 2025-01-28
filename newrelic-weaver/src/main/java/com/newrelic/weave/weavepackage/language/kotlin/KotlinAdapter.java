package com.newrelic.weave.weavepackage.language.kotlin;

import java.util.List;

import org.objectweb.asm.Type;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.kotlin.KotlinMatchType;
import com.newrelic.api.agent.weaver.kotlin.KotlinWeave;
import com.newrelic.weave.weavepackage.language.LanguageAdapter;
import com.newrelic.weave.weavepackage.language.LanguageAdapterResult;

public class KotlinAdapter implements LanguageAdapter {
	
    private static final String WEAVE_API_DESC = Type.getType(Weave.class).getDescriptor();
    private static final String KOTLIN_WEAVE_API_DESC =  Type.getType(KotlinWeave.class).getDescriptor();
    private static final String MATCH_TYPE_DESC = Type.getType(MatchType.class).getDescriptor();
    private static final String KOTLIN_MATCH_TYPE_DESC = Type.getType(KotlinMatchType.class).getDescriptor();


	@Override
	public LanguageAdapterResult adapt(List<byte[]> input) {
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
