package io.virjid.retirement.common.validator;
public abstract class ValidateHelper {
	private ValidateHelper(){}

	/**
	 * 断言target不会为null，空白字符串，空字符串等
	 * @param message
	 * @param target
	 * @return
	 */
	public static String assertNotBlank(String message,String target) {
		if(target==null||(target=target.trim()).length()==0) {
			throw new ValidateException("must-not-blank",message+"不能为空");
		}
		return target;
	}
	
	public static String $(String message,String target) {
		return assertNotBlank(message, target);
	}
	
	public static void assertLength(String message,String target,final int min,final int max) {
		if(target==null) {
			target="";
		}
		if(target.length()>max||target.length()<min) {
			throw new ValidateException("must-not-blank",
					String.format("%s长度必须是%d到%d",message,min,max)
					);
		}
		
	}
	
	public static boolean assertMatch(String message,String target,String pattern) {
		return false;
	}
	
	public static void assertAlphanumeric(String message,String target) {
		
	}
}
