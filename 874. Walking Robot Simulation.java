class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, xmax = 0, ymax = 0, val = 0;
        int l = commands.length;
        int n = 1, s = 0, w = 0, e = 0;
        for (int i = 0; i < l; i++) {
            val = commands[i];
            if (val < 0) {
                if (val == -1) {
                    if (n == 1) {
                        e = 1;
                        n = 0;
                    } else if (e == 1) {
                        s = 1;
                        e = 0;
                    } else if (s == 1) {
                        w = 1;
                        s = 0;
                    } else if (w == 1) {
                        n = 1;
                        w = 0;
                    }
                } else if (val == -2) {
                    if (s == 1) {
                        w = 1;
                        n = 0;
                    } else if (e == 1) {
                        n = 1;
                        e = 0;
                    } else if (s == 1) {
                        e = 1;
                        s = 0;
                    } else if (w == 1) {
                        s = 1;
                        w = 0;
                    }
                }
            } else {
                if (n == 1) {
                    y = y + val;
                } else if (s == 1) {
                    y = y - val;
                } else if (w == 1) {
                    x = x - val;
                } else if (e == 1) {
                    x = x + val;
                }
                if (x > xmax) {
                    xmax = x;
                }
                if (y > ymax) {
                    ymax = y;
                }
            }
        }
        int res = xmax * xmax + ymax * ymax;
        return res;
    }
}