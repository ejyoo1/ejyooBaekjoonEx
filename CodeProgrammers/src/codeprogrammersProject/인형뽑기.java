package codeprogrammersProject;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class 인형뽑기 {
	public int solution(int[][] board, int[] moves) {
	    int answer = 0;
	    
//	    자료구조 특성상 가장 마지막에 쌓아져 있는 것이 먼저 나와야 하므로 Stack 자료구조 사용함.
	    Stack<Integer> stack = new Stack<>();
//	    스택에 아무것도 없는 채로 비교를 하는 경우 오류가 발생하기 때문에 0을 넣고 시작함.
	    stack.push(0);
	    
//	    열은 한번만 선택되고 행만 계속 바뀌는 구조임.
	    for(int move : moves) {
	    	for(int j = 0 ; j < board.length; j++) {
//	    		board[j][move -1] 의 위치에 0이 아닐경우
	    		if(board[j][move - 1] != 0) {
//	    			stack에서 값을 삭제 없이 읽어온 뒤 board[j][move -1]과 비교해서 같은경우
	    			if(stack.peek() == board[j][move - 1]) {
//	    				스택에 저장된 값을 하나 추출하고
	    				stack.pop();
//	    				answer 의 값을 +2 해준다.
//	    				값이 같으면 빼기만 하면 됨.
	    				answer += 2;
//	    			stack에서 값을 삭제 없이 읽어온 뒤 board[j][move -1]과 같지 않은 경우
	    			}else {
//	    				스택에 값을 삽입한다.
	    				stack.push(board[j][move-1]);
	    			}
//	    			같거나 같지 않은 경우 모두 캐릭터를 뽑아야 하는 상황이므로
//	    			캐릭터가 뽑은 이후에는 인형뽑기에 값이 없다.
//	    			따라서 빈 공간으로 만들어주어야 한다.
	    			board[j][move -1] = 0;
	    			break;
	    		}
	    	}
	    }
	    
	    return answer;
	}
	    
    @Test
	  public void 정답(){
	    Assert.assertEquals(4, solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
	    Assert.assertEquals(8, solution(new int[][]{{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}}, new int[]{1,5,3,5,1,2,1,4}));
	    Assert.assertEquals(0, solution(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}, new int[]{1,5,3,5,1,2,1,4}));

	  }
}
