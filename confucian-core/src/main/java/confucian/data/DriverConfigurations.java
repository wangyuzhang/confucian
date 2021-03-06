package confucian.data;

import java.io.File;

import confucian.common.OSName;
import confucian.common.OSName.OSN;

/**
 * 驱动程序配置
 */
public class DriverConfigurations {

    /**
     * 枚举框架配置
     */
    public enum FrameworkConfig {
        /**
         * 标记是否远程
         */
        remoteFlag("false"),
        /**
         * 全局超时
         */
        driverTimeOut("5"),
        /**
         * 重试失败的测试用例
         */
        retryFailedTestCase("0"),
        /**
         * 页面操作元素高亮
         */
        highlightElementFlag("false"),
        /**
         * 报告的屏幕截图功能
         */
        screenShotFlag("true"),
        /**
         * 滚动到元素位置功能
         */
        scrollElementFlag("true"),
        /**
         * 数据源
         */
        datasource("");
        private String defaultValue;

        FrameworkConfig(String defaultValue) {
            this.defaultValue = defaultValue;
        }

        /**
         * Get string.
         *
         * @return the string
         */
        public String get() {
            return this.defaultValue;
        }
    }

    /**
     * 枚举数据库配置
     */
    public enum DBConfig {
        /**
         * 是否连接数据库
         */
        DBFlag("false"),
        /**
         * Jdbc url
         */
        jdbcURL(""),
        /**
         * Username
         */
        username(""),
        /**
         * Password
         */
        password("");
        private String defaultValue;

        DBConfig(String defaultValue) {
            this.defaultValue = defaultValue;
        }

        /**
         * Get string.
         *
         * @return the string
         */
        public String get() {
            return this.defaultValue;
        }
    }

    /**
     * 枚举Selenium Grid配置
     */
    public enum HubConfig {
        /**
         * Remote url hub config.
         */
        remoteURL("http://0.0.0.0:4444/wd/hub");
        private String defaultValue;

        HubConfig(String defaultValue) {
            this.defaultValue = defaultValue;
        }

        /**
         * Get string.
         *
         * @return the string
         */
        public String get() {
            return this.defaultValue;
        }
    }

    /**
     * 枚举本地环境的配置
     */
    public enum LocalEnvironmentConfig {

        /**
         * 浏览器名称
         */
        browserName("FireFox"),
        /**
         * IE驱动路径
         */
        IEDriverPath(System.getProperty("user.dir") +
                "/src/main/resources/IEDriverServer.exe".replace("/", File.separator)),
        /**
         * Chrome驱动路径
         */
        chromeDriverPath(System.getProperty("user.dir") +
                "/src/main/resources/chromedriver".replace("/", File.separator));

        private String defaultValue;

        LocalEnvironmentConfig(String defaultValue) {
            if (defaultValue.contains("chromedriver")) {
                if (OSName.get().equals(OSN.WIN)) {
                    this.defaultValue = defaultValue.replace("chromedriver", "chromedriver.exe");
                } else {
                    this.defaultValue = defaultValue;
                }
            } else {
                this.defaultValue = defaultValue;
            }
        }

        /**
         * Get string.
         *
         * @return the string
         */
        public String get() {
            return this.defaultValue;
        }

    }
}
