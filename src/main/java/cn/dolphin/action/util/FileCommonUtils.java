package cn.dolphin.action.util;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.List;

/**
 * @author LiLinZhi
 * @date 2017-10-28 下午9:05
 */
public class FileCommonUtils {

    private static final String UTF8_ENCODER = "UTF-8";

    public static void main(String[] args) throws Exception {
        // writeFile();
        // readFile();
        // delete();
        // move();
        // copy();

        // 1. file -> inputStream
        InputStream inputStream = new FileInputStream(new File("data/init.txt"));
        // 2. inputStream -> file
        FileUtils.copyInputStreamToFile(inputStream, new File("data/inputStream2File.txt"));
//        inputStreamToFile(inputStream, new File("data/inputStream2File.txt"));

        // 3. File 转 inputStream 转byte[] 转 base64
        InputStream is = new FileInputStream(new File("java.png"));
        byte[] bytes = IOUtils.toByteArray(is, is.available());
        IOUtils.closeQuietly(is);

        BASE64Encoder encoder = new BASE64Encoder();
        String base64String = encoder.encode(bytes);
        String result = String.format("data:image/png;base64,%s", base64String);
        System.out.println(result);

    }

    /**
     * 1. 写 文件/文件夹
     */
    public static void writeFile() throws Exception {
        File file = new File("data/init.txt");
        FileUtils.write(file, "line1\t", true);
        FileUtils.write(file, "line2\n", UTF8_ENCODER, true);

        List<String> lines = Lists.newArrayList();
        lines.add("listLine1");
        lines.add("listLine2");
        FileUtils.writeLines(file, lines, true);

        FileUtils.writeStringToFile(file, "END", UTF8_ENCODER, true);
    }

    /**
     * 2. 读 文件/文件夹
     */

    public static void readFile() throws Exception {
        File file = new File("data/init.txt");

        List<String> lines = FileUtils.readLines(file);
        for (String line : lines) {
            System.out.println(line);
        }

        String content = FileUtils.readFileToString(file);
        System.out.println(content);

        byte[] bytes = FileUtils.readFileToByteArray(file);
        for (byte b : bytes) {
            System.out.println(b);
        }
    }

    /**
     * 3. 删除 文件/文件夹
     */
    public static void delete() throws Exception {
        FileUtils.deleteDirectory(new File("data"));

        //文件夹不是空任然可以被删除，永远不会抛出异常
        FileUtils.deleteQuietly(new File("data"));
    }

    /**
     * 4. 移动 文件/文件夹
     */
    public static void move() throws Exception {
        // dir1中的内容移动到dir2中
        FileUtils.moveDirectory(new File("data/dir1"), new File("data/dir2"));
        // dir3移动到dir4
        FileUtils.moveDirectoryToDirectory(new File("data/dir3"), new File("data/dir4"), true);
    }

    /**
     * 5. 复制 文件/文件夹
     */
    public static void copy() throws Exception {
        // copy1.txt中的内容copy到copy2.txt中
        FileUtils.copyFile(new File("data/copy1.txt"), new File("data/copy2.txt"));
        // copy1.txt复制到copy目录下
        FileUtils.copyFileToDirectory(new File("data/copy1.txt"), new File("data/copy"));

        // copy2复制到copy目录下
        FileUtils.copyDirectoryToDirectory(new File("data/copy2"), new File("data/copy"));

//         FileUtils.copyInputStreamToFile();
//         FileUtils.copyURLToFile();
    }


    /**
     * 6. 流转文件
     */
    public static void inputStreamToFile(InputStream ins, File file) throws Exception {
        OutputStream os = new FileOutputStream(file);
        int length = 8192;
        int bytesRead;
        byte[] buffer = new byte[length];
        while ((bytesRead = ins.read(buffer, 0, length)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }

    /**
     * 7. 文件转流
     */

    /**
     * 8. 流转base64
     */

    /**
     * 9. base64转流
     */

    /**
     * 10. 压缩文件
     */

    /**
     * 11. 解压文件
     */

}
