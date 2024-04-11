#include <stdio.h>

int main() {
    int h;
    int rm;
    int rM;
    if (scanf (" %d %d %d", &rM,&h,&rm) == 3) {

        int result = (((3.14 * h)/3) * (rM * rM + rM * rm + rm * rm));
        printf ("%d\n", result);
    }
    return 0;
}