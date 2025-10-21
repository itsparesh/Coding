class HitCounter {

    private ArrayList<Integer> timeStampList;

    public HitCounter() {
        timeStampList = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        timeStampList.add(timestamp);
        
    }
    
    public int getHits(int timestamp) {
        while (timeStampList.size() > 0 && (timestamp - timeStampList.getFirst()) >= 300) {
            timeStampList.remove(timeStampList.getFirst());
        }
        return timeStampList.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */