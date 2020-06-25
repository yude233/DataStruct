package mydijkstra;
/**
 * 存储前点结点与最短路径
 * @author qaz
 *
 */
public class PreNodeAndPath {
    private int preNode;//前点结点
    private int shortPath;//路径长度
    public int getPreNode() {
        return preNode;
    }
    public void setPreNode(int preNode) {
        this.preNode = preNode;
    }
    public int getShortPath() {
        return shortPath;
    }
    public void setShortPath(int shortPath) {
        this.shortPath = shortPath;
    }
    
}
