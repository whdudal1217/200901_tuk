
public class solution {

	public static boolean solution(String s) {
		boolean answer = true;
		if (s.length()>=4 && s.length() <= 6) {
			if(isStringDouble(s)==false) {
				answer = false;
			}else {
				answer = true;
			}
		}else {
			answer = false;
		}
		
		return answer;
	}

	
	public static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		solution("12");
	}

}
