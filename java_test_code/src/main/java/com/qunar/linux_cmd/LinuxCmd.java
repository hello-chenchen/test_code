/**
 * 用Java代码，实现诸如cat、grep、wc、sort、cut等命令组合
 * 给定一个文件目录，将目录下所有符合条件（例如txt后缀）的文件作为上述程序的输入，对每个文件输出结果（例如filename.rs）
 */
package com.qunar.linux_cmd;
import java.io.File;

interface LinuxCmd
{
    public String inputFile(File filePath);
    public String inputBuf(StringBuffer buffer);
}