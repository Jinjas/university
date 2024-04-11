package g8;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class FramedConnection implements AutoCloseable {
    private final Socket s;
    private final Lock readLock = new ReentrantLock();
    private final Lock writeLock = new ReentrantLock();
    private final DataInputStream in;
    private final DataOutputStream out;
    public FramedConnection(Socket socket) throws IOException {
        s = socket;
        this.out = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
        this.in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
    }

    public void send(byte[] data) throws IOException {
        this.writeLock.lock();
        try {
            this.out.writeInt(data.length);
            this.out.write(data);
            this.out.flush();
        }
        finally {
            this.writeLock.unlock();

        }
    }
    public byte[] receive() throws IOException {
        this.writeLock.lock();
        try {
            int length = this.in.readInt();
            byte[] data = new byte[length];
            this.in.readFully(data);

            return data;
        }
        finally {
            this.writeLock.unlock();
        }
    }
    public void close() throws IOException {
        try{
            this.writeLock.lock();
            this.readLock.lock();
            this.s.close();

        }
        finally {
            this.writeLock.unlock();
            this.readLock.unlock();
        }
    }
}
