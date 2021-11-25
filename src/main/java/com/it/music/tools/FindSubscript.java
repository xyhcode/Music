package com.it.music.tools;

/**
 * 查询下标
 */
public class FindSubscript {

    public static int binarySearch(int[] array,int target){
        int left=0;
        int right=array.length-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2;//中间位置
            if(array[mid]==target){
                return mid;
            }else if(target<array[mid]){//如果目标值小于当前Mid下标位置的值 则在前半区查找
                right=mid-1;
            }else{//反之在后半区查找
                left=mid+1;
            }
        }
        return -1;
    }

    public static int findxb(int[] arr,int soid){
        int wz=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==soid){
                wz=i;
                break;
            }
        }
        return wz;
    }

}
