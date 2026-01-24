/*
 * @ (#) Ex4        1.0     1/16/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package baitap.ex4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 1/16/2026  2:48 AM
 */
public class Ex4 {
    private void copyFile(String inPath, String outPath) {
        try(
                InputStream inFile = new BufferedInputStream(Files.newInputStream(Path.of(inPath)));
                OutputStream outFile = new BufferedOutputStream(Files.newOutputStream(Path.of(outPath)))
        ){
            byte[] buffer = new byte[1024 * 64];
            int chunk = inFile.read(buffer);
            int size = inFile.available();
            int percent = 0;
            int readNum = 0;
            while (chunk != -1) {
                outFile.write(buffer,0,chunk);
                readNum += chunk;
                chunk = inFile.read(buffer);
                percent = (int)(chunk * 100.0 / size);
                System.out.println(percent);
            }


        }catch (Exception e) {
            // TODO: handle exception
        }
    }

}

