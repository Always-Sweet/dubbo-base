import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZkTest implements Watcher {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Test
    public void main() throws Exception{
        String connectString= "127.0.0.1:2181";
        ZooKeeper zooKeeper = new ZooKeeper(connectString, 2000, this);
        System.out.println("zk connect success");
        printNode(zooKeeper, "/", 1);
//        countDownLatch.await();
    }

    public void printNode(ZooKeeper zooKeeper, String path, int level) {
        List<String> children = null;
        try {
            children = zooKeeper.getChildren(path, false);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        children.forEach(c -> {
            for (int i = 0; i < level; i++) {
                System.out.print("--|");
            }
            try {
                System.out.println(URLDecoder.decode(c, "UTF-8") + "(" + new String(zooKeeper.getData(path, false, null)) + ")");
            } catch (UnsupportedEncodingException | KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
            printNode(zooKeeper, (path == "/" ? "" : path) + "/" + c, level + 1);
        });
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }

}
