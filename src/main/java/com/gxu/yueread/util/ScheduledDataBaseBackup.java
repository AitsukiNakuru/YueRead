package com.gxu.yueread.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDataBaseBackup {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledDataBaseBackup.class);

    private static final String dataBackupPath = "C:/Users/Cittruss/Downloads/yuereadBackup/";//备份路径
    private static final String HOST = "127.0.0.1";//数据库地址
    private static final Integer PORT = 3306;//数据库端口
    private static final String USERNAME = "root";//数据库用户名
    private static final String PASSWORD = "123456";//数据库密码
    private static final String dataBaseName = "yueread";//数据库名称

    //秒		分	小时		月份中的日期	月份		星期中的日期
    @Scheduled(cron = "0 */1 * * * ?")
    public void backup() throws Exception {
        logger.info("开始备份数据库");
        String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
        dataBaseBackup(HOST, PORT, USERNAME, PASSWORD, dataBaseName, backName);
    }

    //备份
    public static void dataBaseBackup(String host, Integer port, String username, String password, String dataBaseName, String sqlname) throws Exception {

        File file = new File(dataBackupPath);
        if (!file.exists()) {
            file.mkdir();
        }
        File dataFile = new File(file + File.separator + sqlname + ".sql");
        if (dataFile.exists()) {
            return;
        }

        StringBuffer s = new StringBuffer();
        s.append("cmd /c mysqldump -h").append(host).append(" -P")
                .append(port).append(" -u ").append(username).append(" -p")
                .append(password).append(" ").append(dataBaseName).append(" > ")
                .append(dataFile);

        Process exec = Runtime.getRuntime().exec(s.toString());
        if (exec.waitFor() == 0){
            logger.info("数据库备份成功,备份路径为：{}",dataFile);
        }
    }
}
