package com.qunar.command.cut;

import com.qunar.command.CommandOption;
import com.qunar.command.LinuxCmd;

//TODO: 由于之前对于Cut命令不太熟悉，设计时未考虑Options中含有参数的场景，待完成
//TODO: 初步打算采用Enum("","")这种写法实现
public class Cut {
    public enum CutExecuteOption implements CommandOption {

    }
}
