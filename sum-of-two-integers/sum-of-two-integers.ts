function getSum(a: number, b: number): number {
    return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
};