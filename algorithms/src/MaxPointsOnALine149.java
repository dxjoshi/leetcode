import java.util.TreeMap;

/*
*
* 149. Max Points on a Line
*
* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
*
* */
public class MaxPointsOnALine149 {
        static class Slope implements Comparable<Slope> {
            Double slope;
            public Slope(int diffX, int diffY) {
                if (diffY == 0) this.slope = null;
                else this.slope = 1.0 * diffX / diffY;
            }

            public int compareTo(Slope o) {
                if (this.slope == null || o.slope == null) {
                    if (this.slope == o.slope) return 0;
                    else if (this.slope == null) return -1;
                    else return 1;
                } else if (Math.abs(this.slope - o.slope) < 1e-9) return 0;
                else if (this.slope < o.slope) return -1;
                else return 1;
            }
        }

        public int maxPoints(int[][] points) {

            int maxAns = 1;
            for (int i = 0; i < points.length; i++) {
                int candidateX = points[i][0];
                int candidateY = points[i][1];
                TreeMap<Slope, Integer> slopesMap = new TreeMap();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) continue;
                    int targetX = points[j][0];
                    int targetY = points[j][1];
                    Slope curSlope = new Slope(candidateX - targetX, candidateY - targetY);
                    int curCnt = slopesMap.get(curSlope) == null ? 1 : slopesMap.get(curSlope) + 1;
                    slopesMap.put(curSlope, curCnt);
                    maxAns = Math.max(maxAns, curCnt + 1);
                }
            }
            return maxAns;
        }
    }
