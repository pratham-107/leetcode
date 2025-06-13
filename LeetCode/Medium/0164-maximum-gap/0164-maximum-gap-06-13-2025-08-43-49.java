class Bucket {
    public int mn;
    public int mx;

    public Bucket(int mn, int mx) {
        this.mn = mn;
        this.mx = mx;
    }
}

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int mn = Arrays.stream(nums).min().getAsInt();
        int mx = Arrays.stream(nums).max().getAsInt();
        if (mn == mx) return 0;

        // Calculate the gap
        int gap = (int) Math.ceil((double) (mx - mn) / (nums.length - 1));
        int bucketLength = (mx - mn) / gap + 1;
        Bucket[] buckets = new Bucket[bucketLength];

        // Initialize buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Place numbers into buckets
        for (int x : nums) {
            int i = (x - mn) / gap;
            buckets[i].mn = Math.min(buckets[i].mn, x);
            buckets[i].mx = Math.max(buckets[i].mx, x);
        }

        // Calculate the maximum gap
        int ans = 0;
        int prevMax = mn;

        for (Bucket bucket : buckets) {
            if (bucket.mn == Integer.MAX_VALUE) continue; // Skip empty buckets
            ans = Math.max(ans, bucket.mn - prevMax);
            prevMax = bucket.mx;
        }
        return ans;
    }
}
