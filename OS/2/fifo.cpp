//先进先出
// 初始化一个大小为物理块数的帧数组，用于存储当前在内存中的页面。
// 遍历给定的引用串中的每个页面。
// 对于每个页面，检查它是否已经在帧数组中。如果是，则跳过该页面并继续遍历下一个页面。
// 如果该页面不在帧数组中，则需要进行页面置换。选择最早进入内存的页面进行置换，并用当前页面替换它。
// 重复步骤3和4，直到遍历完引用串中的所有页面。
// 计算缺页次数和缺页率。
