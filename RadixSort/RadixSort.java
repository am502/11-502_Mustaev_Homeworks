public void RadixSort(int[] a) {
    int w = maxDigit(a);
    int r = 10;

    ArrayList<Integer>[] basket = new ArrayList[r];
    for (int i = 0; i < r; i++)
        basket[i] = new ArrayList<Integer>();

    for(int i = 0; i < w; i++){
        for(int j = 0; j < a.length; j++){
            basket[digit(a[j], i)].add(a[j]);
        }

        int k = 0;
        for (int b = 0; b < r; b++) {
            for (int p = 0; p < basket[b].size(); p++) {
                a[k++] = basket[b].get(p);
            }
            basket[b].clear();
        }
    }
}