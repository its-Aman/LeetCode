function trailingZeroes(n: number): number {
  return (n < 5) ? 0 : (~~(n / 5) + trailingZeroes(~~(n / 5)));
};