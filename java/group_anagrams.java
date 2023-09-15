class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map number of each alphabet in string -> O(n)
        // then "immediately" map same values -> still O(n); n is number of total character in all strings

        HashMap<int[], ArrayList<String>> map = new HashMap<int[], ArrayList<String>>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            int[] newKey = new int[26]; 

            for (int i=0; i<s.length(); i++) {
                int alphabet = chars[i]-97; // would start from 97, normalize

                newKey[alphabet] = newKey[alphabet]+1;
            }

            ArrayList<String> newMap = new ArrayList();

            for (int[] arr : map.keySet()) {
                if (Arrays.equals(arr, newKey)) {
                    newMap = map.get(arr);
                    newKey = arr;
                    break;
                }
            }

            newMap.add(s);
            map.put(newKey, newMap);
        }

        return new ArrayList<>(map.values());
    }
}