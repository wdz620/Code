# Debug调试程序：
### 执行程序：
f8 : 逐行执行程序,

f7 : 进入到方法中,

shift + f8 : 跳出方法 ,

f9 : 跳到下一个断点，如果没有下一个断点，那么就结束程序,

ctrl + f2 : 退出debug模式，停止程序,

Console : 切换到控制台 

# 项目重新启动的四个选项：
Update resources :更新静态资源（比如html，js，css等）,

Update classes and resources : 修改了代码和资源,

Redeploy ：修改了配置文件，或者改动很多，希望重新部署,

Restart server :希望重新运行你的程序（这会导致全局变量和代码的重置）,

前面的选项速度快，后面的选项更新更彻底。所以你的原则是在确保更新成功的前提下，选前面的。

# Idea快捷键
Ctrl + D 复制当前行

Ctrl+Alt+V，可以引入变量。例如：new String(); 自动导入变量定义。

Alt + 鼠标左键 可以跨行选择同一列。

Ctrl+Alt+T，可以把代码包在一个块内，例如：try/catch。

Ctrl+X，删除行。

Ctrl+Y，删除当前行。

Ctrl+Shift+Up/Down，向上/下移动语句。

双击异常 + Alt + Enter。 抛出异常.

Ctrl+Shift+Enter 行尾加分号/光标切换到下一行

#双索引
moveZeroes1、RemoveElement、RemoveDuplicates_I、RemoveDuplicates_II、Merge（hard）
#对撞指针
TwoSum、MaxArea、ReverseVowels
#滑动窗口（解决连续问题）
主要就是利用两个指针不断寻找的过程
技巧：刚开始窗口没有元素，所以右指针为-1，并且刚开始应将数组定制为比长度还多一个！
详见209
3：i dont understand this answer！！！
练习：438、76（hard）