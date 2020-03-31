package algorithms;

public class BigO {


    // O(2n) -> O(n)
    public void foo(int[] array) {

        for (int i = 0; i < array.length; i++) {
            // ...
        }

        for (int i = 0; i < array.length; i++) {
            // ...
        }

    }

    //O(m*n)
    public void bar(int[] array1, int[] array2) {

        for (int i = 0; i < array1.length; i++) {
            // ...
            for (int j = 0; j < array2.length; j++) {
                // ...
            }
        }

    }

    //O(n^2)
    public void baz(int[] array) {

        for (int i = 0; i < array.length; i++) { //O(n)
            // ...
            for (int j = 0; j < array.length; j++) { //O(n)
                // ...
                if (array[i] < array[j]) { //-> O(1)
                    // Launch!
                }
            }
        }

    }



    //O(n^2 * 9999999)
    public void beep(int[] array) {

        for (int i = 0; i < array.length; i++) {
            // ...
            for (int j = 0; j < array.length; j++) {
                // ...
                for (int k = 0; k < 9999999; k++) { //-> O(1) because always constant time for amount of loops by 9999999
                    // Jump!
                }
            }
        }

    }

}