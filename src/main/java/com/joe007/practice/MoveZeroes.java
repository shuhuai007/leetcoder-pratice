package com.joe007.practice;

/**
 * Created by jiezhou on 8/22/16.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] != nums[j + 1] && nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }

    private void moveZeroes(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return;
        }
        int head = beginIndex;
        int tail = endIndex;
        for (head = beginIndex; head <= endIndex; head ++) {
            if (nums[head] == 0) {
                break;
            }
        }
        System.out.println("head zero:" + head + "; nums[head]:" + nums[head]);

        for (tail = endIndex; tail >= beginIndex; tail --) {
            if (nums[tail] != 0) {
                break;
            }
        }
        System.out.println("tail nonzero:" + tail + "; nums[tail]:" + nums[tail]);

        if (head == (endIndex + 1) || tail == (beginIndex - 1)) {
            return;
        }

        if (head < tail) {
            nums[head] = nums[tail];
            nums[head] = 0;
            moveZeroes(nums, head + 1, tail - 1);
        }
    }
}
