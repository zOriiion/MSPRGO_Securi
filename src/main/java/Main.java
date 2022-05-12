import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws IOException {
        ThreadMaterialId threadMaterialId = new ThreadMaterialId();
        ThreadStaffId threadStaffId = new ThreadStaffId();
        ThreadStaffInfo threadStaffInfo = new ThreadStaffInfo(threadStaffId.getStaffIdArray());
        threadStaffId.run();
        threadStaffInfo.run();
        threadMaterialId.run();
    }
}
