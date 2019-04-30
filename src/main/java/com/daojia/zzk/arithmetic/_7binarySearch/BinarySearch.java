package com.daojia.zzk.arithmetic._7binarySearch;

/**
 * 二分查找
 *
 */
public class BinarySearch {
    
    public static void main(String[] args){
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        int i = binarySearch(array, array.length, 4);
//        System.out.println(i);
//
//        int result = binarySearch2(array, array.length, 6);
//        System.out.println(result);

        int[] array = {1,2,3,4,4,4,5,6,7,8,9};
//        int firstValue = getFirstValue(array, array.length, 4);
//        System.out.println(firstValue);
//
//        int firstValue2 = getFirstValue2(array, array.length, 4);
//        System.out.println(firstValue2);

//        int lastVale = getLastVale(array, array.length, 4);
//        System.out.println(lastVale);

//        int firstLgValue = getFirstLgValue(array, array.length, 4);
//        System.out.println(firstLgValue);

        int lastLtValue = getLastLtValue(array, array.length, 4);
        System.out.println(lastLtValue);
    }

    private static int binarySearch(int[] array, int n, int value) {
        int low = 0;
        int high = n -1;

        while (low <= high) {
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }

    /**
     *  二分查找的递归实现
     * */
    private static int binarySearch2 (int[] array, int n, int value) {
        return binarySearchInternally(array, 0, n, value);
    }

    private static int binarySearchInternally (int[] array, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);

        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return binarySearchInternally(array, mid+1,high,value);
        } else {
            return binarySearchInternally(array,low,mid-1,value);
        }
    }

    /**
     *  查找第一个值等于给定值的元素
     * */
    private static int getFirstValue (int[] array, int n, int value) {
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high-low) >> 1);
            if (array[mid] >= value) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && array[low] == value) {
            return low;
        }
        else {
            return -1;
        }
    }

    /**
     * 查找第一个值等于给定值的元素，变种2
     * */
    private static int getFirstValue2 (int[] array, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low < high) {
            int mid = low + ((high-low) >> 1);

            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid-1] != value) {
                    return mid;
                } else {
                    high = mid -1;
                }
            }
        }

        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * */
    private static int getLastVale (int[] array, int n, int value) {
        int low = 0;
        int high = n -1 ;
        while (low < high) {
            int mid = low + ((high-low) >> 1);
            if (array[mid] > value) {
                high = mid -1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid+1] != value) {
                    return mid;
                } else {
                    low = mid +1;
                }
            }
        }
        return -1;
    }

    /**
     *查找第一个大于等于给定值的元素
     * */
    private static int getFirstLgValue (int[] array, int n, int value) {
        int low = 0;
        int high = n-1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (array[mid] > value) {
                high = mid -1;
            } else if (array[mid] < value) {
                low = mid  + 1;
            } else {
                if (mid == 0 || array[mid+1] != value) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * */
    private static int getLastLtValue (int[] array, int n, int value) {
        int low = 0;
        int high = n-1;

        while (low < high) {
            int mid = low + ((high-low)>>1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid-1] != value) {
                    return mid-1;
                } else {
                    high = mid -1;
                }
            }
        }

        return -1;
    }

}
