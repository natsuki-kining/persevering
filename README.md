# 锲而舍之，朽木不折；锲而不舍，金石可镂。

### 创建此工程的缘由
每过一段时间、由于种种因素，计划都或多或少需要调整修改，
不想每次都打开Excel重新编辑制定，所以想写个能根据自己的需求设置自动生成计划表的工具。

### 总体理念
* 简单
* 方便
* 合理

### 大概思路

* 可随地运行项目，不受环境影响（方便）
* 输入计划项跟权重（简单）
* 根据算法生成导出计划表（合理）


### 大概开发设计
* 设计数据结构
* 编写页面
    * 简易
    * 挑选UI美化下界面
* 后端代码
    * 数据处理
    * Excel操作
    * 导出Excel


#### 数据结构
    * 计划表
        * 类型可自定义：如周计划表，月计划表等。
        * 计划项集合
        * 选择的算法
        
    * 计划项
        * 计划的名字
        * 计划类型
        
    * 计划类型
        * 需要记忆
        * 需要思考
        * 等等
    
    * 时间
        * 时间划分
        
    * 生成算法需要考虑的因素
        * 可执行计划时间段的长短
        * 人每个时间段最适合处理什么类型的事
        * 等等