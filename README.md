#### Stream相关操作
map ---- com.zxa.stream.StreamDemo.map();
flatMap ---- com.zxa.stream.StreamDemo.flatMap();
fliter ------com.zxa.stream.StreamDemo.filter();
reduce ------com.zxa.stream.StreamDemo.reduces();
Stream 有三个 match 方法，从语义上说：

allMatch：Stream 中全部元素符合传入的 predicate，返回 true
anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true

参考：https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/

Optional类