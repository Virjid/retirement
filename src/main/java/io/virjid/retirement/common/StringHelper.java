package io.virjid.retirement.common;

import java.util.UUID;

public interface StringHelper {
	
	default String uuid() {
		String uuid=UUID.randomUUID().toString(); 
		char[] cs=new char[32];
		for(int i=uuid.length(),j=0;i-->0;) {
			if(uuid.charAt(i)!='-') {
				cs[j++]=uuid.charAt(i);
			}
		}
		return new String(cs);
	}
	
	default String trimAsNull(String target){
		if(target==null||(target=target.trim()).length()==0) {
			return null;
		}
		return target;
	}
}
