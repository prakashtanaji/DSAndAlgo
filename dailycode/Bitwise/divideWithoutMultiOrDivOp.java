class divWithoutOp
{

    public static void main(String[] args) {

        int dividend = Integer.MAX_VALUE;
        int divisor = Integer.MAX_VALUE -1;


        boolean isSigned = false;
        if((dividend <0 && divisor>0) ||(dividend >0 && divisor<0)) {
            isSigned = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int tempDividend = dividend;

        int quo = 0;

        // 16
        while(tempDividend-divisor >0) {
            // This will be used to keep track of the number of time the divisor is doubled
            int x=0;
            // Try to divide each time doubling the divisor, this will speed up the process
            // In the bit operation when the bits are shifted left the number doubles.
            // The first check will help with numeric overflow                 
            while((divisor<<x)>0 && tempDividend-(divisor<<x)>=0) {
            //while(tempDividend-(divisor<<x)>=0) {
                x++; // 2

            }

            // If the temp dividend is not even divisible thats the end of any more possible divisions, so exit.
            if(x==0) break;

            quo += Math.pow(2, x-1); // 4 + 4 + 4
            tempDividend = tempDividend-(divisor<<x-1);
        }

        System.out.println("Reminder:"+ tempDividend*(isSigned?-1:1)+"Quotient:"+quo);
    }
}