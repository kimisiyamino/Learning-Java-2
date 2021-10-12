import java.io.IOException;

public class Test implements AmigoOutputStream{
    @Override
    public void flush() throws IOException {

    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {

    }

    @Override
    public void close() throws IOException {
        System.out.println("Test close()");
    }
}
