public class ImageSmoother {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
        int[][] res = s.imageSmoother(img);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int res[][] = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                res[i][j] = smoothen(img, i, j);
            }
        }
        return res;
    }

    int smoothen(int[][] img, int x, int y) {
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                sum += img[nx][ny];
                count++;
            }
        }
        return sum / count;

    }
}
