package multi.data.utils;

public class SourceIdUtil {

    public static String getSourceId() {
        //先随机产生一个下标再获取元素
        String[] doc = {"42142928863", "537927930917", "585330318155", "566887134978", "570255080929", "587696673371", "569659673792", "571333052971", "589856801859", "587206669150"};
        int index = (int) (Math.random() * doc.length);
        String sourceID = doc[index];
        return sourceID;
    }

}
