package assignment05;

public class BNumberValidator {
	static boolean isValid(int x) {
		if(x < 111111 || x > 999999) return false;
		String s = "" + x;
		char[] chars = s.toCharArray(); // converts 725610 to ['7', '2', '5', '6', '1', '0']
		
		for(int i = 0; i < 4; i++)
			if(chars[i] == chars[i+1] && chars[i+1] == chars[i+2]) return false;
		
		for(int i = 0; i < 4; i++)
			if(1 + chars[i] == chars[i+1] && 1 + chars[i+1] == chars[i+2]) return false;

		for(int i = 0; i < 4; i++)
			if(chars[i] == 1 + chars[i+1] && chars[i+1] == 1 + chars[i+2]) return false;

		if(1 + chars[0] == chars[2] && 1 + chars[2] == chars[4] &&
				chars[1] == chars[3] && chars[3] == chars[5]) return false;

		if(chars[0] == 1 + chars[2] && chars[2] == 1 + chars[4] &&
				chars[1] == chars[3] && chars[3] == chars[5]) return false;

		if(1 + chars[1] == chars[3] && 1 + chars[3] == chars[5] &&
				chars[0] == chars[2] && chars[2] == chars[4]) return false;

		if(chars[1] == 1 + chars[3] && chars[3] == 1 + chars[5] &&
				chars[0] == chars[2] && chars[2] == chars[4]) return false;

		for(int i = 0; i < 10; i++) {
			int count = 0;
			for(int j = 0; j < 6; j++)
				if(chars[j] == '0' + i) count++;
			if (count > 3) return false;
		}		
		return true;
	}
}
