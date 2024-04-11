package g8;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaggedConnection  implements AutoCloseable {

    private final Socket s;
    private final Lock readLock = new ReentrantLock();
    private final Lock writeLock = new ReentrantLock();
    private final DataInputStream in;
    private final DataOutputStream out;
    public static class Frame {
        public final int tag;
        public final byte[] data;
        public Frame(int tag, byte[] data) { this.tag = tag; this.data = data; }
    }
    public TaggedConnection(Socket socket) throws IOException {
        s = socket;
        this.out = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
        this.in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
    }
    public void send(Frame frame) throws IOException { 
        send(frame.tag, frame.data);
    }
    public void send(int tag, byte[] data) throws IOException {
        this.writeLock.lock();
        try{
            this.out.writeInt(tag);
            this.out.writeInt(data.length);
            this.out.write(data);
            this.out.flush();
        }
        finally {
            this.writeLock.unlock();
        }

    }
    public Frame receive() throws IOException {
        this.readLock.lock();
        try{
            int tag = in.readInt();
            int length = in.readInt();
            byte[] data = new byte[length];
            this.in.readFully(data);

            return new Frame(tag,data);
        }
        finally {
            this.readLock.unlock();
        }
    }
    public void close() throws IOException {
        this.readLock.lock();
        this.writeLock.lock();
        this.s.close();
        this.writeLock.unlock();
        this.readLock.unlock();
    }
}
