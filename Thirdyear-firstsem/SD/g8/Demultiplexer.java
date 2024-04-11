package g8;


import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demultiplexer implements AutoCloseable{

    private final TaggedConnection conn;

    private final Lock lock = new ReentrantLock();
    private final Map<Integer,Entry> buf = new HashMap<>();


    private class Entry {
        int waiters = 0;
        final Condition cond = lock.newCondition();
        final ArrayDeque <byte[]> queue = new ArrayDeque<>();
    }

    private Entry get ( int tag){
        Entry e = buf.get(tag);
        if (e == null){
            e = new Entry();
            buf.put(tag,e);
        }
        return e;
    }

    public Demultiplexer(TaggedConnection conn) {
        this.conn = conn;
    }

    public void start() {
        new Thread(() -> {
            try  {
                for(;;) {

                    TaggedConnection.Frame frame = conn.receive();
                    lock.lock();
                    try{
                        Entry e = get(frame.tag);
                        e.queue.add(frame.data);
                        e.cond.signal();
                    }
                    finally {
                        lock.unlock();
                    }
                }

            }  catch (Exception ignored) {}
        }).start();
    }
    public void send(TaggedConnection.Frame frame) throws IOException {
        conn.send(frame);

    }
    public void send(int tag, byte[] data) throws IOException {
        conn.send(tag,data);

    }
    public byte[] receive(int tag) throws IOException, InterruptedException {
        lock.lock();
        try {
            Entry e = get(tag);
            e.waiters++;
            for (; ; ) {
                if (!e.queue.isEmpty()) {
                    byte[] res = e.queue.poll();
                    e.waiters--;
                    if (e.queue.isEmpty() && e.waiters == 0)
                        buf.remove(tag);
                    return res;
                }
                e.cond.await();
            }
        }finally {
            lock.unlock();
        }
    }
    public void close() throws IOException {
        conn.close();
    }
}
