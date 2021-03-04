package codeprogrammersProject;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
	    Arrays.sort(participant);
	    Arrays.sort(completion);
	    
	    int i = 0;
	    
	    for(i = 0 ; i < completion.length ; i++) {
	    	if(!participant[i].equals(completion[i])) {
	    		return participant[i];
	    	}
	    }
	    
	    return participant[i];
	}
	
	    
    @Test
	  public void 정답(){
	    Assert.assertEquals("leo", solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
	    Assert.assertEquals("vinko", solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
	    Assert.assertEquals("mislav", solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
	  }
}
