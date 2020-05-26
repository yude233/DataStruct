package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 六桥问题（四个结点）
 * @author qaz
 *
 */
public class SixBridge {
    
    List<Integer> nodes = new ArrayList<Integer>();
    
    /**
     * 判断是否能不重复遍历六桥
     * @param array
     * @return boolean
     */
    private boolean isSixBridge(int[][] array) {
        for(int i = 0; i < 4; i++) {
            int m = 0;
            for(int j = 0; j < 4; j++) {
                if(array[i][j] == 1) {
                    m ++;
                }
            }
            if(m % 2 != 0) {
                nodes.add(i);
            }
        }
        
        if(nodes.size() == 0 || nodes.size() == 2) {//如果奇数结点为0或2,则可行
            return true;
        }
        return false;
    }
    
    /**
     * 输出不重复遍历
     * @param array
     */
    public void printSix(int[][] array) {
        if(!isSixBridge(array)) {
            System.out.println("不可遍历");
        }else {
            
        }
    }
}

