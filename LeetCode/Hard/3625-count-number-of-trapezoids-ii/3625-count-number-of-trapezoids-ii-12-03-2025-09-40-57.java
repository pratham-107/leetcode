import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<String, List<int[]>> slopeGroups = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                
                long dy = p2[1] - p1[1];
                long dx = p2[0] - p1[0];
                
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                
                long g = gcd(Math.abs(dy), Math.abs(dx));
                if (g != 0) {
                    dy /= g;
                    dx /= g;
                }
                
                String key = dy + "," + dx;
                slopeGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        
        int count = 0;
        
        for (List<int[]> group : slopeGroups.values()) {
            // For each group of parallel lines, count pairs that form trapezoids
            // A pair of parallel lines forms a trapezoid if they don't share points and points are not collinear
            int size = group.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] line1 = group.get(i);
                    int[] line2 = group.get(j);
                    
                    int p1 = line1[0], p2 = line1[1];
                    int p3 = line2[0], p4 = line2[1];
                    
                    if (p1 != p3 && p1 != p4 && p2 != p3 && p2 != p4) {
                        // Check if all 4 points are collinear
                        if (!areAllCollinear(points[p1], points[p2], points[p3], points[p4])) {
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean areAllCollinear(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Check if all 4 points lie on the same line
        long area1 = (long)(p2[0] - p1[0]) * (p3[1] - p1[1]) - (long)(p3[0] - p1[0]) * (p2[1] - p1[1]);
        long area2 = (long)(p2[0] - p1[0]) * (p4[1] - p1[1]) - (long)(p4[0] - p1[0]) * (p2[1] - p1[1]);
        return area1 == 0 && area2 == 0;
    }
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}