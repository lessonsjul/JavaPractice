package algorithms;

import java.util.Arrays;

public class Karazuba {
    private static final int[] STEPEN_OF_TWO = new int[]{2,4,8,16,32,64,128};
    public static final Karazuba ZERO = new Karazuba(0);
    private final int[] value;

    public Karazuba(int intValue) {
        int[] tmpArr;
        int len = intValue == 0 ? 1 : (int)Math.log10(intValue)+1;
        if(len == 1){
            tmpArr = new int[]{intValue};
            this.value = tmpArr;
        }else {
            tmpArr = new int[len];
            int tmpNum = (int) (intValue / Math.pow(10, len - 1));
            for (int k = 0; k < len; k++) {
                tmpArr[k] = tmpNum;
                tmpNum = intValue - tmpNum * (int) Math.pow(10, len - k - 1);
            }
            this.value = tmpArr;
        }
    }

    public Karazuba(String value){
        int[] tmp = new int[value.length()];
        for(int i = 0; i < value.length(); i++)
            tmp[i] = Integer.parseInt(value.substring(i, i+1));

        this.value = tmp;
    }

    public Karazuba(int[] value) {

        this.value = value.length == 0 ? new int[]{0} : value;
    }

    public int[] getValue() {
        return value;
    }

    public int size(){
        return value.length;
    }

    @Override
    public String toString() {
        String num = "";
        for(int el: value)
            num += el;
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Karazuba karazuba = (Karazuba) o;

        return Arrays.equals(value, karazuba.value);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }




    public Karazuba multiply(Karazuba anotherValue){
        int len = Math.max(size(), anotherValue.size());
        if(len == 1){
            int res = value[0]*anotherValue.value[0];
            return new Karazuba(res);
        }

        for(int i = 0; i < STEPEN_OF_TWO.length; i++){
            if(len <= STEPEN_OF_TWO[i]) {
                len = STEPEN_OF_TWO[i];
                break;
            }
        }


        Karazuba a = new Karazuba(this.balancingSize(len));
        Karazuba b = new Karazuba(anotherValue.balancingSize(len));

        Karazuba result = new Karazuba(clearStartZero(karazubaMultiple(a,b).value));

        return result;
    }

    private Karazuba karazubaMultiple(Karazuba x, Karazuba y) {
        int half = x.value.length / 2;

        Karazuba a = x.getLeftPart(half);
        Karazuba b = x.getRightPart(half);
        Karazuba c = y.getLeftPart(half);
        Karazuba d = y.getRightPart(half);

        Karazuba ac = a.multiply(c);
        Karazuba bd = b.multiply(d);
        Karazuba abcd = a.sum(b).multiply(c.sum(d));

        Karazuba abcd1 = abcd.minus(ac).minus(bd);
        Karazuba result = ac.addZeroAtEnd(half*2).sum(abcd1.addZeroAtEnd(half)).sum(bd);

        return result;
    }

    private Karazuba addZeroAtEnd(int numOfZero) {
        int[] result = new int[value.length + numOfZero];
        System.arraycopy(value, 0, result, 0, value.length);

        return new Karazuba(result);
    }

    private Karazuba minus(Karazuba anotherValue) {
        int len = Math.max(value.length, anotherValue.size());

        int[] a = this.balancingSize(len);
        int[] b = anotherValue.balancingSize(len);

        int[] result = new int[len];

        int transfer = 0;
        for(int i = len-1; i>=0; i--){
            int d = a[i] - b[i]- transfer;
            if(d < 0){
                d = d+10;
                transfer = 1;
            }else
                transfer = 0;
            result[i] = d;
        }

        return new Karazuba(result);
    }

    private Karazuba sum(Karazuba anotherValue) {
        int len = Math.max(value.length, anotherValue.size());

        int[] a = this.balancingSize(len);
        int[] b = anotherValue.balancingSize(len);

        int[] result = new int[len];

        int addition = 0;
        for(int i = len-1; i >= 0; i--){
            int d = a[i] + b[i] + addition;
            addition = d / 10;
            result[i] = d - (addition*10);
        }

        if(addition == 0)
            return new Karazuba(result);

        int[] newResult = new int[len+1];
        newResult[0] = addition;
        System.arraycopy(result, 0, newResult, 1, len);

        return new Karazuba(newResult);
    }

    private Karazuba getRightPart(int half) {
        int len = value.length;
        int[] right = Arrays.copyOfRange(value, len-half, len);

        return new Karazuba(right);
    }

    private Karazuba getLeftPart(int half) {
        int rest = value.length - half;
        int[] result = new int[half];
        if(rest == half){
            result = Arrays.copyOf(value, half);
            return new Karazuba(result);
        }

        int n = half - rest;
        System.arraycopy(value, n-1, result, n, rest);
        return new Karazuba(result);
    }

    private int[] balancingSize(int requiredSize) {
        int difer = requiredSize - value.length;

        if(difer <= 0)
            return this.value;

        int[] result = new int[requiredSize];
        System.arraycopy(value, 0, result, difer, value.length);

        return result;
    }

    private int[] clearStartZero(int[] val){
        int vlen = val.length;
        int keep;

        // Find first nonzero byte
        for (keep = 0; keep < vlen && val[keep] == 0; keep++)
            ;
        return keep == 0 ? val : java.util.Arrays.copyOfRange(val, keep, vlen);
    }
}
