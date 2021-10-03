package Day70;

//BinaryTreeArrayImpl.java
/*
Case 1: (0—n-1)

if (say)father=p;
then left_son=(2*p)+1;
and right_son=(2*p)+2;
Case 2: 1—n

if (say)father=p;
then left_son=(2*p);
and right_son=(2*p)+1;
 */
public class BinaryTreeArrayImpl {

    public static void main(String[] args) {
        ArrayImpl obj = new ArrayImpl();

        obj.Root("A");
        obj.setRight("C", 0);
        obj.setLeft("D", 1);
        obj.setLeft("E", 1);
        obj.setLeft("F", 2);

        obj.printTree();

    }
}

class ArrayImpl {
    static int root = 0;
    static String[] str = new String[10];

    //creating root node
    void Root(String key) {
        str[0] = key;
    }

    //creating left child of root
    void setLeft(String key, int root) {
        int leftIndex = (2 * root) + 1; //In case, when index starts from 0 to n-1, (or 2 * root for index 1 to n)
        if(str[root] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", leftIndex);
        }
        else {
            str[leftIndex] = key;
        }
    }

    //creating right child of root
    void setRight(String key, int root) {
        int rightIndex = (2 * root) + 2; //In case, when index starts from 0 to n-1, (or 2 * root + 1 for index 1 to n)
        if(str[root] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", rightIndex);
        }
        else {
            str[rightIndex] = key;
        }
    }

    //To print our tree
    void printTree() {
        for(int i = 0; i < 10; i++) {
            if (str[i] != null) {
                System.out.print(str[i]);
            }
            else {
                System.out.print("-");
            }
        }
    }
}
