public class Division {
    public Integer divid(Integer a, Integer b) {
        if (b == 0) {
            return null;
        } else if (a < b) {
            return 0;
        } else if (a > 100) {
            return null;
        } else {
            return a / b;
        }
    }
}
