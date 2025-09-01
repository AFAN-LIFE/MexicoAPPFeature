# 环境配置

## Java配置
### openjdk配置
利用IDEA创建项目自动下载openjdk，需要额外配置`JAVA_HOME`环境变量。
- 1 找到Java安装路径：打开IDEA，File → Project Structure → SDK Location，这里会显示JDK的安装路径
`C:\Users\AFAN\.jdks\openjdk-24.0.2+12-54`
- 2 右键"此电脑" → 属性 → 高级系统设置 → 环境变量，在"系统变量"中点击"新建"：
  - 变量名：JAVA_HOME
  - 变量值：你的JDK安装路径，比如：C:\Program Files\Java\jdk1.8.0_291，改成你在IDEA中看到的路径
- 3 编辑Path变量：在Path中添加 %JAVA_HOME%\bin

验证配置：

```
(base) C:\Users\AFAN>echo %JAVA_HOME%
C:\Users\AFAN\.jdks\openjdk-24.0.2+12-54

(base) C:\Users\AFAN>java -version
openjdk version "24.0.2" 2025-07-15
OpenJDK Runtime Environment (build 24.0.2+12-54)
OpenJDK 64-Bit Server VM (build 24.0.2+12-54, mixed mode, sharing)
```

### jdk1.8配置
- 1 打开jdk1.8下载地址：https://www.oracle.com/cn/java/technologies/javase/javase8u211-later-archive-downloads.html ，登录oracle之后下载到本地：jdk-8u451-windows-i586.exe
- 2 右键"此电脑" → 属性 → 高级系统设置 → 环境变量，在"系统变量"中点击"新建"：
    - 变量名：JAVA8_HOME
    - 变量值：你的JDK安装路径，比如：D:\software\java\jdk1.8\
- 3 编辑Path变量：在Path中添加 %JAVA8_HOME%\bin

验证配置：

```
(base) C:\Users\AFAN>echo %JAVA8_HOME%
D:\software\java\jdk1.8\

(base) C:\Users\AFAN>java -version
java version "1.8.0_451"
Java(TM) SE Runtime Environment (build 1.8.0_451-b10)
Java HotSpot(TM) Client VM (build 25.451-b10, mixed mode, sharing)
```

如果未来还需要有jdk其他版本，如jdk17，只需要创建JAVA17_HOME的环境变量然后在Path中换成它即可

