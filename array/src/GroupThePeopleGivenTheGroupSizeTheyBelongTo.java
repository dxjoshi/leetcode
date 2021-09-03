/*
*
* 1282. Group the People Given the Group Size They Belong To
*
* There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
* You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
* Return a list of groups such that each person i is in a group of size groupSizes[i].
* Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
*
* */

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupedMembers = new HashMap<>();       // members grouped by size of the group
        for (int i=0; i< groupSizes.length; i++) {
            if (groupedMembers.containsKey(groupSizes[i])) {
                List<Integer> members = groupedMembers.get(groupSizes[i]);
                members.add(i);
            }  else {
                List<Integer> members = new ArrayList<>();
                members.add(i);
                groupedMembers.put(groupSizes[i], members);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : groupedMembers.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> peoples = entry.getValue();
            for (int i=0; i< peoples.size(); i += key) {
                result.add(peoples.subList(i, i+key));
            }
        }

        return result;
    }
}
