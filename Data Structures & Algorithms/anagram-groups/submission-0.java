class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Hashtable, List<String>> map = new HashMap<Hashtable, List<String>>();
        for(String s : strs){
            Hashtable<Character, Integer> t = new Hashtable<Character, Integer>();
            for (char c : s.toCharArray()){
                t.put(c, t.getOrDefault(c, 0)+1);
            }
            map.computeIfAbsent(t, k -> new ArrayList<>()).add(s); // always modifiable

            /*if(map.containsKey(t)) {
                    List<String> entry = map.get(t);
                    entry.add(s);
                    map.put(t, entry);
                    //map.remove(t);
                    //result.add(entry);
            } else {
                    map.put(t, Arrays.asList(s));
            }*/
        }
        if(!map.isEmpty()){
            result.addAll(map.values());
        }
        return result;
    }
}