参考：[JDK8和JDK17安装切换，IDEA配置多个版本JDK](https://developer.aliyun.com/article/1416298)

## maven安装
1. 下载Maven
   访问官网下载：https://maven.apache.org/download.cgi
   下载 apache-maven-3.9.6-bin.zip（选择最新版本）

2. 解压到指定目录
   比如解压到：C:\Program Files\apache-maven-3.9.6

3. 配置环境变量
   右键"此电脑" → 属性 → 高级系统设置 → 环境变量。
   
   在"系统变量"中新建：
   - 变量名：M2_HOME 
   - 变量值：C:\Program Files\apache-maven-3.9.6
     
   编辑"Path"变量，添加：%M2_HOME%\bin

4. 验证安装
   打开命令提示符（cmd），输入：
```shell
(base) C:\Users\AFAN>mvn --version
Apache Maven 3.9.11 (3e54c93a704957b63ee3494413a2b544fd3d825b)
Maven home: D:\software\apache-maven-3.9.11-bin\apache-maven-3.9.11
Java version: 24.0.2, vendor: Oracle Corporation, runtime: C:\Users\AFAN\.jdks\openjdk-24.0.2+12-54
Default locale: zh_CN, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

# 打包测试

## maven打包

您的项目根目录/
├── pom.xml          # 项目配置文件
└── src/
├── main/
│   ├── java/    # 【核心】Java源代码目录（会自动编译并打包进JAR）
│   └── resources/ # 资源文件目录（如配置文件，也会自动打包进JAR）
└── test/
├── java/    # 测试代码目录（不会打包进JAR）
└── resources/ # 测试资源目录（不会打包进JAR）

```
# 只下载依赖，不编译
mvn dependency:resolve
# 下载依赖+编译源码
mvn compile
# 清理旧文件 + 编译 + 打包
mvn clean package
```

打包后查看jar包内容

```
PS D:\git_repo\MexicoAPPFeature> jar tf target/score-calculator.jar
META-INF/
META-INF/MANIFEST.MF
appscore/
META-INF/maven/
META-INF/maven/com.sqadapter/
META-INF/maven/com.sqadapter/app-score/
appscore/DigitalDictionary.class
appscore/ScoreCalculator.class
appscore/ScoreResult.class
META-INF/maven/com.sqadapter/app-score/pom.xml
META-INF/maven/com.sqadapter/app-score/pom.properties
```

## pom.xml说明

1. **`<properties>` 部分**
- **`<maven.compiler.source>1.8</maven.compiler.source>`**：指定源代码兼容Java 1.8语法。
- **`<maven.compiler.target>1.8</maven.compiler.target>`**：指定生成的字节码为Java 1.8格式。
- **`<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>`**：确保源码文件编码一致，避免中文乱码。
- **插件版本管理**：将插件版本统一管理，便于维护。
- **`<xjar.password>`**：加密密码，这是保护您代码的关键！**请务必修改为一个强密码**。

2. **`maven-compiler-plugin`（编译器插件）**
- **作用**：显式强制使用Java 1.8进行编译，优先级高于properties中的配置，确保万无一失。
- **为什么需要**：即使环境变量或IDE设置有其他JDK版本，这个配置也能保证编译出1.8的字节码。

3. **`maven-assembly-plugin`（打包插件）**
- **作用**：创建一个"FatJar"或"UberJar"，即将您自己的代码**和所有依赖的第三方库**打包到一个单独的jar文件中。
- **`<mainClass>`**：**必须修改**为您项目的主类全限定名（如`com.SQAdapter.ScoreCalculatorTest`）。这是程序的入口点。
- **`<descriptorRef>jar-with-dependencies</descriptorRef>`**：告诉插件使用"包含依赖"的打包方式。
- **`<appendAssemblyId>false</appendAssemblyId>`**：生成的文件名不带`-jar-with-dependencies`后缀。
- **`<finalName>score-calculator-fat</finalName>`**：生成的FatJar名称。

4. **`xjar-maven-plugin`（加密插件）**
- **作用**：对上面生成的FatJar进行加密，得到无法反编译的jar包。
- **`<password>`**：使用properties中定义的密码进行加密/解密。
- **`<algorithmes>AQP</algorithmes>`**：指定加密算法。
- **`<includes>`**：定义需要加密的文件类型（类文件、jar、配置文件等）。
- **`<targetJar>`**：指定加密后输出的jar包路径和名称。


## 混淆打包

mvn install:install-file 这是 Maven 自带的一个目标（goal），用来 手动安装一个 jar 到本地 Maven 仓库。

| 参数                                           | 含义                                         |
| -------------------------------------------- | ------------------------------------------ |
| `-Dfile=target/app-score-1.0-obfuscated.jar` | 指定要安装的 jar 文件路径，也就是 ProGuard 混淆生成的 jar     |
| `-DgroupId=com.sqadapter`                    | Maven 坐标中的 groupId，类似包名空间，用于唯一标识这个库        |
| `-DartifactId=app-score`                     | Maven 坐标中的 artifactId，代表这个 jar 的名称         |
| `-Dversion=1.0-obfuscated`                   | Maven 坐标中的版本号，这里给混淆后的 jar 一个特殊版本号，区分原始 jar |
| `-Dpackaging=jar`                            | 指定打包类型，这里是 jar                             |

```
 mvn install:install-file -"Dfile=target/app-score-1.0-obfuscated.jar" -DgroupId="com.sqadapter" -DartifactId="app-score" -Dversion="1.0-obfuscated" -Dpackaging="jar"
```

执行成功后可以在maven仓库中查看到：`C:\Users\AFAN\.m2\repository`

具体位置在：`C:\Users\AFAN\.m2\repository\com\sqadapter\app-score\1.0-obfuscated`


# 加密测试

## xjar加密
地址：https://github.com/core-lib/xjar-maven-plugin

我方pom.xml的properties中增加配置
```
        <!-- 3. XJar 加密插件版本和配置 -->
        <xjar-maven-plugin.version>4.0.2</xjar-maven-plugin.version>
        <xjar.password>YourStrongPassword123!@#</xjar.password> <!-- 请修改为复杂密码 -->
        <xjar.algorithm>AES/CBC/PKCS5Padding</xjar.algorithm>
```

设置仓库下载

```
    <!-- 设置 jitpack.io 插件仓库 -->
    <pluginRepositories>
        <pluginRepository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </pluginRepository>
    </pluginRepositories>
```

插件加密配置

```
            <!-- 插件3：XJar 加密插件 -->
            <plugin>
                <groupId>com.github.core-lib</groupId>
                <artifactId>xjar-maven-plugin</artifactId>
                <version>${xjar-maven-plugin.version}</version>
                <executions>
                    <execution>
                        <id>encrypt-jar</id>
                        <phase>package</phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                        <configuration>
                            <password>${xjar.password}</password>
                            <algorithm>${xjar.algorithm}</algorithm>
                            <includes>
                                <include>/**/*.class</include>
                                <include>/**/*.jar</include>
                                <include>/**/*.xml</include>
                                <include>/**/*.properties</include>
                                <include>/**/*.yml</include>
                                <include>/**/*.yaml</include>
                            </includes>
                            <excludes>
                                <exclude>META-INF/MANIFEST.MF</exclude>
                            </excludes>
                            <!--XJar 插件默认输出目录就是 ${project.build.directory}（即 target/ 目录），所以您不需要再指定一次完整路径。-->
                            <targetJar>${project.artifactId}-${project.version}-encrypted.jar</targetJar>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```

甲方添加后执行
```
mvn test -DargLine="-Dxjar.password=YourStrongPassword123!@#"
```


## proguard加密
地址：https://github.com/Guardsquare/proguard

pom.xml配置。只将开放给对方的接口不变，其他都混淆
```
            <!-- ProGuard 混淆插件 -->
            <plugin>
                <groupId>com.github.wvengen</groupId>
                <artifactId>proguard-maven-plugin</artifactId>
                <version>${proguard-maven-plugin.version}</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>proguard</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <!--插件默认输出目录就是 ${project.build.directory}（即 target/ 目录），所以您不需要再指定一次完整路径。-->
                    <injar>${project.build.finalName}.jar</injar>
                    <outjar>${project.build.finalName}-obfuscated.jar</outjar>

                    <!-- 常用配置 -->
                    <options>
                        <!-- 保留 main 方法 -->
                        <option>-keep public class * {
                            public static void main(java.lang.String[]);
                            }</option>

                        <!-- 保留 ScoreResult 方法 -->
                        <option>-keep class appscore.ScoreCalculator { *; }</option>

                        <!-- 混淆其他所有类和方法 -->
                        <option>-dontwarn java.**</option>
                        <option>-dontoptimize</option>
                        <option>-dontshrink</option>
                        <!-- 混淆类和方法名 -->
                        <option>-overloadaggressively</option>
                        <option>-useuniqueclassmembernames</option>
                    </options>
                </configuration>
            </plugin>
```

## 反编译
proguard反编译：https://www.shenmeapp.com/zh-CN/decompiler  
xjar包破解方法：https://blog.csdn.net/Tuine/article/details/126176654

打包问题：
- 如果直接用proguard生成jar交付，则没有jackson这些依赖
- 如果用proguard+shaded，则源代码就不会加密，尝试过先混淆后jar包进去，但是由于不依赖，业务代码不会被加入
- 所以只能先用proguard生成代码再反编译回去，之后再去打包。但是class文件丢失了很多类型声明，需要手动改之后才能重新打包。