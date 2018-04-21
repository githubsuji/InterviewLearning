package com.myinterview.immutable;

public final class ImmutableClass {
private final String memberVariable;
    
    public String getMemberVariable() {
        return memberVariable;
    }
 
    public ImmutableClass(final String value){
        this.memberVariable = value;
    }

	@Override
	public String toString() {
		return memberVariable;
	}
    
}
