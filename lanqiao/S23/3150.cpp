/*
小蓝有一个神奇的炉子用于将普通金属 O 冶炼成为一种特殊金属 X。
这个炉子有一个称作转换率的属性 V，V 是一个正整数，这意味着消耗 V 个普通金属
O 恰好可以冶炼出一个特殊金属 X，当普通金属 O 的数目不足 V 时，无法继续冶炼。
现在给出了 N 条冶炼记录，每条记录中包含两个整数 A 和 B，这表示本次投入了 A 个普通金属 O，
最终冶炼出了 B 个特殊金属 X。每条记录都是独立的，这意味着上一次没消耗完的普通金属 O 不会累加到下一次的冶炼当中。
根据这 N 条冶炼记录，请你推测出转换率 V 的最小值和最大值分别可能是多少，题目保证评测数据不存在无解的情况。
*/
//o/x肯定是当前元素的最大的那一个转换比，在所有最大中找最小的，那么最小的就是最大的那个 max
//最小的应该是o/x+1
//75 3             25 24 23 22 21 20 19
//51 2             25 24 23 22 21 20 19 18 17 
//59 2 29 28 27 26 25 24 23 22 21 20 19
#include <iostream>
using namespace std;

int main()  {
    int n,o,x,min,max;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> o >> x;
        if ()
        {
            /* code */
        }
        
    }
}