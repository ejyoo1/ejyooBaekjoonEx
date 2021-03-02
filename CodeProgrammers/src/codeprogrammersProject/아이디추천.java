package codeprogrammersProject;

import org.junit.Assert;
import org.junit.Test;

public class 아이디추천 {
    public String solution(String new_id) {
//    	new_id의 모든 대문자를 대응되는 소문자로 치환한다.
    	String answer = new_id.toLowerCase();
//    	newId에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//    	정규식 [] : 문자의 집합이나 범위([a-z] : a부터 z까지, [^a-z] : a부터 z가 아닌것)
//    	-_.와 a부터 z까지, 0부터 9가 아닌것은 제거
    	answer = answer.replaceAll("[^-_.a-z0-9]", "");
//    	.이 2개 이상인 경우 .으로 변경
    	answer = answer.replaceAll("[.]{2,}", ".");
//    	끝^ 문자가 .이고 처음$문자가 .인 것 제거
    	answer = answer.replaceAll("^[.]|[.]$", "");
//    	빈 문자열이라면 a를 추가한다.
    	if(answer.equals("")) {
    		answer += "a";
    	}
//    	16자 이상인 경우 15자 까지만 표시하고 모두 지웁니다.
    	if(answer.length() >= 16) {
    		answer = answer.substring(0,15);
//    		지우고 난 뒤 앞과 뒤에 .이 있을 수 있으므로 제거
    		answer = answer.replaceAll("^[.]|[.]$", "");
    	}
    	
//    	길이가 2 이하인 경우 마지막 문자를 길이가 3이 될 때 까지 반복하여 끝에 붙인다.
    	if(answer.length() <= 2) {
    		while(answer.length() < 3) {
    			answer += answer.charAt(answer.length() - 1);
    		}
    	}
    	return answer;
    }

	    
    @Test
	  public void 정답(){
	    Assert.assertEquals("bat.y.abcdefghi", solution(new String("...!@BaT#*..y.abcdefghijklm")));
	    Assert.assertEquals("z--", solution(new String("z-+.^.")));
	    Assert.assertEquals("aaa", solution(new String("=.=")));
	    Assert.assertEquals("123_.def", solution(new String("123_.def")));
	    Assert.assertEquals("abcdefghijklmn", solution(new String("abcdefghijklmn.p")));
	  }
}