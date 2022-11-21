# Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

# 思路1： 双重循环， 最简单最低效的做法

```java
    public int[] twoSum(int[] nums, int target) {
       int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j= i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                   return new int[] {i, j};
                }
            }
        }
       throw new RuntimeException("No result!");
    }

```

# 思路2: 看到题解说可以用map实现

 以nums[i]为key， i为value， 这里涉及到一次插入,一次查找
 ```java
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component) && map.get(component) != i) {
                return new int[]{i, map.get(component)};
            }
        }
        throw new RuntimeException("No result!");
    }
```

# 思路3: 一次插入， 遍历过程中找寻结果

```java
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[]{i, map.get(component)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No result!");
    }
```
