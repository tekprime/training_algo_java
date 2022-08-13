package com.company;

import java.util.*;

class JumpGame {

    public boolean canJumpFromPosition(int position, int[] nums, Map<Integer, Integer> jumps, int dice) {

        boolean[] visited = new boolean[nums.length - 1];

        if (position == nums.length - 1) {
            return true;
        }

      // if(position > nums.length - 1) return false;

        if(jumps.containsKey(position)) position = jumps.get(position);

         visited[position] = true;

        int furthestJump = Math.min(position + dice, nums.length - 1);

        for (int nextPosition = position + 1; nextPosition <= furthestJump ; nextPosition++) {

               if(!visited[nextPosition]) {

                  if (canJumpFromPosition(nextPosition, nums, jumps, dice)) {
                      visited[position] = false;
                      return true;
                  }
             }

        }

        return false;
    }

    public boolean canReach(int position, int[] nums, Map<Integer, Integer> jumps, int dice) {


        Queue<Integer> q = new LinkedList<>();
        q.add(position);
        Set<Integer> visited = new HashSet<>();

        while(!q.isEmpty()) {
         int e = q.remove();

          if (e == nums.length - 1) {
              return true;
          }


        if(jumps.containsKey(e)) e = jumps.get(e);


        int furthestJump = Math.min(e + dice, nums.length - 1);

        for (int nextPosition = e + 1; nextPosition <= furthestJump ; nextPosition++) {

          if (!visited.contains(nextPosition)) {
                q.add(nextPosition);
                visited.add(nextPosition);
           }
        }

        }

        return false;
    }

    public  boolean canJump(int[] nums, Map<Integer, Integer> jumps, int num_dice) {

        return canReach(0, nums, jumps, num_dice);
    }

    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Map<Integer, Integer> jumps = new HashMap<>();
        jumps.put(10,8);
        jumps.put(11, 5);
        jumps.put(12,7);
        jumps.put(13, 9);
       // jumps.put(2, 15);
        int num_dice = 4;

        System.out.println(new JumpGame().canJump(nums, jumps, num_dice));
    }
}
