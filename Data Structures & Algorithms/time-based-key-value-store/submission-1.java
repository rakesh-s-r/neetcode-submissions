class Tmk {
    String val;
    int time;

    public Tmk(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

class TimeMap {
    HashMap<String, List<Tmk>> map = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Tmk(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Tmk> list = map.get(key);
        Optional<Tmk> tmk = search(list, key, timestamp);
        if (tmk.isEmpty()) {
            return "";
        }
        return tmk.get().val;
    }

    public Optional<Tmk> search(List<Tmk> list, String key, int times) {
        System.out.println(list.size());
        int left = 0, right = list.size() - 1;
        Tmk res = null;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).time == times) {
                return Optional.of(list.get(mid));
            }
            if (times > list.get(mid).time) {
                left = mid + 1;
                res = list.get(mid);
            } else {
                right = mid - 1;
            }
        }
        return Optional.ofNullable(res);
    }
}
