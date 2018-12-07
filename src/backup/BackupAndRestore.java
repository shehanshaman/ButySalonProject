/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import java.io.IOException;

/**
 *
 * @author ruchira
 */
public class BackupAndRestore {

    public static int restoreBackUp(String path) throws IOException, InterruptedException {        
        String[] executeCommand = {"mysql", "Shop", "--user=root", "--password=mysql", "-e", "source " + path};
        Process runtProcess = Runtime.getRuntime().exec(executeCommand);
        int res = runtProcess.waitFor();
        return res;

    }

    public static int writeBackUp(String path) throws IOException, InterruptedException {        
        Runtime runtime = Runtime.getRuntime();
        Process runtimeProcess = runtime.exec("mysqldump Shop -h localhost -u root -pmysql -r" + path);
        int res = runtimeProcess.waitFor();
        return res;
    }
}
