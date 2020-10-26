package LeetCode.Algorithm;

/**
 * @Author: Wdz
 * @Date 2020/10/25 16:01
 * @Description: TODO 归并排序
 * https://blog.csdn.net/lishanleilixin/article/details/88603811
 */
public class MergeSort2 {

    /**
     * 从上到下
     * @param elem
     * @param start
     * @param end
     */
    public void mergeSortUp2Down(int[] elem, int start, int end) {
        if(elem == null || start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSortUp2Down(elem, start, mid);
        mergeSortUp2Down(elem, mid + 1, end);

        merge(elem, start, mid, end);
    }


    /**
     * 从下到上
     * @param elem
     */
    public void mergeSortDown2Up(int[] elem) {

        if(elem == null) return;

        for (int i = 1; i < elem.length; i *= 2) {
            mergeGroups(elem, elem.length, i);
        }
    }

    public void mergeGroups(int[] elem, int len, int gap) {
        int i;
        for (i = 0; i + 2 * gap -1 < len; i += (2 * gap)) {
            merge(elem, i, i + gap -1, i + 2 * gap -1);
        }

        if(i + gap -1 < len - 1) {
            merge(elem, i, i + gap - 1, len - 1);
        }
    }


    /**
     * 非递归
     * @param elem
     */
    public void mergeSortNon(int[] elem) {
        int gap = 1;
        while(gap <= elem.length) {
            for (int i = 0; i + gap < elem.length; i += (gap * 2)) {
                int start = i, mid = i + gap -1, end = i + 2 * gap -1;
                if(end > elem.length - 1) {
                    end = elem.length - 1;
                }
                merge(elem, start, mid, end);
            }
            gap *= 2;
        }
    }

    public void merge(int[] elem, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end) {
            if(elem[i] < elem[j]) {
                temp[k++] = elem[i++];
            }
            else {
                temp[k++] = elem[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = elem[i++];
        }

        while(j <= end) {
            temp[k++] = elem[j++];
        }

        for (i = 0; i < k; i++) {
            elem[start + i] = temp[i];
        }
        temp = null;
    }

    public static void main(String[] args) {
        MergeSort2 t = new MergeSort2();
        int[] elem = {80,30,60,40,20,10,50,70};

        t.mergeSortUp2Down(elem, 0, elem.length - 1); //从上到下

//		t.mergeSortDown2Up(elem); //从下到上

//		t.mergeSortNon(elem);  //非递归

        for (int i = 0; i < elem.length; i++) {
            System.out.print(elem[i] + ", ");
        }
    }
}

