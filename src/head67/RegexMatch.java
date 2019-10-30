package head67;

public class RegexMatch {
	public boolean match(char[] str, char[] pattern) {
		int strIndex = 0;
		int patternIndex = 0;
		return coreMatch(str, strIndex, pattern, patternIndex);
	}

	private boolean coreMatch(char[] str, int strIndex, char[] pattern, int patternIndex) {
		int sl = str.length;
		int pl = pattern.length;
		if (strIndex == str.length && patternIndex == pattern.length)
			return true;
		if (patternIndex == pattern.length)
			return false;
		if ( patternIndex + 1 < pl && pattern[patternIndex + 1] == '*') {
			// stackoverflow����������ж�strindex
			if(strIndex < str.length && (str[strIndex]==pattern[patternIndex] || pattern[patternIndex]=='.')){
				
			return coreMatch(str, strIndex + 1, pattern, patternIndex)
					|| coreMatch(str, strIndex, pattern, patternIndex + 2);
			}
			else 
				return coreMatch(str, strIndex, pattern, patternIndex+2);
		}
		if (strIndex<str.length&&(str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
			return coreMatch(str, strIndex + 1, pattern, patternIndex + 1);
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(new RegexMatch().match("".toCharArray(), ".".toCharArray()));
	}
}
