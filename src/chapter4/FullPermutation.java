package chapter4;

/**
 * @Author ZyiqueZhou
 * @Date 12/4/2020
 * @Description 递归->全排列->N皇后
 */
public class FullPermutation {
    private static final int MAX_LENGTH = 11;
    private int n;
    private int count = 0;
    //存放当前排列的数组
    private int[] permutation = new int[MAX_LENGTH];
    //存放当前排列的数是否在数组 Permutation 中
    private boolean[] hashTable = new boolean[MAX_LENGTH];

    public FullPermutation(int n) {
        this.n = n;
    }

    public void generatePermutation(int index){

        //递归边界
        if (index == n + 1) {
            //能到达这里一定是合法的
            count++;
            return;
        }

        //递归式
        for (int i = 1; i <= n; i++) {
            //第 i 行还没有皇后
            if (hashTable[i] == false) {
                //用于表示当前的皇后不会和之后的皇后冲突
                boolean flag = true;
                //遍历之前的皇后
                for (int pre = 1; pre < index; pre++) {
                    //第index列皇后的皇后行号为x 第pre列皇后的行号为 permutation[pre]
                    if (Math.abs(index - pre) == Math.abs(i - permutation[pre])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    permutation[index] = i;
                    hashTable[i] = true;
                    generatePermutation(index + 1);
                    hashTable[i] = false;
                }
            }
        }

    }

    public int getCount() {
        return count;
    }
}
